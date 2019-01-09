package persistance.interfaceDAO;

import java.util.List;
import metier.Categorie;
import metier.Film;

public interface IFilmDAO {

    public List<Film> getLesFilms();
    public List<Film> getLesFilmsByName(String recherche);
    public List<Film> getLesFilmsByCategorie(Categorie categorie);
    
}
