package persistance.interfaceDAO;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import metier.Personne;

public interface IPersonneDAO {
    
    public List<Personne> getPersonnes();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection connexionBD);
    
}
