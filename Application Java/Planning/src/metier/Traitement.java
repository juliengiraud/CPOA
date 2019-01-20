package metier;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import persistance.modelDAO.*;
import vue.MaCellule;
import vue.Main;
import vue.NewJFrame;

public class Traitement {
    
    private static ProjectionDAO projectionDAO = null;
    private static List<Projection> projections = null;
    private static List<Projection> projectionsAffichables = null;
    private static FilmDAO filmDAO = null;
    private static List<Film> films = null;
    private static CategorieDAO categorieDAO = null;
    private static List<Categorie> categories = null;
    private static SalleDAO salleDAO = null;
    private static List<Salle> salles = null;
    private static String[] heuresCM = {"09h00", "09h30", "10h00", "10h30", "11h00", "11h30", "12h00", "12h30", "13h00", "13h30", "14h00", "14h30", "15h00", "15h30", "16h00", "16h30", "17h00", "17h30", "18h00", "18h30", "19h00", "19h30", "20h00", "20h30"};
    private static String[] heuresLM = {"09h00", "12h30", "16h00", "19h30"};
    
    public Traitement() throws SQLException {
        Traitement.projectionDAO = new ProjectionDAO();
        //Traitement.projections = projectionDAO.getProjections();
        Traitement.filmDAO = new FilmDAO();
        Traitement.films = filmDAO.getLesFilms();
        Traitement.categorieDAO = new CategorieDAO();
        Traitement.categories = categorieDAO.getLesCategories();
        Traitement.salleDAO = new SalleDAO();
        Traitement.salles = salleDAO.getSalles();
    }
    
    public static void genererPlaning() throws SQLException {
        //System.out.println("Générer le planning");
        projectionDAO.supprimerProjections();
        String dateLM;
        int nbFilmCM = 0, nbFilmLMC = 0, nbFilmLM = 0, nbFilmUCR = 0, date, heure, i = 0;
        Salle salle = null, salle2 = null;
        List<Film> file = new ArrayList<>();
        for (Film film : films) {
            //System.out.println("For film : " + ++i);
            switch (film.getCategorie().getType()) {
                case "LONG METRAGE EN COMPETITION": // Théâtre Lumière, seance du lendemain a Soixantième
                    // 3 par jour max
                    // 2 par jour min
                    // 2 fois par jour
                    // Tout doit etre place dans les 11 premiers jours
                    // Seance du lendemain
                    for (Salle s : salles) {
                        if (s.getSalleID() == 0) {
                            salle = s;
                        }
                        if (s.getSalleID() == 3) {
                            salle2 = s;
                        }
                    }
                    date = 9 + (nbFilmLMC/2);
                    heure = (nbFilmLMC%2);
                    dateLM = intToString(date) + "/05/2019";
                    projectionDAO.ajouterProjection(dateLM, heuresLM[heure], true, salle, film);
                    projectionDAO.ajouterProjection(dateLM, heuresLM[(heure + 2)%4], true, salle, film);
                    projectionDAO.ajouterProjection(intToString(date + 1) + "/05/2019", heuresLM[heure], true, salle2, film);
                    nbFilmLMC = nbFilmLMC + 1;
                    break;
                
                case "COURT METRAGE EN COMPETITION": // Buñuel
                    // Projete une seule fois
                    // Tout le meme jour
                    for (Salle s : salles) {
                        if (s.getSalleID() == 2) {
                            salle = s;
                        }
                    }
                    projectionDAO.ajouterProjection("09/05/2019", heuresCM[nbFilmCM++], true, salle, film);
                    break;
                
                case "UN CERTAIN REGARD": // Debussy, seance du lendemain a Bazin
                    // 4 par jour max
                    // Tout doit etre place dans les 9 premiers jours
                    // Seance du lendemain
                    for (Salle s : salles) {
                        if (s.getSalleID() == 1) {
                            salle = s;
                        }
                        if (s.getSalleID() == 4) {
                            salle2 = s;
                        }
                    }
                    date = 9 + (nbFilmUCR/4);
                    heure = (nbFilmUCR%4);
                    dateLM = intToString(date) + "/05/2019";
                    projectionDAO.ajouterProjection(dateLM, heuresLM[heure], true, salle, film);
                    projectionDAO.ajouterProjection(intToString(date + 1) + "/05/2019", heuresLM[heure], true, salle2, film);
                    nbFilmUCR = nbFilmUCR + 1;
                    break;
                
                case "LONG METRAGE HORS COMPETITION": // Théâtre Lumière
                    // Projete 1 ou 2 fois
                    // On va les traiter une fois les LMC tous ajoutés
                    file.add(film);
                    break;
            } // Fin du switch
            
        } // Fin du for
        for (Film f : file) {
            //Compléter les séances du théâtre Lumière
            for (Salle s : salles) {
                if (s.getSalleID() == 0) {
                    salle = s;
                }
            }
            date = 9 + nbFilmLMC/2 + 1 + nbFilmLM/4;
            heure = nbFilmLM%4;
            dateLM = intToString(date) + "/05/2019";
            projectionDAO.ajouterProjection(dateLM, heuresLM[heure], false, salle, f);
            nbFilmLM = nbFilmLM + 1;
        }
        updateProjection();
        selectionnerSeance(null);
    }

