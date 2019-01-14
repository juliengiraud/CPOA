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
            String[] salles = new String[arraySalle.size() + 1];
            salles[0] = "Sélectionner une salle";
            for (int i = 1; i < arraySalle.size() + 1; i++) {
                salles[i] = arraySalle.get(i - 1).getNom();
            }
            fenetre.get_jComboBoxSelectionnerSalle().setModel(new javax.swing.DefaultComboBoxModel<>(salles));
            
            List<String> arrayDate = projectionDAO.getDates();
            String[] dates = new String[arrayDate.size() + 1];
            dates[0] = "Sélectionner une date";
            for (int i = 1; i < arrayDate.size() + 1; i++) {
                dates[i] = arrayDate.get(i - 1);
            }
            fenetre.get_jComboBoxSelectionnerDate().setModel(new javax.swing.DefaultComboBoxModel<>(dates));
            
            updatePlanning(fenetre, new String[7][8]);
            
            fenetre.get_textFieldRecherche();
            
            fenetre.setVisible(true);
        });
        
    
    }
    
    public static void updatePlanning(NewJFrame f, String[][] newTab) {
        String[] semaine = new String[] {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        String[][] tab = newTab;
        f.get_jTablePlanning().setModel(new javax.swing.table.DefaultTableModel(tab, semaine));
    }

}
