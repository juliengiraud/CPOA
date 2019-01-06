package metier;

public class Categorie {
    
   private String type;
   private int categorieID;
   
   public Categorie(String newType, int ID) {
       this.type = newType;
       this.categorieID = ID;
   }
   
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

}