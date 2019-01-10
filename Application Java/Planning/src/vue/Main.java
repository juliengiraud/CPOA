package vue;

import java.sql.SQLException;
import java.util.ArrayList;
import metier.Film;
import persistance.modelDAO.FilmDAO;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        
        FilmDAO filmDAO = new FilmDAO();
        
        ArrayList<Film> films = (ArrayList<Film>) filmDAO.getLesFilmsByTitre("une nuit");
        
        films.forEach((film) -> {
            System.out.println(film.toString());
        });
        
        System.out.println("Il y a " + films.size() + " films.");
    
    }

}
