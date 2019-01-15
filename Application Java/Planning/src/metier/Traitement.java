package metier;

import java.sql.SQLException;
import java.util.List;
import persistance.modelDAO.*;
import vue.Main;

public class Traitement {
    
    private static ProjectionDAO projectionDAO = null;
    private static List<Projection> projections = null;
    private static List<Projection> projectionsAffichables = null;
    
    public Traitement() throws SQLException {
        if (Traitement.projections == null) {
            Traitement.projectionDAO = new ProjectionDAO();
            Traitement.projections = Traitement.projectionDAO.getProjections();
        }
    }
    
    public static void genererPlaning() throws SQLException {
        System.out.println("Générer le planning");
        
        FilmDAO filmDAO = new FilmDAO();
        List<Film> films = filmDAO.getLesFilms();
        
        
        
    }
    
    public static void updateProjection() {
        int date = 0, x = 0;
        int[] y = {-1, -1, -1, -1, -1, -1, -1};
        for (Projection p : projectionsAffichables) {
            date = 10 * (p.getDateProjection().charAt(0) - 48) + (p.getDateProjection().charAt(1) - 48);
            x = (date + 1)%7;
            y[x] = y[x] + 1;
            Main.getFenetre().get_jTablePlanning().getModel().setValueAt(p.toString(), y[x], x);
        }
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

}
