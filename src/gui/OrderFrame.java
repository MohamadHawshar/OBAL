/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controllers.AnalyseController;
import Controllers.ClientController;
import Controllers.DoctorController;
import Controllers.OrderController;
import Entities.Analysis;
import Entities.Client;
import Entities.Doctor;
import Entities.Order;
import static com.sun.webkit.perf.WCGraphicsPerfLogger.reset;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.MediaSize;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import utilities.AnalysisTableModel;
import utilities.AutoCompletion;
import utilities.ClientsTableModel;
import utilities.DataSource;

/**
 *
 * @author lenovo
 */
public class OrderFrame extends javax.swing.JPanel {

    private Client currentCient = null;
    private Order currentOrder = null;
    public Order listOrder = null;
    private final ClientsTableModel clientModel = new ClientsTableModel();
    private final DefaultComboBoxModel doctorModel = new DefaultComboBoxModel();
    private final DefaultComboBoxModel analyseModel = new DefaultComboBoxModel();
    private final AnalysisTableModel analysisTableModel = new AnalysisTableModel();
    private Boolean editing = false;
    // private static int idOrder=43;
    public Object shared = new Object();

    /**
     * Creates new form OrderFrame
     */
    public OrderFrame() {

        initComponents();
        setVisible(true);
        initialize();
    }

    private void initialize() {
        clientsTable.setModel(clientModel);
        clientsTable.getColumnModel().getColumn(0).setMinWidth(350);
        clientsTable.getColumnModel().getColumn(0).setMaxWidth(350);
        clientsTable.getColumnModel().getColumn(1).setMinWidth(450);
        clientsTable.getColumnModel().getColumn(1).setMaxWidth(512);
        new InitializeDoctorsComboBox().execute();
        AutoCompletion.enable(doctorComboBox);
        new InitializeAnalysisComboBox().execute();
        AutoCompletion.enable(analysisComboBox);
        analysisTable.setModel(analysisTableModel);
        /*       clientsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

         @Override
         public void valueChanged(ListSelectionEvent e) {
                  
         }
         });*/
    }

