package persistance.modelDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import metier.Jury;
import persistance.DAO;
import persistance.interfaceDAO.IJuryDAO;

public class JuryDAO extends DAO implements IJuryDAO {
    
    public JuryDAO() throws SQLException {
        super();
    }

    @Override
    public List<Jury> getJurys() {
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
