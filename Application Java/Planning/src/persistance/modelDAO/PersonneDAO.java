package persistance.modelDAO;

import java.sql.SQLException;
//import java.util.List;
//import metier.Personne;
import persistance.DAO;
import persistance.interfaceDAO.IPersonneDAO;

public class PersonneDAO extends DAO implements IPersonneDAO {
    
    public PersonneDAO() throws SQLException {
        super();
    }
    
}
