package persistance.modelDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import persistance.interfaceDAO.IRealisateurDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Personne;
import persistance.DAO;

public class RealisateurDAO extends DAO implements IRealisateurDAO {
    
    public RealisateurDAO() throws SQLException {
        super();
    }

    @Override
    public List<Personne> getLesRealisateurs(int filmID) {
        ResultSet rset;
        Statement stmt;
        List<Personne> listePersonne = new ArrayList<>();
        String query = "SELECT * FROM Personne LEFT JOIN Realise ON Personne.personneID = Realise.personneID WHERE filmID = " + filmID;
        try {
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                listePersonne.add(new Personne(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getInt(5), rset.getDate(6)));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(RealisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listePersonne;
    }
    
}
