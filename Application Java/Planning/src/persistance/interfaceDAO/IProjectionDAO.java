package persistance.interfaceDAO;

import java.util.List;
import metier.Film;
import metier.Projection;
import metier.Salle;

public interface IProjectionDAO {
    
    public List<Projection> getProjections();
    public int ajouterProjection(String date, String heure, Boolean newOfficielle, Salle salle, Film film);
    public void supprimerProjection(int id);
    
}
