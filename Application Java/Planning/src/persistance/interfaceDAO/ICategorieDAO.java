package persistance.interfaceDAO;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import metier.Categorie;

public interface ICategorieDAO {
    
    public List<Categorie> getCategories();
    public void setDataSource(DataSource ds);
    public void setConnection(Connection connexionBD);
    
}
