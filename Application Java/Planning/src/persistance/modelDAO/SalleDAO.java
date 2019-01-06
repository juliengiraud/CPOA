package persistance.modelDAO;

import persistance.interfaceDAO.IFilmDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
