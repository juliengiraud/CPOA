package persistance.modelDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Salle;
import persistance.DAO;
import persistance.interfaceDAO.ISalleDAO;

public class SalleDAO extends DAO implements ISalleDAO {
    
    public SalleDAO() throws SQLException {
        super();
    }

    @Override
    public List<Salle> getSalles() {
        ResultSet rset;
        Statement stmt;
        List<Salle> listeSalles = new ArrayList<>();
        String query = "SELECT * FROM Salle";
        try {
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                listeSalles.add(new Salle(rset.getInt(1), rset.getInt(2), rset.getString(3)));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(SalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeSalles;
    }

    @Override
    public Salle getSalle(int id) {
        ResultSet rset;
        Statement stmt;
        Salle salle = null;
        String query = "SELECT * FROM Salle WHERE salleID = " + id;
        try {
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                salle = new Salle(rset.getInt(1), rset.getInt(2), rset.getString(3));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(SalleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salle;
    }
    
}
