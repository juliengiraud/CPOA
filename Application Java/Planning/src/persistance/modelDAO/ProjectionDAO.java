package persistance.modelDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import metier.Projection;
import persistance.DAO;
import persistance.interfaceDAO.IProjectionDAO;

public class ProjectionDAO extends DAO implements IProjectionDAO {
    
    public ProjectionDAO() throws SQLException {
        super();
    }

    @Override
    public List<Projection> getProjections() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setConnection(Connection connexionBD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
