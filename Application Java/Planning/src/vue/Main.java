package vue;

import java.sql.SQLException;
import java.util.ArrayList;
import metier.*;
import persistance.modelDAO.*;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        
        ProjectionDAO projectionDAO = new ProjectionDAO();
        SalleDAO salleDAO = new SalleDAO();
        Salle salle = salleDAO.getSalle(2);
        FilmDAO filmDAO = new FilmDAO();
        Film film = filmDAO.getFilm(13);
        
        //projectionDAO.ajouterProjection("12/05/2019", "9h30", false, salle, film);
        //projectionDAO.supprimerProjection(6);
        
        ArrayList<Projection> projections = (ArrayList<Projection>) projectionDAO.getProjections();
        
        projections.forEach((projection) -> {
            System.out.println(projection.toString());
        });
        
        
    
    }

}
