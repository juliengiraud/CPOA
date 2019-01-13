package metier;


public class Projection {

    private String dateProjection;
    private String heureProjection;
    private Boolean officielle;
    private int projectionID;
    private Salle salle;
    private Film film;

    public Projection(int newProjectionID, Salle newSalle, Film newFilm, String newDateProjection, String newHeureProjection, Boolean newOfficielle) {
        this.projectionID = newProjectionID;
        this.dateProjection = newDateProjection;
        this.heureProjection = newHeureProjection;
        this.officielle = newOfficielle;
        this.salle = newSalle;
        this.film = newFilm;
    }
    
    public String getDateProjection() {
        return this.dateProjection;
    }
    
    public void setDateProjection(String newDateProjection) {
        this.dateProjection = newDateProjection;
    }
    
    public String getHeureProjection() {
        return this.heureProjection;
    }
    
    public void setHeureProjection(String newHeureProjection) {
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
    
    @Override
    public String toString() {
        return "ProjectionID : " + this.projectionID + ", Date : " + this.dateProjection + ", Heure de projection : " + this.heureProjection + ", Officielle : " + this.officielle + ", " + this.salle.toString() + ", " + this.film.toString();
    }

}
