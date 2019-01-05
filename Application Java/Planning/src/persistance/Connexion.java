package persistance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mariadb.jdbc.MariaDbDataSource;

public class Connexion extends MariaDbDataSource {
    
    private static Connexion mds;

    private Connexion() {}

    public static Connexion getMdbDataSource() {
    
        if (mds == null) {
            try {
                Properties prop = new Properties();
                FileInputStream fichier = null;
                try {
                    fichier = new FileInputStream("src/persistance/connexionMariaIUT.properties");
                }
                catch (FileNotFoundException ex1) {
                    System.out.println("Fichier de proprietes non trouvé");
                }
                try {
                    prop.load(fichier);
                }
                catch (IOException ex) {
                    System.out.println("Erreur lors du chargement du fichier de proprietes mySQL");
                }
                finally {
                    try {
                        fichier.close();
                    }
                    catch (IOException ex) {
                        System.out.print("Problème d'entree/sortie" + ex.getMessage());
                    }
                }
                mds = new Connexion ();
                mds.setPortNumber(new Integer(prop.getProperty("port")));
                mds.setServerName(prop.getProperty("serveur"));
                mds.setDatabaseName(prop.getProperty("base"));
                mds.setUser(prop.getProperty("user"));
                mds.setPassword(prop.getProperty("pwd"));
                // pas de service à définir pour MariaDB
            }
            catch (SQLException ex) {
                Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            System.out.println("---(la source de data existe deja)") ;
        }
        return mds;
    } // de getMdbDataSource()
}