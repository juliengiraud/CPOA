package persistance.modelDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import metier.Personne;
import persistance.DAO;
import persistance.interfaceDAO.IPersonneDAO;

public class PersonneDAO extends DAO implements IPersonneDAO {
    
    public PersonneDAO() throws SQLException {
        super();
    }

    @Override
    public List<Personne> getPersonnes() {
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
