package vue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.*;
import persistance.modelDAO.*;

public class Main {
    
    public static void main(String args[]) throws SQLException {
        
        ProjectionDAO projectionDAO = new ProjectionDAO();
        SalleDAO salleDAO = new SalleDAO();
        FilmDAO filmDAO = new FilmDAO();
        
        //Salle salle = salleDAO.getSalle(2);
        //Film film = filmDAO.getFilm(13);
        
        //projectionDAO.ajouterProjection("12/05/2019", "9h30", false, salle, film);
        //projectionDAO.supprimerProjection(6);
        
        ArrayList<Projection> projections = (ArrayList<Projection>) projectionDAO.getProjections();
        
        projections.forEach((projection) -> {
            //System.out.println(projection.toString());
        });
        
        
        // Création de la fenêtre du planning
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            NewJFrame fenetre = new NewJFrame();
            fenetre.get_jButtonGenererPlaning().setText("Générer le planing");
            
            fenetre.get_jButtonRechercherFilm().setText("Rechercher un film");
            
            fenetre.get_jCheckBoxVoirSeanceLibre().setText("Voir les séances libres");
            
            List<Salle> arraySalle = salleDAO.getSalles();
            String[] salles = new String[arraySalle.size()];
            salles[0] = "Sélectionner une salle";
            for (int i = 1; i < arraySalle.size(); i++) {
                salles[i] = arraySalle.get(i).getNom();
            }
            fenetre.get_jComboBoxSelectionnerSalle().setModel(new javax.swing.DefaultComboBoxModel<>(salles));
            
            String[] dates = new String[] { "Date 1", "Date 2", "Date 3", "Date 4" };
            fenetre.get_jComboBoxSelectionnerDate().setModel(new javax.swing.DefaultComboBoxModel<>(dates));
            
            //fenetre.get_jScrollPane1();
            
            String[] semaine = new String[] {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
            fenetre.get_jTablePlanning().setModel(new javax.swing.table.DefaultTableModel(new Object [][] {
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null}
    }, semaine));
            
            fenetre.get_textFieldRecherche();
            
            fenetre.setVisible(true);
        });
    
    }

}
