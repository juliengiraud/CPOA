package metier;

import java.util.Date;

public class Realisateur extends Personne {
    
    private int realisateurID;
    
    public Realisateur(String newNom, String newPrenom, String newNationnalite, int newPersonneID, int newAge, Date newDateNaissance, int newRealisateurID) {
        super(newNom, newPrenom, newNationnalite, newPersonneID, newAge, newDateNaissance);
        this.realisateurID = newRealisateurID;
    }
    
    public int realisateurID() {
      return this.realisateurID;
   }
   
   public void setRealisateurID(int newRealisateurID) {
      this.realisateurID = newRealisateurID;
   }
   
}
