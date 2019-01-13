package persistance.modelDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Film;
import metier.Projection;
import metier.Salle;
import persistance.DAO;
import persistance.interfaceDAO.IProjectionDAO;

public class ProjectionDAO extends DAO implements IProjectionDAO {
    
    public ProjectionDAO() throws SQLException {
        super();
    }

    @Override
    public List<Projection> getProjections() {
        ResultSet rset;
        Statement stmt;
        List<Projection> listeProjections = null;
        String query = "SELECT * FROM Projection";
        try {
            stmt = connexionBD.createStatement();
            listeProjections = new ArrayList<>();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                int id = rset.getInt(1);
                int salleID = rset.getInt(2);
                SalleDAO salleDAO = new SalleDAO();
                Salle salle = salleDAO.getSalle(salleID);
                int filmID = rset.getInt(2);
                FilmDAO filmDAO = new FilmDAO();
                Film film = filmDAO.getFilm(filmID);
                String date = rset.getString(4);
                String heure = rset.getString(5);
                Boolean officielle = (rset.getInt(6) != 0);
                listeProjections.add(new Projection(id, salle, film, date, heure, officielle));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProjectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProjections;
    }
    
    @Override
    public int ajouterProjection(String date, String heure, Boolean newOfficielle, Salle salle, Film film) {
        ResultSet rset;
        Statement stmt;
        int projectionID = getNewProjectionID();
        int salleID = salle.getSalleID();
        int filmID = film.getFilmID();
        int officielle = newOfficielle ? 1 : 0;
        String query = "INSERT INTO Projection VALUES (" + projectionID + ", " + salleID + ", " + filmID + ", '" + date + "', '" + heure + "', " + officielle + ")";
        try {
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                return projectionID;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProjectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int getNewProjectionID() {
        ResultSet rset;
        Statement stmt;
        int projectionID = -1;
        String query = "SELECT MAX(projectionID) FROM Projection";
        try {
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery(query);
            if (rset.next()) {
                projectionID = rset.getInt(1) + 1;
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProjectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projectionID;
    }
    
    @Override
    public void supprimerProjection(int id) {
        ResultSet rset;
        Statement stmt;
        String query = "DELETE FROM Projection WHERE projectionID = " + id;
        try {
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            Logger.getLogger(ProjectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
