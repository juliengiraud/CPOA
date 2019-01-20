package vue;

import javax.swing.JButton;
import metier.*;

public class MaCellule extends JButton {

    private Projection projection;
    private String defautText;
    private boolean isProjection;
    
    public MaCellule(String d, boolean p) {
        super();
        this.projection = null;
        this.defautText = d;
        this.isProjection = p;
    }
    
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
