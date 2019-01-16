package metier;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistance.modelDAO.*;
import vue.Main;

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
        Traitement.projections = projectionDAO.getProjections();
        Traitement.filmDAO = new FilmDAO();
        Traitement.films = filmDAO.getLesFilms();
        Traitement.categorieDAO = new CategorieDAO();
        Traitement.categories = categorieDAO.getLesCategories();
        Traitement.salleDAO = new SalleDAO();
        Traitement.salles = salleDAO.getSalles();
    }
    
    public static void genererPlaning() throws SQLException {
        System.out.println("Générer le planning");
        projectionDAO.supprimerProjections();
        String dateLM;
        int nbFilmCM = 0, nbFilmLMC = 0, nbFilmUCR = 0, date, heure, i = 0;
        Salle salle = null, salle2 = null;
        List<Film> file = new ArrayList<>();
        for (Film film : films) {
            System.out.println("For film : " + ++i);
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
            }
            for (Film f : file) {
                //Compléter les séances du théâtre Lumière
            }
        }
        System.out.println("Appel de update");
        updateProjection();
        
    }

    public static void rechercherFilm(String film) {
        System.out.println("Rechercher le film : " + film);
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
    
    public static void updateProjection() {
        
        List<String> arrayDate = projectionDAO.getDates();
        String[] dates = new String[arrayDate.size() + 1];
        dates[0] = "Sélectionner une date";
        for (int i = 1; i < arrayDate.size() + 1; i++) {
            dates[i] = arrayDate.get(i - 1);
        }
        Main.getFenetre().get_jComboBoxSelectionnerDate().setModel(new javax.swing.DefaultComboBoxModel<>(dates));
        System.out.println("Debut de update");
        int date = 0, x = 0, y = 0, j = 0;
        List<Projection> ps = projectionDAO.getProjections();
        for (Projection p : ps) {
            System.out.println("Projection : " + ++j);
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
            Main.getFenetre().get_jTablePlanning().getModel().setValueAt(p.toString(), y, x);
        }
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

}
