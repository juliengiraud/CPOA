package persistance.interfaceDAO;

import java.util.ArrayList;
import metier.Personne;

public interface IRealisateurDAO {
    
    ArrayList<Personne> getLesRealisateurs(int filmID);
    
}
