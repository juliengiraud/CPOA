package persistance;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
    
    protected static Connection connexionBD;
    
    public DAO() throws SQLException {

    // Connexion à la base de données
    Connexion dataSourceDAO = Connexion.getMdbDataSource();
    DAO.connexionBD = dataSourceDAO.getConnection();
        
    }
    
}