    private void clear() {

        clientModel.removeAll();
        doctorModel.setSelectedItem(doctorModel.getElementAt(0));
        analysisTableModel.removeAll();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        analysisTable = new javax.swing.JTable();
        analysisComboBox = new javax.swing.JComboBox();
        addAnalysisBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        clientsTable = new javax.swing.JTable();
        doctorComboBox = new javax.swing.JComboBox();
        searchButton = new javax.swing.JButton();
        removeTestBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 113, 185)));

        saveBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(22, 113, 185));
        saveBtn.setText("Save Order");
        saveBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 113, 185), 1, true));
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveBtnMousePressed(evt);
            }
        });
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(22, 113, 185));
        deleteBtn.setText("Delete Order");
        deleteBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 113, 185), 1, true));
        deleteBtn.setEnabled(false);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        analysisTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        analysisTable.setGridColor(new java.awt.Color(158, 158, 158));
        analysisTable.setPreferredSize(new java.awt.Dimension(900, 250));
        analysisTable.setRowHeight(25);
        analysisTable.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(analysisTable);

        analysisComboBox.setBackground(new java.awt.Color(22, 113, 185));
        analysisComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        analysisComboBox.setForeground(new java.awt.Color(22, 113, 185));
        analysisComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        analysisComboBox.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 113, 185), 1, true));

        addAnalysisBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addAnalysisBtn.setForeground(new java.awt.Color(22, 113, 185));
        addAnalysisBtn.setText("Add Test");
        addAnalysisBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 113, 185), 1, true));
        addAnalysisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnalysisBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(22, 113, 185));
        jLabel2.setText("First name");

        firstNameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        firstNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 113, 185), 1, true));
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(22, 113, 185)));

        clientsTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(22, 113, 185)));
        clientsTable.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        clientsTable.setForeground(new java.awt.Color(45, 137, 206));
        clientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        clientsTable.setRowHeight(40);
        clientsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(clientsTable);
        clientsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (clientsTable.getColumnModel().getColumnCount() > 0) {
            clientsTable.getColumnModel().getColumn(0).setResizable(false);
            clientsTable.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            clientsTable.getColumnModel().getColumn(1).setResizable(false);
            clientsTable.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            clientsTable.getColumnModel().getColumn(2).setResizable(false);
            clientsTable.getColumnModel().getColumn(2).setHeaderValue("Title 3");
        }

        doctorComboBox.setBackground(new java.awt.Color(247, 247, 247));
        doctorComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        doctorComboBox.setForeground(new java.awt.Color(45, 137, 206));
        doctorComboBox.setMaximumRowCount(10);
        doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "t", "t", "t", " ", "t", "t", "t", "t", "t", "tt", "t", "t", "tt", "t", "t", " ", "t", "t", "t", "t", "t" }));
        doctorComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(22, 113, 185)));

        searchButton.setBackground(new java.awt.Color(255, 255, 255));
        searchButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(22, 113, 185));
        searchButton.setText("Search");
        searchButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 113, 185), 1, true));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        removeTestBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        removeTestBtn.setForeground(new java.awt.Color(22, 113, 185));
        removeTestBtn.setText("Remove Test");
        removeTestBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 113, 185), 1, true));
        removeTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTestBtnActionPerformed(evt);
            }
        });

        clearBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(22, 113, 185));
        clearBtn.setText("Clear");
        clearBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 113, 185), 1, true));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editBtn.setForeground(new java.awt.Color(22, 113, 185));
        editBtn.setText("Edit Order");
        editBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(22, 113, 185), 1, true));
        editBtn.setEnabled(false);
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstNameField)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                            .addComponent(doctorComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(analysisComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addAnalysisBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeTestBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                            .addComponent(editBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(doctorComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(analysisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(removeTestBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(addAnalysisBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        new OrderFrame.DeleteOrderPerformed(listOrder).execute();
           editing=false;

    }//GEN-LAST:event_deleteBtnActionPerformed

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String firstName = firstNameField.getText();
        clientModel.removeAll();
        new SearchClientPerformed(firstName).execute();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        clear();
        editing=false;
    }//GEN-LAST:event_clearBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        editBtn.setEnabled(false);
        clear();
        firstNameField.setText(listOrder.getClient().getFirstName() + " " + listOrder.getClient().getLastName());
        searchButtonActionPerformed(evt);
        doctorComboBox.setSelectedItem(listOrder.getDoctor());
        analysisTableModel.add(listOrder.getListOrders());
        editing = true;
    }//GEN-LAST:event_editBtnActionPerformed

    private void saveBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMousePressed
        // TODO add your handling code here:
        if (!editing) {
            Client client;
            if (clientsTable.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(OrderFrame.this,
                        "Please Select a Client",
                        "Adding Failed ",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if (doctorComboBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(OrderFrame.this,
                        "Please Select a Doctor",
                        "Adding Failed ",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            Doctor doctor = (Doctor) doctorComboBox.getSelectedItem();
            client = clientModel.get(clientsTable.getSelectedRow());
            LocalDate date = LocalDate.now();
            List<Analysis> list = analysisTableModel.getAll();
            Order order = new Order();
            order.setClient(client);
            order.setDoctor(doctor);
            order.setDate(date);
            order.setPaid(false);
            order.setListOrders(list);
            currentOrder = order;
            new OrderFrame.SaveOrderPerformed(currentOrder).execute();
        }
        else
        {
            editing=false;
            List<Analysis> list = analysisTableModel.getAll();
            listOrder.setListOrders(list);
            new OrderFrame.editOrderPerformed(listOrder).execute();
        }

    }//GEN-LAST:event_saveBtnMousePressed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed

    private void addAnalysisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnalysisBtnActionPerformed
        // TODO add your handling code here:

        Analysis a = (Analysis) analysisComboBox.getSelectedItem();
        if (!analysisTableModel.contains(a)) {
            analysisTableModel.add(a);
        }

    }//GEN-LAST:event_addAnalysisBtnActionPerformed

    private void removeTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTestBtnActionPerformed
        // TODO add your handling code here:

        analysisTableModel.remove(analysisTable.getSelectedRow());
    }//GEN-LAST:event_removeTestBtnActionPerformed

    private class editOrderPerformed extends SwingWorker<String, Void> {

        private final Order order;

        public editOrderPerformed(Order order) {
            this.order = order;
        }

        @Override
        protected String doInBackground() throws Exception {
            OrderController.instance.updateAnalysis(order);
            return null;
        }

        @Override
        public void done() {

            try {
                get();
                JOptionPane.showMessageDialog(OrderFrame.this,
                        " has been edited successfully",
                        "Successful adding",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class SearchClientPerformed extends SwingWorker<List<Client>, Void> {

        private final String fName;

        public SearchClientPerformed(String firstName) {
            this.fName = firstName;
           
        }

        @Override
        protected List<Client> doInBackground() throws Exception {
            return ClientController.instance.findByLike(fName);
        }

        @Override
        public void done() {
            //Table tab = new Table();
            try {
                clientModel.set(get());
                clientsTable.setModel(clientModel);
                repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public JButton getDelete() {
        return deleteBtn;
    }

    public JButton getSave() {
        return saveBtn;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAnalysisBtn;
    private javax.swing.JComboBox analysisComboBox;
    private javax.swing.JTable analysisTable;
    private javax.swing.JButton clearBtn;
    private javax.swing.JTable clientsTable;
    public javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox doctorComboBox;
    public javax.swing.JButton editBtn;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeTestBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

    private class SaveOrderPerformed extends SwingWorker<String, Void> {

        private Order order;

        public SaveOrderPerformed(Order order) {
            this.order = order;
        }

        @Override
        protected String doInBackground() throws Exception {
            try {
                OrderController.instance.create(order);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                return ex.getMessage();
            }
            return null;
        }

        @Override
        public void done() {
            try {

                get();
                JOptionPane.showMessageDialog(OrderFrame.this,
                        " has been added successfully",
                        "Successful adding",
                        JOptionPane.INFORMATION_MESSAGE);

                reset();

            } catch (InterruptedException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class DeleteOrderPerformed extends SwingWorker<String, Void> {

        private Order order;

        public DeleteOrderPerformed(Order order) {
            this.order = order;
        }

        @Override
        protected String doInBackground() throws Exception {
            OrderController.instance.delete(order);
            return null;
        }

        @Override
        public void done() {
            try {
                if (get() == null) {
                    //clear screen
                    JOptionPane.showMessageDialog(OrderFrame.this,
                            "Order has been deleted successfully",
                            "Successful delete",
                            JOptionPane.INFORMATION_MESSAGE);
                    reset();
                } else {
                    JOptionPane.showMessageDialog(OrderFrame.this,
                            order.toString() + " has errors",
                            "entry error",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class InitializeDoctorsComboBox extends SwingWorker<List<Doctor>, Void> {

        @Override
        protected List<Doctor> doInBackground() throws Exception {
            return DoctorController.instance.findAll();
        }

        @Override
        public void done() {
            //Table tab = new Table();
            try {
                if (get() == null) {
                    return;
                } else {
                    doctorModel.addElement("Select a Doctor");
                    List<Doctor> list;
                    list = get();
                    for (Doctor d : get()) {
                        doctorModel.addElement(d);
                    }
                    doctorComboBox.setModel(doctorModel);

                }
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class InitializeAnalysisComboBox extends SwingWorker<List<Analysis>, Void> {

        @Override
        protected List<Analysis> doInBackground() throws Exception {
            return AnalyseController.instance.findAll();
        }

        @Override
        public void done() {
            try {
                if (get() == null) {
                    return;
                } else {
                    List<Analysis> list;
                    list = get();
                    for (Analysis a : get()) {
                        analyseModel.addElement(a);
                    }
                    analysisComboBox.setModel(analyseModel);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(OrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
