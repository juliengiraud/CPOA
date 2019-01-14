package metier;

import java.sql.SQLException;
import java.util.List;
import persistance.modelDAO.*;

public class Traitement {
    
    //La première projection est un jeudi
    private static List<Projection> projections;
    
    public Traitement() throws SQLException {
        ProjectionDAO projectionDAO = new ProjectionDAO();
        Traitement.projections = projectionDAO.getProjections();
    }
    
    public static void genererPlaning() {
        System.out.println("Générer le planing");
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
