package persistance.modelDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Categorie;
import persistance.DAO;
import persistance.interfaceDAO.ICategorieDAO;

public class CategorieDAO extends DAO implements ICategorieDAO {
    
    public CategorieDAO() throws SQLException {
        super();
    }

    @Override
    public Categorie getCategoriByID(int id) {
        
        ResultSet rset;
        Statement stmt;
        Categorie categorie = null;
        String query = "SELECT * FROM Categorie WHERE categorieID = " + id;
        try {
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                categorie = new Categorie(rset.getString(1), rset.getInt(2));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(CategorieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorie;
    }

    @Override
    public List<Categorie> getLesCategories() {
        ResultSet rset;
        Statement stmt;
        List<Categorie> listeCategories = new ArrayList<>();
        String query = "SELECT * FROM Categorie";
        try {
            stmt = connexionBD.createStatement();
            listeCategories = new ArrayList<>();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                listeCategories.add(new Categorie(rset.getString(1), rset.getInt(2)));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(CategorieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCategories;
    }

}
