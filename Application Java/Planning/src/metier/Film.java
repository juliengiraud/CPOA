package metier;

import java.util.ArrayList;

public class Film {
     
    private String duree;
    private String titre;
    private int filmID;
    private Categorie categorie;
    private ArrayList<Personne> realisateurs;
    
    public Film(String newDuree, String newTitre, int newID, Categorie newCate, ArrayList<Personne> newRealisateurs) {
        this.duree = newDuree;
        this.titre = newTitre;
        this.filmID = newID;
        this.categorie = newCate;
        this.realisateurs = newRealisateurs;
    }
    
    public String getDuree() {
        return this.duree;
    }
    
    public void setDuree(String newDuree) {
        this.duree = newDuree;
    }
    
    public String getTitre() {
        return this.titre;
    }
    
    public void setTitre(String newTitre) {
        this.titre = newTitre;
    }
    
    public int getFilmID() {
        return this.filmID;
    }
    
    public void setFilmID(int newFilmID) {
        this.filmID = newFilmID;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }
    
    public void setCategorie(Categorie newCategorie) {
        this.categorie = newCategorie;
    }
    
    public String toString() {
        return "Titre : " + this.titre + ", Durée : " + this.duree + ", FilmID : " + this.filmID + ", Catégorie : " + this.categorie.toString() + ", Réalisateurs : " + this.realisateurs.toString();
    }

}
