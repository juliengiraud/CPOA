package persistance.modelDAO;

import persistance.interfaceDAO.IFilmDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Categorie;
import metier.Film;
import metier.Personne;
import persistance.DAO;

public class FilmDAO extends DAO implements IFilmDAO {
    
    public FilmDAO() throws SQLException {
        super();
    }
    
    @Override
    public List<Film> getLesFilms() {
        ResultSet rset;
        Statement stmt;
        List<Film> listeFilms = null;
        Categorie categorie;
        ArrayList<Personne> realisateurs;
        String query = "SELECT * FROM Film";
        try {
            CategorieDAO categorieDAO = new CategorieDAO();
            RealisateurDAO realisateurDAO = new RealisateurDAO();
            stmt = connexionBD.createStatement();
            listeFilms = new ArrayList<>();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                categorie = categorieDAO.getCategoriByID(rset.getInt(4));
                realisateurs = realisateurDAO.getLesRealisateurs(rset.getInt(3));
                listeFilms.add(new Film(rset.getString(1), rset.getString(2), rset.getInt(3), categorie, realisateurs));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeFilms;
    }

    @Override
    public List<Film> getLesFilmsByTitre(String recherche) {
        ResultSet rset;
        Statement stmt;
        List<Film> listeFilms = null;
        Categorie categorie;
        ArrayList<Personne> realisateurs;
        String[] mots = recherche.split(" ");
        String query = "SELECT * FROM Film WHERE titre REGEXP'" + mots[0] + "'";
        for (int i = 1; i < mots.length; i++) {
            query = query + " AND titre REGEXP'" + mots[i] + "'";
        }
        query = query + " ORDER BY titre";
        System.out.println(query);
        try {
            CategorieDAO categorieDAO = new CategorieDAO();
            RealisateurDAO realisateurDAO = new RealisateurDAO();
            stmt = connexionBD.createStatement();
            listeFilms = new ArrayList<>();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                categorie = categorieDAO.getCategoriByID(rset.getInt(4));
                realisateurs = realisateurDAO.getLesRealisateurs(rset.getInt(3));
                listeFilms.add(new Film(rset.getString(1), rset.getString(2), rset.getInt(3), categorie, realisateurs));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeFilms;
    }

    @Override
    public List<Film> getLesFilmsByCategorie(Categorie categorie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
