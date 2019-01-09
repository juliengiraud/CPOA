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
        return this.dateProjection;
    }
    
    public void setDateProjection(Date newDateProjection) {
        this.dateProjection = newDateProjection;
    }
    
    public int getHeureProjection() {
        return this.heureProjection;
    }
    
    public void setHeureProjection(int newHeureProjection) {
        this.heureProjection = newHeureProjection;
    }
    
    public java.lang.Boolean getOfficielle() {
        return this.officielle;
    }
    
    public void setOfficielle(java.lang.Boolean newOfficielle) {
        this.officielle = newOfficielle;
    }
    
    public int getProjectionID() {
        return this.projectionID;
    }
    
    public void setProjectionID(int newProjectionID) {
        this.projectionID = newProjectionID;
    }

    public Salle getSalle() {
        return this.salle;
    }
    
    public void setSalle(Salle newSalle) {
        this.salle = newSalle;
    }

    public Film getFilm() {
        return this.film;
    }
    
    public void setFilm(Film newFilm) {
        this.film = newFilm;
    }

}
