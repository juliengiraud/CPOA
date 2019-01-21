package metier;

public class Categorie {
     
    private String type; // ex : "Long métrage en compétition"
    private int categorieID;
    
    public Categorie(String newType, int id) {
        this.type = newType;
        this.categorieID = id;
    }
    
    // Getters / Setters
    
    public String getType() {
        return type;
    }
    
    public void setType(String newType) {
        type = newType;
    }
    
    public int getCategorieID() {
        return categorieID;
    }
    
    public void setCategorieID(int newCategorieID) {
        categorieID = newCategorieID;
    }
    
    public String toString() {
        return this.type + " " + this.categorieID;
    }

}