    public static void rechercherFilm(String nomFilm) {
        Film[] ftab;
        NewJFrame f = Main.getFenetre();
        List<Film> maListe = new ArrayList<>();
        ArrayList<Film> tmp = new ArrayList<>();
        int i;
        if (nomFilm.length() > 0) {
            List<Film> fs = Traitement.filmDAO.getLesFilmsByTitre(nomFilm);
            for (i = 0; i < fs.size(); i++) {
                maListe.add(fs.get(i));
            }
        }
        else {
            maListe = films;
        }
        for (i = 0; i < maListe.size(); i++) {
            switch(maListe.get(i).getCategorie().getType()) {
                case "LONG METRAGE EN COMPETITION": // Théâtre Lumière, seance du lendemain a Soixantième
                    if (f.get_jLabelSalle().getText().substring(8).equals("Grand Théâtre Lumière")) {
                        tmp.add(maListe.get(i));
                    }
                    else if (f.get_jLabelSalle().getText().substring(8).equals("Soixantième")) {
                        tmp.add(maListe.get(i));
                    }
                    break;

                case "COURT METRAGE EN COMPETITION": // Buñuel
                    if (f.get_jLabelSalle().getText().substring(8).equals("Buñuel")) {
                        tmp.add(maListe.get(i));
                    }
                    break;

                case "UN CERTAIN REGARD": // Debussy, seance du lendemain a Bazin
                    if (f.get_jLabelSalle().getText().substring(8).equals("Debussy")) {
                        tmp.add(maListe.get(i));
                    }
                    else if (f.get_jLabelSalle().getText().substring(8).equals("Bazin")) {
                        tmp.add(maListe.get(i));
                    }
                    break;

                case "LONG METRAGE HORS COMPETITION": // Théâtre Lumière
                    if (f.get_jLabelSalle().getText().substring(8).equals("Grand Théâtre Lumière")) {
                        tmp.add(maListe.get(i));
                    }
                    break;
            }
        }
        ftab = new Film[tmp.size()];
        for (i = 0; i < tmp.size(); i++) {
            ftab[i] = tmp.get(i);
        }
        f.get_jComboBoxResultatRecherche().setModel(new javax.swing.DefaultComboBoxModel<>(ftab));
    }

    public static void voirSeanceLibre(Boolean etat) {
        System.out.println(etat ? "Voir les séances libres" : "Voir toutes les séances");
    }

    public static void selectionnerSalle(String salle) {
        if (!salle.equals("Sélectionner une salle")) {
            System.out.println("Affichage des séances de la salle " + salle);
        }
        else {
            System.out.println("Affichage de toutes les séances");
        }
    }
    
