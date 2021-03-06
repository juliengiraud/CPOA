package persistance.interfaceDAO;

import java.util.List;
import metier.Categorie;
import metier.Film;

public interface IFilmDAO {

    public Film getFilm(int id);
    public List<Film> getLesFilms();
    public List<Film> getLesFilmsByTitre(String recherche);
    public List<Film> getLesFilmsByCategorie(Categorie categorie);
    
}
