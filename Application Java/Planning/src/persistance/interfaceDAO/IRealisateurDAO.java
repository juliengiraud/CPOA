package persistance.interfaceDAO;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import metier.Realisateur;

public interface IRealisateurDAO {
    
    public List<Realisateur> getRealisateurs();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection connexionBD);
    
}