    public static void selectionnerDate(String date) {
        if (!date.equals("Sélectionner une date")) {
            System.out.println("Affichage des séances du " + date);
        }
        else {
            System.out.println("Affichage de toutes les séances");
        }
    }
    
    public static void selectionnerSeance(java.awt.event.MouseEvent evt) {
        NewJFrame f = Main.getFenetre();
        JTable jTablePlanning = f.get_jTablePlanning();
        int x, y;
        if (evt == null) {
            x = Main.getX();
            y = Main.getY();
        }
        else {
            x = jTablePlanning.columnAtPoint(evt.getPoint());
            Main.setX(x);
            y = jTablePlanning.rowAtPoint(evt.getPoint());
            Main.setY(y);
        }
        if (jTablePlanning.getModel().getValueAt(y, x) != null) {
            MaCellule c = (MaCellule) jTablePlanning.getModel().getValueAt(y, x);
            if (c.getProjection() != null) {
                Projection p = c.getProjection();
                f.get_jLabelCategorie().setText("Catégorie : " + p.getFilm().getCategorie().getType());
                f.get_jLabelCategorie().setVisible(true);
                
                f.get_jLabelDate().setText("Date : " + p.getDateProjection());
                f.get_jLabelDate().setVisible(true);
                
                f.get_jLabelDuree().setText("Durée : " + p.getFilm().getDuree());
                f.get_jLabelDuree().setVisible(true);
                
                f.get_jLabelHeure().setText("Heure : " + p.getHeureProjection());
                f.get_jLabelHeure().setVisible(true);
                
                f.get_jLabelRealisateurs().setText("Réalisateur(s) : " + p.getFilm().getRealisateursToString());
                f.get_jLabelRealisateurs().setVisible(true);
                
                f.get_jLabelSalle().setText("Salle : " + p.getSalle().getNom());
                f.get_jLabelSalle().setVisible(true);
                
                f.get_jLabelSalleCapacite().setText("Capacité : " + p.getSalle().getCapacite() + " personnes");
                f.get_jLabelSalleCapacite().setVisible(true);
                
                f.get_jLabelTitre().setText("Titre : " + p.getFilm().getTitre());
                f.get_jLabelTitre().setVisible(true);
                
                f.get_jButtonSupprimerAjouterSeance().setText("Supprimer la séance");
                f.get_jButtonSupprimerAjouterSeance().setVisible(true);
                
                f.get_jButtonRechercherFilm().setVisible(false);
                f.get_textFieldRecherche().setVisible(false);
                f.get_jComboBoxResultatRecherche().setVisible(false);
                f.get_jComboBoxResultatRecherche().setVisible(false);
            }
            else if (c.getIsProjection()) {
                //System.out.println(c.toString());
                f.get_jLabelCategorie().setVisible(false);
                f.get_jLabelDuree().setVisible(false);
                f.get_jLabelRealisateurs().setVisible(false);
                f.get_jLabelTitre().setVisible(false);
                
                f.get_jButtonRechercherFilm().setVisible(true);
                f.get_textFieldRecherche().setVisible(true);
                f.get_jComboBoxResultatRecherche().setVisible(true);
                
                String date = null;
                if (y < 5 || y > 11 && y > 18 || y > 25 && y < 51 || y > 52 && y < 58 || y > 65 && y < 71) {
                    switch(x) {
                        case 0:
                            date = "09/05/2019";
                            break;
                        case 1:
                            date = "10/05/2019";
                            break;
                        case 2:
                            date = "11/05/2019";
                            break;
                        case 3:
                            date = "12/05/2019";
                            break;
                        case 4:
                            date = "13/05/2019";
                            break;
                        case 5:
                            date = "14/05/2019";
                            break;
                        case 6:
                            date = "15/05/2019";
                            break;
                    }
                }
                else {
                    switch(x) {
                        case 0:
                            date = "16/05/2019";
                            break;
                        case 1:
                            date = "17/05/2019";
                            break;
                        case 2:
                            date = "18/05/2019";
                            break;
                        case 3:
                            date = "19/05/2019";
                            break;
                        case 4:
                            date = "20/05/2019";
                            break;
                        case 5:
                            date = "21/05/2019";
                            break;
                        case 6:
                            date = "22/05/2019";
                            break;
                        
                    }
                }
                f.get_jLabelDate().setText("Date : " + date);
                f.get_jLabelDate().setVisible(true);
                
                String heure = null;
                if (y == 1 || y == 7 || y == 14 || y == 20 || y == 54 || y == 60 || y == 67 || y == 73) {
                    heure = "09h00";
                }
                else if (y == 2 || y == 8 || y == 15 | y == 21 || y == 55 || y == 61 || y == 68 || y == 74) {
                    heure = "12h30";
                }
                else if (y == 3 || y == 9 || y == 16 || y == 22 || y == 56 || y == 62 || y == 69 || y == 75) {
                    heure = "16h00";
                }
                else if (y == 4 || y == 10 || y == 17 || y == 23 || y == 57 || y == 63 || y == 70 || y == 76) {
                    heure = "19h30";
                }
                else if (y >= 27 && y < 51) {
                    heure = heuresCM[y-27];
                }
                f.get_jLabelHeure().setText("Heure : " + heure);
                f.get_jLabelHeure().setVisible(true);
                
                int salleID;
                if (y < 11) {
                    salleID = 0;
                }
                else if (y < 24) {
                    salleID = 1;
                }
                else if (y < 51) {
                    salleID = 2;
                }
                else if (y < 64) {
                    salleID = 3;
                }
                else {
                    salleID = 4;
                }
                Salle s = null;
                for (Salle salle : salles) {
                    if (salle.getSalleID() == salleID) {
                        s = salle;
                    }
                }
                f.get_jLabelSalle().setText("Salle : " + s.getNom());
                f.get_jLabelSalle().setVisible(true);
                
                f.get_jLabelSalleCapacite().setText("Capacité : " + s.getCapacite());
                f.get_jLabelSalleCapacite().setVisible(true);
                
                f.get_jButtonSupprimerAjouterSeance().setText("Ajouter la séance");
                f.get_jButtonSupprimerAjouterSeance().setVisible(true);
                
                rechercherFilm("");
            }
            else {
                f.get_jLabelCategorie().setVisible(false);
                f.get_jLabelDate().setVisible(false);
                f.get_jLabelDuree().setVisible(false);
                f.get_jLabelHeure().setVisible(false);
                f.get_jLabelRealisateurs().setVisible(false);
                f.get_jLabelSalle().setVisible(false);
                f.get_jLabelSalleCapacite().setVisible(false);
                f.get_jLabelTitre().setVisible(false);
                f.get_jButtonSupprimerAjouterSeance().setVisible(false);
                f.get_jButtonRechercherFilm().setVisible(false);
                f.get_textFieldRecherche().setVisible(false);
                f.get_jComboBoxResultatRecherche().setVisible(false);
                f.get_jComboBoxResultatRecherche().setVisible(false);
            }
        }
        else {
            f.get_jLabelCategorie().setVisible(false);
            f.get_jLabelDate().setVisible(false);
            f.get_jLabelDuree().setVisible(false);
            f.get_jLabelHeure().setVisible(false);
            f.get_jLabelRealisateurs().setVisible(false);
            f.get_jLabelSalle().setVisible(false);
            f.get_jLabelSalleCapacite().setVisible(false);
            f.get_jLabelTitre().setVisible(false);
            f.get_jButtonSupprimerAjouterSeance().setVisible(false);
            f.get_jButtonRechercherFilm().setVisible(false);
            f.get_textFieldRecherche().setVisible(false);
            f.get_jComboBoxResultatRecherche().setVisible(false);
            f.get_jComboBoxResultatRecherche().setVisible(false);
        }
        
    }

