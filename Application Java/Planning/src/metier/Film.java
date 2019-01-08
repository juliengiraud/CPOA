package metier;

import java.util.ArrayList;

public class Film {
     
    private String duree;
    private String titre;
    private int filmID;
    private Categorie categorie;
    private ArrayList<Realisateur> realisateurs;
    
    public Film(String newDuree, String newTitre, int newID, Categorie newCate, Realisateur newRea1, Realisateur newRea2, Realisateur newRea3) {
          this.duree = newDuree;
          this.titre = newTitre;
          this.filmID = newID;
          this.categorie = newCate;
          this.realisateurs.add(newRea1);
          this.realisateurs.add(newRea2);
          this.realisateurs.add(newRea3);
     }    
    
    public String getDuree() {
        return duree;
    }
    
    public void setDuree(String newDuree) {
        duree = newDuree;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public void setTitre(String newTitre) {
        titre = newTitre;
    }
    
    public int getFilmID() {
        return filmID;
    }
    
    public void setFilmID(int newFilmID) {
        filmID = newFilmID;
    }

    public int getCategorie() {
        return categorie;
    }
    
    public void setCategorie(int newCategorie) {
        categorie = newCategorie;
    }

}
