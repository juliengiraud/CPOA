package persistance.interfaceDAO;

import java.util.List;
import metier.Salle;

public interface ISalleDAO {
    
    public List<Salle> getSalles();
    public Salle getSalle(int id);
    
}
