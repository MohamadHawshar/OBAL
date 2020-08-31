/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ClientPagePanels;

import Controllers.ClientController;
import Entities.Client;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author User
 */
public class addClientPanel extends javax.swing.JPanel {

    /**
     * Creates new form addClientPanel
     */
    public addClientPanel() {
        initComponents();
    }
    public void reset() {
        firstNameTf.setText(null);
        LastNameTf.setText(null);
        phoneTf.setText(null);
        locationTf.setText(null);
        firstNameTf.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstNameTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        LastNameTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        phoneTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        locationTf = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        jLabel1.setText("First Name");

        jLabel2.setText("Last Name");

        jLabel3.setText("Phone");

        jLabel4.setText("Location");

        saveBtn.setText("save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phoneTf)
                            .addComponent(firstNameTf, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(locationTf)
                            .addComponent(LastNameTf, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(firstNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(LastNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(phoneTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(locationTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        String firstName = firstNameTf.getText();
        String lastName = LastNameTf.getText();
        String phone = phoneTf.getText();
        String location = locationTf.getText();
        
        if (firstName == null || firstName.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "First Name field should not be empty",
                    "Entry Error",
                    JOptionPane.ERROR_MESSAGE);
            firstNameTf.requestFocus();
            return;
        }
        if (lastName == null || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Last Name field should not be empty",
                    "Entry Error",
                    JOptionPane.ERROR_MESSAGE);
            LastNameTf.requestFocus();
            return;
        }
        if (phone == null || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "phone field should not be empty",
                    "Entry Error",
                    JOptionPane.ERROR_MESSAGE);
            phoneTf.requestFocus();
            return;
        }
        if (location == null || location.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "location field should not be empty",
                    "Entry Error",
                    JOptionPane.ERROR_MESSAGE);
            locationTf.requestFocus();
            return;
        }
        //Execute Worker   
        new addClientPanel.SaveWorker(new Client( firstName, lastName,phone,location)).execute();
    }//GEN-LAST:event_saveBtnActionPerformed
private class SaveWorker extends SwingWorker<String, Void> {

        private Client client;
        

        public SaveWorker(Client client) {
            this.client = client;
        }

        @Override
        protected String doInBackground() throws Exception {
            try {
               // System.out.println(client);
                ClientController.instance.create(client);
            } catch (SQLException ex) {
                System.out.println("error of controller output ");
                return ex.getMessage();
            }
            return null;
        }

        @Override
        public void done() {
            try {
                if (get() == null) {
                    JOptionPane.showMessageDialog(addClientPanel.this,
                            client.toString() + " has been added successfully",
                            "Successful adding",
                            JOptionPane.INFORMATION_MESSAGE);
                    reset();
                } else {
                    JOptionPane.showMessageDialog(addClientPanel.this,
                            client.toString() + " has errors",
                            "entry error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(editClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(editClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LastNameTf;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField firstNameTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField locationTf;
    private javax.swing.JTextField phoneTf;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
