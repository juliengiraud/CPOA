package metier;

public class Traitement {
    
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
        
    }

}
