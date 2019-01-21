package vue;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import metier.Traitement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julien
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonGenererPlaning = new javax.swing.JButton();
        jComboBoxSelectionnerSalle = new javax.swing.JComboBox<>();
        jComboBoxSelectionnerDate = new javax.swing.JComboBox<>();
        jCheckBoxVoirSeanceLibre = new javax.swing.JCheckBox();
        textFieldRecherche = new java.awt.TextField();
        jButtonRechercherFilm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePlanning = new javax.swing.JTable();
        jLabelDate = new javax.swing.JLabel();
        jLabelTitre = new javax.swing.JLabel();
        jLabelHeure = new javax.swing.JLabel();
        jLabelSalle = new javax.swing.JLabel();
        jLabelSalleCapacite = new javax.swing.JLabel();
        jLabelDuree = new javax.swing.JLabel();
        jLabelCategorie = new javax.swing.JLabel();
        jLabelRealisateurs = new javax.swing.JLabel();
        jButtonSupprimerAjouterSeance = new javax.swing.JButton();
        jComboBoxResultatRecherche = new javax.swing.JComboBox<>();
        jButtonViderPlanning = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 700));

        jButtonGenererPlaning.setText("Générer le planing");
        jButtonGenererPlaning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenererPlaningActionPerformed(evt);
            }
        });

        jComboBoxSelectionnerSalle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSelectionnerSalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectionnerSalleActionPerformed(evt);
            }
        });

        jComboBoxSelectionnerDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSelectionnerDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelectionnerDateActionPerformed(evt);
            }
        });

        jCheckBoxVoirSeanceLibre.setText("Voir les séances libres");
        jCheckBoxVoirSeanceLibre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxVoirSeanceLibreActionPerformed(evt);
            }
        });

        textFieldRecherche.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textFieldRecherche.setMinimumSize(new java.awt.Dimension(69, 24));
        textFieldRecherche.setText("");
        textFieldRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldRechercheActionPerformed(evt);
            }
        });

        jButtonRechercherFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRechercherFilmActionPerformed(evt);
            }
        });

        jTablePlanning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePlanning.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTablePlanning.setAutoscrolls(false);
        jTablePlanning.setCellSelectionEnabled(true);
        jTablePlanning.setRequestFocusEnabled(false);
        jTablePlanning.getTableHeader().setReorderingAllowed(false);
        jTablePlanning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePlanningMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePlanning);
        jTablePlanning.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabelDate.setText("Date");

        jLabelTitre.setText("Titre");

        jLabelHeure.setText("Heure");

        jLabelSalle.setText("Salle");

        jLabelSalleCapacite.setText("Capacité");

        jLabelDuree.setText("Durée");

        jLabelCategorie.setText("Categorie");

        jLabelRealisateurs.setText("Realisateurs");

        jButtonSupprimerAjouterSeance.setText("Supprimer/Ajouter la séance");
        jButtonSupprimerAjouterSeance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerAjouterSeanceActionPerformed(evt);
            }
        });

        jComboBoxResultatRecherche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonViderPlanning.setText("Vider le planning");
        jButtonViderPlanning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViderPlanningActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRechercherFilm))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCategorie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelDuree))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxResultatRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(137, 137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSalleCapacite)
                    .addComponent(jLabelRealisateurs)
                    .addComponent(jLabelSalle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 585, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSupprimerAjouterSeance, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelHeure, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(161, 161, 161))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jComboBoxSelectionnerSalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxSelectionnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxVoirSeanceLibre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(jButtonGenererPlaning, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonViderPlanning, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGenererPlaning)
                    .addComponent(jButtonViderPlanning))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSelectionnerSalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSelectionnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxVoirSeanceLibre))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelDate)
                        .addComponent(jLabelSalle)
                        .addComponent(jLabelTitre))
                    .addComponent(jButtonRechercherFilm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHeure)
                            .addComponent(jLabelSalleCapacite)
                            .addComponent(jComboBoxResultatRecherche, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSupprimerAjouterSeance)
                            .addComponent(jLabelRealisateurs)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCategorie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelDuree)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenererPlaningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenererPlaningActionPerformed
        try {
            Traitement.genererPlaning();
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonGenererPlaningActionPerformed

    private void textFieldRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldRechercheActionPerformed
        String film = textFieldRecherche.getText();
        Traitement.rechercherFilm(film);
    }//GEN-LAST:event_textFieldRechercheActionPerformed

    private void jButtonRechercherFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRechercherFilmActionPerformed
        String film = textFieldRecherche.getText();
        Traitement.rechercherFilm(film);
    }//GEN-LAST:event_jButtonRechercherFilmActionPerformed

    private void jCheckBoxVoirSeanceLibreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxVoirSeanceLibreActionPerformed
        Boolean etat = jCheckBoxVoirSeanceLibre.isSelected();
        Traitement.voirSeanceLibre(etat);
    }//GEN-LAST:event_jCheckBoxVoirSeanceLibreActionPerformed

    private void jComboBoxSelectionnerSalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectionnerSalleActionPerformed
        String salle = (String) jComboBoxSelectionnerSalle.getSelectedItem();
        Traitement.selectionnerSalle(salle);
    }//GEN-LAST:event_jComboBoxSelectionnerSalleActionPerformed

    private void jComboBoxSelectionnerDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelectionnerDateActionPerformed
        String date = (String) jComboBoxSelectionnerDate.getSelectedItem();
        Traitement.selectionnerDate(date);
    }//GEN-LAST:event_jComboBoxSelectionnerDateActionPerformed

    private void jTablePlanningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePlanningMouseClicked
        Traitement.selectionnerSeance(evt);
    }//GEN-LAST:event_jTablePlanningMouseClicked

    private void jButtonSupprimerAjouterSeanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerAjouterSeanceActionPerformed
        Traitement.supprimerAjouterSeance(evt);
    }//GEN-LAST:event_jButtonSupprimerAjouterSeanceActionPerformed

    private void jButtonViderPlanningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViderPlanningActionPerformed
        Traitement.viderPlanning();
    }//GEN-LAST:event_jButtonViderPlanningActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonGenererPlaning;
    private javax.swing.JButton jButtonRechercherFilm;
    private javax.swing.JButton jButtonSupprimerAjouterSeance;
    private javax.swing.JButton jButtonViderPlanning;
    private javax.swing.JCheckBox jCheckBoxVoirSeanceLibre;
    private javax.swing.JComboBox<String> jComboBoxResultatRecherche;
    private javax.swing.JComboBox<String> jComboBoxSelectionnerDate;
    private javax.swing.JComboBox<String> jComboBoxSelectionnerSalle;
    private javax.swing.JLabel jLabelCategorie;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDuree;
    private javax.swing.JLabel jLabelHeure;
    private javax.swing.JLabel jLabelRealisateurs;
    private javax.swing.JLabel jLabelSalle;
    private javax.swing.JLabel jLabelSalleCapacite;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePlanning;
    private java.awt.TextField textFieldRecherche;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton get_jButtonGenererPlaning() {
        return this.jButtonGenererPlaning;
    }
    
    public javax.swing.JButton get_jButtonRechercherFilm() {
        return this.jButtonRechercherFilm;
    }
    
    public javax.swing.JButton get_jButtonSupprimerAjouterSeance() {
        return this.jButtonSupprimerAjouterSeance;
    }
    
    public javax.swing.JCheckBox get_jCheckBoxVoirSeanceLibre() {
        return this.jCheckBoxVoirSeanceLibre;
    }
    
    public javax.swing.JComboBox<String> get_jComboBoxSelectionnerDate() {
        return this.jComboBoxSelectionnerDate;
    }
    
    public javax.swing.JComboBox<String> get_jComboBoxSelectionnerSalle() {
        return this.jComboBoxSelectionnerSalle;
    }
    
    public javax.swing.JScrollPane get_jScrollPane1() {
        return this.jScrollPane1;
    }
    
    public javax.swing.JTable get_jTablePlanning() {
        return this.jTablePlanning;
    }
    
    public java.awt.TextField get_textFieldRecherche() {
        return this.textFieldRecherche;
    }
    
    public javax.swing.JLabel get_jLabelCategorie() {
        return this.jLabelCategorie;
    }
    
    public javax.swing.JLabel get_jLabelDate() {
        return this.jLabelDate;
    }
    
    public javax.swing.JLabel get_jLabelDuree() {
        return this.jLabelDuree;
    }
    
    public javax.swing.JLabel get_jLabelHeure() {
        return this.jLabelHeure;
    }
    
    public javax.swing.JLabel get_jLabelRealisateurs() {
        return this.jLabelRealisateurs;
    }
    
    public javax.swing.JLabel get_jLabelSalle() {
        return this.jLabelSalle;
    }
    
    public javax.swing.JLabel get_jLabelSalleCapacite() {
        return this.jLabelSalleCapacite;
    }
    
    public javax.swing.JLabel get_jLabelTitre() {
        return this.jLabelTitre;
    }
    
    public JComboBox get_jComboBoxResultatRecherche() {
        return this.jComboBoxResultatRecherche;
    }
    
    public JButton get_jButtonViderPlanning() {
        return this.jButtonViderPlanning;
    }
    
}