    public static void supprimerAjouterSeance(ActionEvent evt) {
        NewJFrame f = Main.getFenetre();
        JTable jTablePlanning = f.get_jTablePlanning();
        int x = Main.getX();
        int y = Main.getY();
        MaCellule c = (MaCellule) jTablePlanning.getModel().getValueAt(y, x);
        if (c.getProjection() != null) { // Mode supprimerProjection
            Projection p = c.getProjection();
            projectionDAO.supprimerProjection(p.getProjectionID());
            c.setProjection(null);
            Main.getFenetre().get_jTablePlanning().updateUI();
        }
        else { // Mode ajouterProjection
            Salle salle = null;
            String date = f.get_jLabelDate().getText().substring(7);
            String heure = f.get_jLabelHeure().getText().substring(8);
            for (Salle s : salles) {
                if (s.getNom().equals(f.get_jLabelSalle().getText().substring(8))) {
                    salle = s;
                }
            }
            Film film = (Film) f.get_jComboBoxResultatRecherche().getSelectedItem();
            int o = film.getCategorie().getCategorieID();
            boolean officielle = (o == 0 || o == 1 || o == 2 || o == 6);
            
            projectionDAO.ajouterProjection(date, heure, officielle, salle, film);
            //System.out.println("Ajout de la projection...");
            updateProjection();
        }
    }
    
