package persistance.modelDAO;

import java.sql.SQLException;
import java.util.List;
import metier.Jury;
import persistance.DAO;
import persistance.interfaceDAO.IJuryDAO;

public class JuryDAO extends DAO implements IJuryDAO {
    
    public JuryDAO() throws SQLException {
        super();
    }

    @Override
    // En vue de la sélection d'un jury
    public List<Jury> getJurys() {
        return null;
    }
    
}
