package vue;

import java.sql.SQLException;
import java.util.ArrayList;
import metier.Film;
import persistance.modelDAO.FilmDAO;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        
        FilmDAO filmDAO = new FilmDAO();
        
        ArrayList<Film> films = (ArrayList<Film>) filmDAO.getLesFilms();
        
        for (Film film : films) {
            System.out.println(film.getTitre());
        }
        
        System.out.println("Il y a " + films.size() + " films.");
    
    }

}
