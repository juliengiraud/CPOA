package metier;

import java.sql.SQLException;
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
    
    public Traitement() throws SQLException {
        if (Traitement.projectionDAO == null) {
            Traitement.projectionDAO = new ProjectionDAO();
            Traitement.projections = projectionDAO.getProjections();
        }
        if (Traitement.filmDAO == null) {
            Traitement.filmDAO = new FilmDAO();
            Traitement.films = filmDAO.getLesFilms();
        }
        if (Traitement.categorieDAO == null) {
            Traitement.categorieDAO = new CategorieDAO();
            Traitement.categories = categorieDAO.getLesCategories();
        }
        if (Traitement.salleDAO == null) {
            Traitement.salleDAO = new SalleDAO();
            Traitement.salles = salleDAO.getSalles();
        }
    }
    
    public static void genererPlaning() throws SQLException {
        System.out.println("Générer le planning");
        projectionDAO.supprimerProjections();
        String[] heuresCM = {"9h", "9h30", "10h", "10h30", "11h", "11h30", "12h", "12h30", "13h", "13h30", "14h", "14h30", "15h", "15h30", "16h", "16h30", "17h", "17h30", "18h", "18h30", "19h", "19h30", "20h", "20h30"};
        String[] heuresLM = {"9h", "12h30", "16h", "19h30"};
        String dateLM;
        int nbFilmCM = 0, nbFilmLMC = 0, date, heure;
        Salle salle = null, salle2 = null;
        for (Film film : films) {
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
                    break;
                
                case "LONG METRAGE HORS COMPETITION": // Théâtre Lumière
                    // Projete 1 ou 2 fois
                    break;
                
                //case "COURT METRAGE HORS COMPETITION":
                    // Tout doit etre place le 1er jour
                    // Projete 1 ou 2 fois
                    //break;
                
                //case "SEANCE DE MINUIT": // pas de salle
                    // Projete une seule fois
                    //break;
                
                //case "CAMERA D'OR":
                    // Projete une seule fois
                    //break;
            }
        }
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
        int date, x, y;
        String[] heuresCM = {"9h00", "9h30", "10h", "10h30", "11h00", "11h30", "12h00", "12h30", "13h00", "13h30", "14h00", "14h30", "15h00", "15h30", "16h00", "16h30", "17h00", "17h30", "18h00", "18h30", "19h00", "19h30", "20h00", "20h30"};
        String[] heuresLM = {"9h00", "12h30", "16h00", "19h30"};
        /*
        for (Projection p : projectionsAffichables) {
            date = 10 * (p.getDateProjection().charAt(0) - 48) + (p.getDateProjection().charAt(1) - 48);
            x = (date + 1)%7;
            y[x] = y[x] + 1;
            Main.getFenetre().get_jTablePlanning().getModel().setValueAt(p.toString(), y[x], x);
        }*/
        List<Projection> ps = projectionDAO.getProjections();
        for (Projection p : ps) {
            switch(p.getSalle().getSalleID()) {
                case 0: // Grand Théâtre Lumière
                    date = 10 * (p.getDateProjection().charAt(0) - 48) + (p.getDateProjection().charAt(1) - 48);
                    x = (date + 5)%7;
                    y = 0;
                    for (int i = 0; i < heuresLM.length; i++) {
                        if (p.getHeureProjection().equals(heuresLM[i])) {
                            if (date < 16) {
                                y = i + 1;
                            }
                            else {
                                y = i + 7;
                            }
                        }
                    }
                    Main.getFenetre().get_jTablePlanning().getModel().setValueAt(p.toString(), y, x);
                    break;
                
                case 1: // Debussy
                    break;
                
                case 2: // Buñuel
                    break;
                
                case 3: // Soixantième
                    date = 10 * (p.getDateProjection().charAt(0) - 48) + (p.getDateProjection().charAt(1) - 48);
                    x = (date + 5)%7;
                    y = 0;
                    for (int i = 0; i < heuresLM.length; i++) {
                        if (p.getHeureProjection().equals(heuresLM[i])) {
                            if (date < 16) {
                                y = i + 54;
                            }
                            else {
                                y = i + 60;
                            }
                        }
                    }
                    Main.getFenetre().get_jTablePlanning().getModel().setValueAt(p.toString(), y, x);
                    break;
                
                case 4: // Bazin
                    break;
                
            }
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

}
