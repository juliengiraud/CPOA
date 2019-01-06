package persistance.interfaceDAO;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import metier.Jury;

public interface IJuryDAO {
    
    public List<Jury> getJurys();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection connexionBD);
    
}
