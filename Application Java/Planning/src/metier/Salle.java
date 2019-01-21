package metier;

public class Salle {

    private int salleID;
    private int capacite;
    private String nom;
    
    public Salle(int newSalleID, int newCapacite, String newNom) {
        this.salleID = newSalleID;
        this.capacite = newCapacite;
        this.nom = newNom;
    }
    
    // Getters / Setters

    public int getSalleID() {
        return this.salleID;
    }
    
    public void setSalleID(int newSalleID) {
        this.salleID = newSalleID;
    }
    
    public int getCapacite() {
        return this.capacite;
    }
    
    public void setCapacite(int newCapacite) {
        this.capacite = newCapacite;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setCapacite(String newNom) {
        this.nom = newNom;
    }
    
    @Override
    public String toString() {
        return "Nom de la salle : " + this.nom + ", Identifiant de la sale : " + this.salleID + ", Capacité de la salle : " + this.capacite;
    }

}