    public static void updateProjection() {
        
        List<String> arrayDate = projectionDAO.getDates();
        String[] dates = new String[arrayDate.size() + 1];
        dates[0] = "Sélectionner une date";
        for (int i = 1; i < arrayDate.size() + 1; i++) {
            dates[i] = arrayDate.get(i - 1);
        }
        Main.getFenetre().get_jComboBoxSelectionnerDate().setModel(new javax.swing.DefaultComboBoxModel<>(dates));
        int date = 0, x = 0, y = 0, j = 0;
        projections = projectionDAO.getProjections();
        for (Projection p : projections) {
            //System.out.println("Projection : " + ++j);
            date = 10 * (p.getDateProjection().charAt(0) - 48) + (p.getDateProjection().charAt(1) - 48);
            x = (date + 5)%7;
            switch(p.getSalle().getSalleID()) {
                case 0: // Grand Théâtre Lumière
                    for (int i = 0; i < heuresLM.length; i++) {
                        if (p.getHeureProjection().equals(heuresLM[i])) {
                            y = (date < 16) ? i + 1 : i + 7;
                        }
                    }
                    break;
                
                case 1: // Debussy
                    for (int i = 0; i < heuresLM.length; i++) {
                        if (p.getHeureProjection().equals(heuresLM[i])) {
                            y = (date < 16) ? i + 14 : i + 20;
                        }
                    }
                    break;
                
                case 2: // Buñuel
                    for (int i = 0; i < heuresCM.length; i++) {
                        if (p.getHeureProjection().equals(heuresCM[i])) {
                            y = i + 27;
                        }
                    }
                    break;
                
                case 3: // Soixantième
                    for (int i = 0; i < heuresLM.length; i++) {
                        if (p.getHeureProjection().equals(heuresLM[i])) {
                            y = (date < 16) ? i + 54 : i + 60;
                        }
                    }
                    break;
                
                case 4: // Bazin
                    for (int i = 0; i < heuresLM.length; i++) {
                        if (p.getHeureProjection().equals(heuresLM[i])) {
                            y = (date < 16) ? i + 67 : i + 73;
                        }
                    }
                    break;
                
            }
            MaCellule mm = (MaCellule) Main.getFenetre().get_jTablePlanning().getModel().getValueAt(y, x);
            mm.setProjection(p);
            //System.out.println(mm.toString());
        }
        
        Main.getFenetre().get_jTablePlanning().updateUI();
    }

    private static String intToString(int date) {
        String sdate;
        int nb1 = 0, nb2 = 0;
        if (date < 10) {
            sdate = "0" + date;
        }
        else {
            sdate = "" + date;
        }
        return sdate;
    }
    
    
    public static ProjectionDAO getProjectionDAO() {
        return Traitement.projectionDAO;
    }
    
    public static List<Projection> getProjections() {
        return Traitement.projections;
    }
    
    public static List<Film> getFilms() {
        return Traitement.films;
    }

}
