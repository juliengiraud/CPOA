package persistance.interfaceDAO;

import java.util.List;
import metier.Categorie;

public interface ICategorieDAO {
    
    public Categorie getCategoriByID(int id);
    public List<Categorie> getLesCategories();
    
}
