package persistance.interfaceDAO;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import metier.Film;

public interface IFilmDAO {

    public List<Film> getLesFilms();
    public int setLesFilms(List<Film> lesFilms);
    public void insertFilm(Film f);
    public boolean supprFilm(int filmID);
    public void setDataSource(DataSource ds);
    public void setConnection(Connection connexionBD);
    public List<Film> findById(int filmID);
    public List<Film> findByName();
    public List<Film> getFilmsCategorie(String uneCategorie );
    
}
