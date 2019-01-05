package persistance;

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
import metier.Film;

public class FilmDAO extends DAO implements IFilmDAO {
    
    public FilmDAO () throws SQLException {
        super();
    }
    
    @Override
    public List<Film> getLesFilms() {
        ResultSet rset;
        Statement stmt;
        List<Film> listeFilms = null;
        String query = "SELECT * FROM Film";
        try {
            stmt = connexionBD.createStatement();
            listeFilms = new ArrayList<>();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                listeFilms.add(new Film(rset.getString(1), rset.getString(2), rset.getInt(3), null, null, null, null));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger( FilmDAO.class.getName() ).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (connexionBD != null) {
                    connexionBD.close();
                }
            }
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return listeFilms;
    }
    
    @Override
    public void insertFilm(Film f) { /*
        try {
            connexionBD = ConnexionBD.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement pstmt = null;
        String sc = null;
        String query = "INSERT INTO Produit.tableproduits (id, libelle, categorie, souscategorie, prix, quantite), (?,?,?,?,?,?)";
        // 6 valeurs
        try {
            pstmt = connexionBD.prepareStatement(query);
            pstmt.setInt(1, f.getId());
            pstmt.setString(2, f.getLibelle());
            pstmt.setString(3, f.getCategorie());
            sc = f.getSousCategorie();
            if (sc != null) {
                pstmt.setString(4, sc);
            }
            else {
                pstmt.setNull(4, java.sql.Types.VARCHAR);
            }
            pstmt.setDouble(5, a.getPrix());
            pstmt.setInt(6, a.getQuantite());
            int n = pstmt.executeUpdate();
            if (n == 1) {
                System.out.println(" Insertion reussie d'un Film en BD ");
            }
            else {
                System.out.println(" *** Echec Insertion de l'Film en BD : cet ID existe déjà ");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger( FilmDAO.class.getName() ).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (connexionBD != null) {
                    connexionBD.close();
                }
            }
            catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }*/
    }
    
    @Override
    public void setConnection(Connection conn) {
        this.connexionBD = conn;
    }

    @Override
    public int setLesFilms(List<Film> lesFilms) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprFilm(int filmID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Film> findById(int filmID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Film> findByName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Film> getFilmsCategorie(String uneCategorie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
