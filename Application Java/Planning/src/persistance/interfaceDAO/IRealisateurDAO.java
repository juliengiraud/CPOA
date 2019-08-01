package persistance.interfaceDAO;

import java.util.List;
import metier.Personne;

public interface IRealisateurDAO {
    
    List<Personne> getLesRealisateurs(int filmID);
    
}
