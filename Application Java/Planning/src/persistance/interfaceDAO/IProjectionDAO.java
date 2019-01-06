package persistance.interfaceDAO;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import metier.Projection;

public interface IProjectionDAO {
    
    public List<Projection> getProjections();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection connexionBD);
    
}
