package persistance.interfaceDAO;

import java.util.List;
import metier.Projection;

public interface IProjectionDAO {
    
    public List<Projection> getProjections();
    public int ajouterProjection(Projection projection);
    public void supprimerProjection(int id);
    
}
