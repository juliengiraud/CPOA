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
    
    public java.util.Collection<Personne> getMembres() {
        if (membres == null)
            membres = new ArrayList<>();
        return membres;
    }
    
    public java.util.Iterator getIteratorMembres() {
        if (membres == null)
            membres = new ArrayList<>();
        return membres.iterator();
    }
    
    public void setMembres(java.util.Collection<Personne> newMembres) {
        removeAllMembres();
        for (java.util.Iterator iter = newMembres.iterator(); iter.hasNext();)
            addMembres((Personne)iter.next());
    }
    
    public void addMembres(Personne newPersonne) {
        if (newPersonne == null)
            return;
        if (this.membres == null)
            this.membres = new ArrayList<>();
        if (!this.membres.contains(newPersonne))
            this.membres.add(newPersonne);
    }
    
    public void removeMembres(Personne oldPersonne) {
        if (oldPersonne == null)
            return;
        if (this.membres != null)
            if (this.membres.contains(oldPersonne))
                this.membres.remove(oldPersonne);
    }
    
    public void removeAllMembres() {
        if (membres != null)
            membres.clear();
    }
    
    public int getNbSeanceMax() {
        return nbSeanceMax;
    }
    
    public void setNbSeanceMax(int newNbSeanceMax) {
        nbSeanceMax = newNbSeanceMax;
    }
    
    public int getJuryID() {
        return juryID;
    }
    
    public void setJuryID(int newJuryID) {
        juryID = newJuryID;
    }

    public int getCategorie() {
        return categorie;
    }
    
    public void setCategorie(int newCategorie) {
        categorie = newCategorie;
    }

}
