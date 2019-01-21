package vue;

import java.sql.SQLException;
import metier.*;
import persistance.modelDAO.*;

public class Main {
    
    private static NewJFrame f; // Fenêtre de l'IHM
    
    // Coordonnées de la cellule sélectionnée dans le planning
    private static int x;
    private static int y;
    
    public static void main(String args[]) throws SQLException {
        
        Traitement t = new Traitement(); // Permet d'initialiser les attributs statiques de la classe Traitement
        SalleDAO salleDAO = Traitement.getSalleDAO();
        
        // Jours de la semaine pour le planning
        String[] semaine = new String[] {"Jeudi", "Vendredi", "Samedi", "Dimanche", "Lundi", "Mardi", "Mercredi"};
        
        // Création de la fenêtre du planning (code en partie auto-généré)
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
            // Récupération de la fenêtre de l'IHM
            Main.f = new NewJFrame();
            
            // Initialisation des éléments de la fenêtre
            f.get_jButtonGenererPlaning().setText("Générer le planing");
            
            f.get_jButtonViderPlanning().setText("Vider le planning");
            
            f.get_jButtonRechercherFilm().setText("Rechercher un film");
            f.get_jButtonRechercherFilm().setVisible(false);
            
            f.get_textFieldRecherche().setVisible(false);
            
            f.get_jComboBoxResultatRecherche().setVisible(false);
            
            f.get_jButtonSupprimerAjouterSeance().setVisible(false);
            
            f.get_jLabelCategorie().setVisible(false);
            
            f.get_jLabelDate().setVisible(false);
                   
            f.get_jLabelDuree().setVisible(false);

            f.get_jLabelHeure().setVisible(false);

            f.get_jLabelRealisateurs().setVisible(false);

            f.get_jLabelSalle().setVisible(false);

            f.get_jLabelSalleCapacite().setVisible(false);

            f.get_jLabelTitre().setVisible(false);
            
            //f.get_jCheckBoxVoirSeanceLibre().setText("Voir les séances libres");
            f.get_jCheckBoxVoirSeanceLibre().setVisible(false);
            
            // Partie en cours de développement, en vu de continuer le projet
            /*List<Salle> arraySalle = salleDAO.getSalles();
            String[] salles = new String[arraySalle.size() + 1];
            salles[0] = "Sélectionner une salle";
            for (int i = 1; i < arraySalle.size() + 1; i++) {
                salles[i] = arraySalle.get(i - 1).getNom();
            }*/
            //f.get_jComboBoxSelectionnerSalle().setModel(new javax.swing.DefaultComboBoxModel<>(salles));
            f.get_jComboBoxSelectionnerSalle().setVisible(false);
            
            //String[] dates = new String[1];
            //dates[0] = "Sélectionner une date";
            f.get_jComboBoxSelectionnerDate().setVisible(false);
            //f.get_jComboBoxSelectionnerDate().setModel(new javax.swing.DefaultComboBoxModel<>(dates));
            
            // Création du modèle texte du planning vide
            String[][] planning = {
       /*0*/{"Semaine 1 - Lumière", "Semaine 1 - Lumière", "Semaine 1 - Lumière", "Semaine 1 - Lumière", "Semaine 1 - Lumière", "Semaine 1 - Lumière", "Semaine 1 - Lumière"},
            {"09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière"},
            {"12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière"},
            {"16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière"},
            {"19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière"},
       /*5*/{null, null, null, null, null, null, null},
            {"Semaine 2 - Lumière", "Semaine 2 - Lumière", "Semaine 2 - Lumière", "Semaine 2 - Lumière", "Semaine 2 - Lumière", "Semaine 2 - Lumière", "Semaine 2 - Lumière"},
            {"09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière", "09h00 - Théâtre Lumière"},
            {"12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière", "12h30 - Théâtre Lumière"},
            {"16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière", "16h00 - Théâtre Lumière"},
      /*10*/{"19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière", "19h30 - Théâtre Lumière"},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {"Semaine 1 - Debussy", "Semaine 1 - Debussy", "Semaine 1 - Debussy", "Semaine 1 - Debussy", "Semaine 1 - Debussy", "Semaine 1 - Debussy", "Semaine 1 - Debussy"},
            {"09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy"},
      /*15*/{"12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy"},
            {"16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy"},
            {"19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy"},
            {null, null, null, null, null, null, null},
            {"Semaine 2 - Debussy", "Semaine 2 - Debussy", "Semaine 2 - Debussy", "Semaine 2 - Debussy", "Semaine 2 - Debussy", "Semaine 2 - Debussy", "Semaine 2 - Debussy"},
      /*20*/{"09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy", "09h00 - Debussy"},
            {"12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy", "12h30 - Debussy"},
            {"16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy", "16h00 - Debussy"},
            {"19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy", "19h30 - Debussy"},
            {null, null, null, null, null, null, null},
      /*25*/{null, null, null, null, null, null, null},
            {"Premier jour - Buñuel", null, null, null, null, null, null},
            {"09h00 - Buñuel", null, null, null, null, null, null},
            {"09h30 - Buñuel", null, null, null, null, null, null},
            {"10h00 - Buñuel", null, null, null, null, null, null},
      /*30*/{"10h30 - Buñuel", null, null, null, null, null, null},
            {"11h00 - Buñuel", null, null, null, null, null, null},
            {"11h30 - Buñuel", null, null, null, null, null, null},
            {"12h00 - Buñuel", null, null, null, null, null, null},
            {"12h30 - Buñuel", null, null, null, null, null, null},
      /*35*/{"13h00 - Buñuel", null, null, null, null, null, null},
            {"13h30 - Buñuel", null, null, null, null, null, null},
            {"14h00 - Buñuel", null, null, null, null, null, null},
            {"14h30 - Buñuel", null, null, null, null, null, null},
            {"15h00 - Buñuel", null, null, null, null, null, null},
      /*40*/{"15h30 - Buñuel", null, null, null, null, null, null},
            {"16h00 - Buñuel", null, null, null, null, null, null},
            {"16h30 - Buñuel", null, null, null, null, null, null},
            {"17h00 - Buñuel", null, null, null, null, null, null},
            {"17h30 - Buñuel", null, null, null, null, null, null},
      /*45*/{"18h00 - Buñuel", null, null, null, null, null, null},
            {"18h30 - Buñuel", null, null, null, null, null, null},
            {"19h00 - Buñuel", null, null, null, null, null, null},
            {"19h30 - Buñuel", null, null, null, null, null, null},
            {"20h00 - Buñuel", null, null, null, null, null, null},
      /*50*/{"20h30 - Buñuel", null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null},
            {"Semaine 1 - Soixantième", "Semaine 1 - Soixantième", "Semaine 1 - Soixantième", "Semaine 1 - Soixantième", "Semaine 1 - Soixantième", "Semaine 1 - Soixantième", "Semaine 1 - Soixantième"},
            {"09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième"},
      /*55*/{"12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième"},
            {"16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième"},
            {"19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième"},
            {null, null, null, null, null, null, null},
            {"Semaine 2 - Soixantième", "Semaine 2 - Soixantième", "Semaine 2 - Soixantième", "Semaine 2 - Soixantième", "Semaine 2 - Soixantième", "Semaine 2 - Soixantième", "Semaine 2 - Soixantième"},
      /*60*/{"09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième", "09h00 - Soixantième"},
            {"12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième", "12h30 - Soixantième"},
            {"16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième", "16h00 - Soixantième"},
            {"19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième", "19h30 - Soixantième"},
            {null, null, null, null, null, null, null},
      /*65*/{null, null, null, null, null, null, null},
            {"Semaine 1 - Bazin", "Semaine 1 - Bazin", "Semaine 1 - Bazin", "Semaine 1 - Bazin", "Semaine 1 - Bazin", "Semaine 1 - Bazin", "Semaine 1 - Bazin"},
            {"09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin"},
            {"12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin"},
            {"16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin"},
      /*70*/{"19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin"},
            {null, null, null, null, null, null, null},
            {"Semaine 2 - Bazin", "Semaine 2 - Bazin", "Semaine 2 - Bazin", "Semaine 2 - Bazin", "Semaine 2 - Bazin", "Semaine 2 - Bazin", "Semaine 2 - Bazin"},
            {"09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin", "09h00 - Bazin"},
            {"12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin", "12h30 - Bazin"},
      /*75*/{"16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin", "16h00 - Bazin"},
            {"19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin", "19h30 - Bazin"},
            {null, null, null, null, null, null, null}};
            
            // Création du modèle d'objet du planning
            MaCellule[][] planningB = new MaCellule[planning.length][7];
            
            // Remplissage du modèle d'objet avec le texte
            for (int i = 0; i < planning.length; i++) {
                for (int j = 0; j < 7; j++) {
                    if (planning[i][j] != null) {
                        if (planning[i][j].charAt(0) == "0".charAt(0) || planning[i][j].charAt(0) == "1".charAt(0) || planning[i][j].charAt(0) == "2".charAt(0)) {
                            planningB[i][j] = new MaCellule(planning[i][j], true);
                        }
                        else {
                            planningB[i][j] = new MaCellule(planning[i][j], false);
                        }
                    }
                }
            }
            
            // Ajout du modèle d'objet au planning
            f.get_jTablePlanning().setModel(new javax.swing.table.DefaultTableModel(planningB, semaine));
            
            // Affichage de la fenêtre
            f.setVisible(true);
        });
        
        // Mise à jour du planning avec les données enregistrées en base
        Traitement.updateProjection();
    }
    
    // Getters des attributs de la classe
    
    public static NewJFrame getFenetre() {
        return f;
    }

    public static int getX() {
        return Main.x;
    }

    public static void setX(int newX) {
        Main.x = newX;
    }

    public static int getY() {
        return Main.y;
    }

    public static void setY(int newY) {
        Main.y = newY;
    }

}
