package persistance.interfaceDAO;

import java.util.List;
import metier.Film;
import metier.Projection;
import metier.Salle;

public interface IProjectionDAO {
    
    public int ajouterProjection(String date, String heure, Boolean newOfficielle, Salle salle, Film film);
    public List<String> getDates();
    public List<Projection> getProjections();
    public void supprimerProjection(int id);
    
}
