package metier;

import java.util.ArrayList;

public class Jury {
    private int nbSeanceMax;
    private int juryID;
    private Categorie categorie;
    private ArrayList<Personne> membres;
    
    public Jury(int newNbSeanceMax, int newJuryID, Categorie newCategorie, ArrayList<Personne> membres) {
        this.nbSeanceMax = newNbSeanceMax;
        this.juryID = newJuryID;
        this.categorie = newCategorie;
        this.membres.addAll(membres);
    }
    
    public int getNbSeanceMax() {
        return this.nbSeanceMax;
    }
    
    public void setNbSeanceMax(int newNbSeanceMax) {
        this.nbSeanceMax = newNbSeanceMax;
    }
    
    public int getJuryID() {
        return this.juryID;
    }
    
    public void setJuryID(int newJuryID) {
        this.juryID = newJuryID;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }
    
    public void setCategorie(Categorie newCategorie) {
        this.categorie = newCategorie;
    }
    
    public java.util.Collection<Personne> getMembres() {
        if (this.membres == null)
            this.membres = new ArrayList<>();
        return this.membres;
    }

}
