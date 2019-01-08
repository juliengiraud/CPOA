package metier;

import java.util.Date;

public class Projection {

    private Date dateProjection;
    private int heureProjection;
    private java.lang.Boolean officielle;
    private int projectionID;
    private Salle salle;
    private Film film;

    public Projection(Date newDateProjection, int newHeureProjection, java.lang.Boolean newOfficielle, int newProjectionID, Salle newSalle, Film newFilm) {
         this.dateProjection = newDateProjection;
         this.heureProjection = newHeureProjection;
         this.officielle = newOfficielle;
         this.salle = newSalle;
         this.film = newFilm;
    }
    
    public Date getDateProjection() {
        return dateProjection;
    }
    
    public void setDateProjection(Date newDateProjection) {
        dateProjection = newDateProjection;
    }
    
    public int getHeureProjection() {
        return heureProjection;
    }
    
    public void setHeureProjection(int newHeureProjection) {
        heureProjection = newHeureProjection;
    }
    
    public java.lang.Boolean getOfficielle() {
        return officielle;
    }
    
    public void setOfficielle(java.lang.Boolean newOfficielle) {
        officielle = newOfficielle;
    }
    
    public int getProjectionID() {
        return projectionID;
    }
    
    public void setProjectionID(int newProjectionID) {
        projectionID = newProjectionID;
    }

    public int getSalle() {
        return salle;
    }
    
    public void setSalle(int newSalle) {
        salle = newSalle;
    }

    public int getFilm() {
        return film;
    }
    
    public void setFilm(int newFilm) {
        film = newFilm;
    }

}
