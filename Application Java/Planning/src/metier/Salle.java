package metier;

public class Salle {

    private int salleID;
    private int capacite;
    
    public Salle(int newSalleID, int newCapacite) {
        this.salleID = newSalleID;
        this.capacite = newCapacite;
    }

    public int getSalleID() {
        return salleID;
    }
    
    public void setSalleID(int newSalleID) {
        salleID = newSalleID;
    }
    
    public int getCapacite() {
        return capacite;
    }
    
    public void setCapacite(int newCapacite) {
        capacite = newCapacite;
    }

}
