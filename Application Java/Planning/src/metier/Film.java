package metier;

import java.util.List;

public class Film {
     
    private String duree;
    private String titre;
    private int filmID;
    private Categorie categorie;
    private List<Personne> realisateurs;
    
    public Film(String newDuree, String newTitre, int newID, Categorie newCate, List<Personne> newRealisateurs) {
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
    
    @Override
    public String toString() {
        return "Titre : " + this.titre + ", Durée : " + this.duree + ", FilmID : " + this.filmID + ", Catégorie : " + this.categorie.toString() + ", Réalisateurs : " + this.realisateurs.toString();
    }

    String getRealisateursToString() {
        String r = "";
        for (int i = 0; i < realisateurs.size(); i ++) {
            Personne p = realisateurs.get(i);
            if (i == 0) {
                r = r + p.getPrenom() + " " + p.getNom();
            }
            else {
                r = r + ", " + p.getPrenom() + " " + p.getNom();
            }
        }
        return r;
    }

}
