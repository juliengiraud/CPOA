package vue;

import javax.swing.JButton;
import metier.*;

public class MaCellule extends JButton {

    private Projection projection; // Séance
    private String defautText; // Texte à afficher si la séance est null
    private boolean isProjection; // true s'il s'agit d'une projection officielle
    
    public MaCellule(String d, boolean p) {
        super();
        this.projection = null;
        this.defautText = d;
        this.isProjection = p;
    }
    
    // Getters / Setters
    
    public Projection getProjection() {
        return this.projection;
    }
    
    public void setProjection(Projection p) {
        this.projection = p;
    }
    
    public String getDefautText() {
        return this.defautText;
    }
    
    public void setDefautText(String d) {
        this.defautText = d;
    }
    
    public boolean getIsProjection() {
        return this.isProjection;
    }
    
    public void setDefautText(boolean p) {
        this.isProjection = p;
    }
    
    @Override
    public String toString() {
        return (this.projection == null) ? this.getDefautText() : this.projection.toString();
    }
    
}
