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
import metier.Projection;
import metier.Salle;
import persistance.DAO;
import persistance.interfaceDAO.IProjectionDAO;

public class ProjectionDAO extends DAO implements IProjectionDAO {
    
    public ProjectionDAO() throws SQLException {
        super();
    }

    @Override
    public List<String> getDates() {
        ResultSet rset;
        Statement stmt;
        List<String> listeDates = null;
        String query = "SELECT dateProjection FROM Projection GROUP BY dateProjection";
        try {
            stmt = connexionBD.createStatement();
            listeDates = new ArrayList<>();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                listeDates.add(rset.getString(1));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProjectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeDates;
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

    @Override
    public List<Projection> getProjections() {
        ResultSet rset;
        Statement stmt;
        List<Projection> listeProjections = null;
        String query = "SELECT * FROM Projection JOIN Salle JOIN Film JOIN Categorie ON Projection.salleID = Salle.salleID AND Projection.filmID = Film.filmID AND Film.categorieID = Categorie.categorieID";
        try {
            stmt = connexionBD.createStatement();
            listeProjections = new ArrayList<>();
            rset = stmt.executeQuery(query);
            int projectionID, salleID, filmID, capacite, categorieID;
            String date, heure, nomSalle, titre, type, duree;
            Boolean officielle;
            Salle salle;
            Film film;
            Categorie categorie;
            while (rset.next()) {
                projectionID = rset.getInt(1);
                salleID = rset.getInt(2);
                filmID = rset.getInt(3);
                date = rset.getString(4);
                heure = rset.getString(5);
                officielle = (rset.getInt(6) != 0);
                //salleID = rset.getInt(7);
                capacite = rset.getInt(8);
                nomSalle = rset.getString(9);
                duree = rset.getString(10);
                titre = rset.getString(11);
                //filmID = rset.getInt(12);
                categorieID = rset.getInt(13);
                type = rset.getString(14);
                //categorieID = rset.getInt(15);
                salle = new Salle(salleID, capacite, heure);
                categorie = new Categorie(type, categorieID);
                film = new Film(duree, titre, filmID, categorie, null);
                
                listeProjections.add(new Projection(projectionID, salle, film, date, heure, officielle));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(ProjectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProjections;
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

    @Override
    public void supprimerProjections() {
        ResultSet rset;
        Statement stmt;
        String query = "DELETE FROM Projection";
        try {
            stmt = connexionBD.createStatement();
            rset = stmt.executeQuery(query);
        }
        catch (SQLException ex) {
            Logger.getLogger(ProjectionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
