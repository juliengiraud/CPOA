package persistance.modelDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import metier.Salle;
import persistance.DAO;
import persistance.interfaceDAO.ISalleDAO;

public class SalleDAO extends DAO implements ISalleDAO {
    
    public SalleDAO() throws SQLException {
        super();
    }

    @Override
    public List<Salle> getSalles() {
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
