package metier;

public class Film {

    private String duree;
    private String titre;
    private int filmID;
    private Categorie categorie;
    private Realisateur realisateur1;
    private Realisateur realisateur2;
    private Realisateur realisateur3;
    
    public Film(String newDuree, String newTitre, int newID, Categorie newCate, Realisateur newRea1, Realisateur newRea2, Realisateur newRea3) {
        this.duree = newDuree;
        this.titre = newTitre;
        this.filmID = newID;
        this.categorie = newCate;
        this.realisateur1 = newRea1;
        this.realisateur2 = newRea2;
        this.realisateur3 = newRea3;
    }
    
    public String getTitre() {
        return this.titre;
    }
    
}
