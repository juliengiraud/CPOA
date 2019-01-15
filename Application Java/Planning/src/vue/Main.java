package vue;

import java.sql.SQLException;
import java.util.List;
import metier.*;
import persistance.modelDAO.*;

public class Main {
    
    private static NewJFrame f;
    
    public static void main(String args[]) throws SQLException {
        
        Traitement t = new Traitement();
        ProjectionDAO projectionDAO = new ProjectionDAO();
        SalleDAO salleDAO = new SalleDAO();
        String[] semaine = new String[] {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        
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
            Main.f = new NewJFrame();
            f.get_jButtonGenererPlaning().setText("Générer le planing");
            
            f.get_jButtonRechercherFilm().setText("Rechercher un film");
            
            f.get_jCheckBoxVoirSeanceLibre().setText("Voir les séances libres");
            
            List<Salle> arraySalle = salleDAO.getSalles();
            String[] salles = new String[arraySalle.size() + 1];
            salles[0] = "Sélectionner une salle";
            for (int i = 1; i < arraySalle.size() + 1; i++) {
                salles[i] = arraySalle.get(i - 1).getNom();
            }
            f.get_jComboBoxSelectionnerSalle().setModel(new javax.swing.DefaultComboBoxModel<>(salles));
            
            List<String> arrayDate = projectionDAO.getDates();
            String[] dates = new String[arrayDate.size() + 1];
            dates[0] = "Sélectionner une date";
            for (int i = 1; i < arrayDate.size() + 1; i++) {
                dates[i] = arrayDate.get(i - 1);
            }
            f.get_jComboBoxSelectionnerDate().setModel(new javax.swing.DefaultComboBoxModel<>(dates));
            
            String[][] planning = {
            {"09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière"},
            {"12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière"},
            {"16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière"},
            {"19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière"},
            {},
            {"09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière"},
            {"12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière"},
            {"16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière"},
            {"19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière"},
            {},
            {},
            {"09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy"},
            {"12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy"},
            {"16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy"},
            {"19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy"},
            {},
            {"09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy"},
            {"12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy"},
            {"16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy"},
            {"19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy"},
            {},
            {},
            {"09h00 - Buñuel", "09h00 - Buñuel", "09h00 - Buñuel", "09h00 - Buñuel", "09h00 - Buñuel", "09h00 - Buñuel", "09h00 - Buñuel"},
            {"09h30 - Buñuel", "09h30 - Buñuel", "09h30 - Buñuel", "09h30 - Buñuel", "09h30 - Buñuel", "09h30 - Buñuel", "09h30 - Buñuel"},
            {"10h00 - Buñuel", "10h00 - Buñuel", "10h00 - Buñuel", "10h00 - Buñuel", "10h00 - Buñuel", "10h00 - Buñuel", "10h00 - Buñuel"},
            {"10h30 - Buñuel", "10h30 - Buñuel", "10h30 - Buñuel", "10h30 - Buñuel", "10h30 - Buñuel", "10h30 - Buñuel", "10h30 - Buñuel"},
            {"11h00 - Buñuel", "11h00 - Buñuel", "11h00 - Buñuel", "11h00 - Buñuel", "11h00 - Buñuel", "11h00 - Buñuel", "11h00 - Buñuel"},
            {"11h30 - Buñuel", "11h30 - Buñuel", "11h30 - Buñuel", "11h30 - Buñuel", "11h30 - Buñuel", "11h30 - Buñuel", "11h30 - Buñuel"},
            {"12h00 - Buñuel", "12h00 - Buñuel", "12h00 - Buñuel", "12h00 - Buñuel", "12h00 - Buñuel", "12h00 - Buñuel", "12h00 - Buñuel"},
            {"12h30 - Buñuel", "12h30 - Buñuel", "12h30 - Buñuel", "12h30 - Buñuel", "12h30 - Buñuel", "12h30 - Buñuel", "12h30 - Buñuel"},
            {"13h00 - Buñuel", "13h00 - Buñuel", "13h00 - Buñuel", "13h00 - Buñuel", "13h00 - Buñuel", "13h00 - Buñuel", "13h00 - Buñuel"},
            {"13h30 - Buñuel", "13h30 - Buñuel", "13h30 - Buñuel", "13h30 - Buñuel", "13h30 - Buñuel", "13h30 - Buñuel", "13h30 - Buñuel"},
            {"14h00 - Buñuel", "14h00 - Buñuel", "14h00 - Buñuel", "14h00 - Buñuel", "14h00 - Buñuel", "14h00 - Buñuel", "14h00 - Buñuel"},
            {"14h30 - Buñuel", "14h30 - Buñuel", "14h30 - Buñuel", "14h30 - Buñuel", "14h30 - Buñuel", "14h30 - Buñuel", "14h30 - Buñuel"},
            {"15h00 - Buñuel", "15h00 - Buñuel", "15h00 - Buñuel", "15h00 - Buñuel", "15h00 - Buñuel", "15h00 - Buñuel", "15h00 - Buñuel"},
            {"15h30 - Buñuel", "15h30 - Buñuel", "15h30 - Buñuel", "15h30 - Buñuel", "15h30 - Buñuel", "15h30 - Buñuel", "15h30 - Buñuel"},
            {"16h00 - Buñuel", "16h00 - Buñuel", "16h00 - Buñuel", "16h00 - Buñuel", "16h00 - Buñuel", "16h00 - Buñuel", "16h00 - Buñuel"},
            {"16h30 - Buñuel", "16h30 - Buñuel", "16h30 - Buñuel", "16h30 - Buñuel", "16h30 - Buñuel", "16h30 - Buñuel", "16h30 - Buñuel"},
            {"17h00 - Buñuel", "17h00 - Buñuel", "17h00 - Buñuel", "17h00 - Buñuel", "17h00 - Buñuel", "17h00 - Buñuel", "17h00 - Buñuel"},
            {"17h30 - Buñuel", "17h30 - Buñuel", "17h30 - Buñuel", "17h30 - Buñuel", "17h30 - Buñuel", "17h30 - Buñuel", "17h30 - Buñuel"},
            {"18h00 - Buñuel", "18h00 - Buñuel", "18h00 - Buñuel", "18h00 - Buñuel", "18h00 - Buñuel", "18h00 - Buñuel", "18h00 - Buñuel"},
            {"18h30 - Buñuel", "18h30 - Buñuel", "18h30 - Buñuel", "18h30 - Buñuel", "18h30 - Buñuel", "18h30 - Buñuel", "18h30 - Buñuel"},
            {"19h00 - Buñuel", "19h00 - Buñuel", "19h00 - Buñuel", "19h00 - Buñuel", "19h00 - Buñuel", "19h00 - Buñuel", "19h00 - Buñuel"},
            {"19h30 - Buñuel", "19h30 - Buñuel", "19h30 - Buñuel", "19h30 - Buñuel", "19h30 - Buñuel", "19h30 - Buñuel", "19h30 - Buñuel"},
            {"20h00 - Buñuel", "20h00 - Buñuel", "20h00 - Buñuel", "20h00 - Buñuel", "20h00 - Buñuel", "20h00 - Buñuel", "20h00 - Buñuel"},
            {"20h30 - Buñuel", "20h30 - Buñuel", "20h30 - Buñuel", "20h30 - Buñuel", "20h30 - Buñuel", "20h30 - Buñuel", "20h30 - Buñuel"},
            {},
            {},
            {"09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième"},
            {"12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième"},
            {"16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième"},
            {"19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième"},
            {},
            {"09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième"},
            {"12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième"},
            {"16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième"},
            {"19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième"},
            {},
            {},
            {"09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin"},
            {"12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin"},
            {"16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin"},
            {"19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin"},
            {},
            {"09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin"},
            {"12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin"},
            {"16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin"},
            {"19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin"}};
            f.get_jTablePlanning().setModel(new javax.swing.table.DefaultTableModel(planning, semaine));
            
            f.get_textFieldRecherche();
            
            f.setVisible(true);
        });
        
    
    }
    
    public static NewJFrame getFenetre() {
        return f;
    }

}
