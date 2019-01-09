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
        return this.nom;
    }
    
    public void setNom(String newNom) {
        this.nom = newNom;
    }
    
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String newPrenom) {
        this.prenom = newPrenom;
    }
    
    public String getNationnalite() {
        return this.nationnalite;
    }
    
    public void setNationnalite(String newNationnalite) {
        this.nationnalite = newNationnalite;
    }
    
    public int getPersonneID() {
        return this.personneID;
    }
    
    public void setPersonneID(int newPersonneID) {
        this.personneID = newPersonneID;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int newAge) {
        this.age = newAge;
    }
    
    public Date getDateNaissance() {
        return this.dateNaissance;
    }
    
    public void setDateNaissance(Date newDateNaissance) {
        this.dateNaissance = newDateNaissance;
    }

}
