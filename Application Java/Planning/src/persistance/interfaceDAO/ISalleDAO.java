package persistance.interfaceDAO;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import metier.Salle;

public interface ISalleDAO {
    
    public List<Salle> getSalles();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection connexionBD);
    
}
