package persistance.modelDAO;

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
import persistance.interfaceDAO.IFilmDAO;

public class FilmDAO extends DAO implements IFilmDAO {
    
    public FilmDAO() throws SQLException {
        super();
    }
    
    @Override
    // Retourne le film dont l'ID correspond
    public Film getFilm(int filmID) {
        ResultSet rset;
        Statement stmt;
        Film film = null;
        Categorie categorie;
        List<Personne> realisateurs;
        String query = "SELECT * FROM Film WHERE filmID = " + filmID;
        try {
            CategorieDAO categorieDAO = new CategorieDAO();
            RealisateurDAO realisateurDAO = new RealisateurDAO();
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                categorie = categorieDAO.getCategoriByID(rset.getInt(4));
                realisateurs = realisateurDAO.getLesRealisateurs(rset.getInt(3));
                film = new Film(rset.getString(1), rset.getString(2), rset.getInt(3), categorie, realisateurs);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(FilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return film;
    }
    
    @Override
    // Retourne une liste de tous les films en base
    public List<Film> getLesFilms() {
        ResultSet rset;
        Statement stmt;
        List<Film> listeFilms = new ArrayList<>();
        Categorie categorie;
        List<Personne> realisateurs;
        String query = "SELECT * FROM Film";
        try {
            CategorieDAO categorieDAO = new CategorieDAO();
            RealisateurDAO realisateurDAO = new RealisateurDAO();
            stmt = connexionBD.createStatement();
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
    // Retourne la liste de tous les films dont le titre contient les mots de la recherche
    public List<Film> getLesFilmsByTitre(String recherche) {
        ResultSet rset;
        Statement stmt;
        List<Film> listeFilms = new ArrayList<>();
        Categorie categorie;
        List<Personne> realisateurs = null;
        String[] mots = recherche.split(" ");
        String query = "SELECT * FROM Film WHERE titre REGEXP'" + mots[0] + "'";
        for (int i = 1; i < mots.length; i++) {
            query = query + " AND titre REGEXP'" + mots[i] + "'";
        }
        query = query + " ORDER BY titre";
        //System.out.println(query);
        try {
            CategorieDAO categorieDAO = new CategorieDAO();
            RealisateurDAO realisateurDAO = new RealisateurDAO();
            stmt = connexionBD.createStatement();
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
    // En vue d'une optimisation des requêtes
    public List<Film> getLesFilmsByCategorie(Categorie categorie) {
        return null;
    }
    
}
