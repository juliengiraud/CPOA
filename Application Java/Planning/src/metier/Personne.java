package metier;

import java.util.Date;

public class Personne {
    
   private String nom;
   private String prenom;
   private String nationnalite;
   private int personneID;
   private int age;
   private Date dateNaissance;
   
   public Personne(String newNom, String newPrenom, String newNationnalite, int newPersonneID, int newAge, Date newDateNaissance) {
       this.nom = newNom;
       this.prenom = newPrenom;
       this.nationnalite = newNationnalite;
       this.personneID = newPersonneID;
       this.age = newAge;
       this.dateNaissance = newDateNaissance;
   }
   
   public String getNom() {
      return nom;
   }
   
   public void setNom(String newNom) {
      nom = newNom;
   }
   
   public String getPrenom() {
      return prenom;
   }
   
   public void setPrenom(String newPrenom) {
      prenom = newPrenom;
   }
   
   public String getNationnalite() {
      return nationnalite;
   }
   
   public void setNationnalite(String newNationnalite) {
      nationnalite = newNationnalite;
   }
   
   public int getPersonneID() {
      return personneID;
   }
   
   public void setPersonneID(int newPersonneID) {
      personneID = newPersonneID;
   }
   
   public int getAge() {
      return age;
   }
   
   public void setAge(int newAge) {
      age = newAge;
   }
   
   public Date getDateNaissance() {
      return dateNaissance;
   }
   
   public void setDateNaissance(Date newDateNaissance) {
      dateNaissance = newDateNaissance;
   }

}