package gui;

import Controllers.OrderController;
import Entities.Order;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import utilities.ImageText;
import utilities.Renderer;
/**
 *
 * @author lenovo
 */
public class MainFrame extends javax.swing.JFrame {

    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final OrderFrame orderFrame = new OrderFrame();
    private final DoctorsPage doctorsPage = new DoctorsPage();
    private final ClientPage clientPage = new ClientPage();
    private final ResultsPane resultPage = new ResultsPane();
    private final BillFrame billPage = new BillFrame();

    private final DefaultComboBoxModel dateModel = new DefaultComboBoxModel();
    private final DefaultListModel listModel = new DefaultListModel();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() throws InterruptedException {
                
        initComponents();
        clientPage.setVisible(false);
        mainPane.add(orderFrame);
        orderFrame.setVisible(false);
        new InitializeDateComboBox().execute();
        dateComboBox.setModel(dateModel);
        removeDeletedFromList();
        addNewToList();
        updatePayedList();
        //com.alee.laf.combobox.WebComboBoxUI.COMBOBOX_INSTANCE.set(dateComboBox, dateComboBox);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        headerText = new javax.swing.JLabel();
        line = new javax.swing.JSeparator();
        exit = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exitBtn = new javax.swing.JLabel();
        minimizeBtn = new javax.swing.JLabel();
        mainPane = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        doctors = new javax.swing.JPanel();
        doctorsLabel = new javax.swing.JLabel();
        clients = new javax.swing.JPanel();
        clientsLabel = new javax.swing.JLabel();
        results = new javax.swing.JPanel();
        resultsLabel = new javax.swing.JLabel();
        bill = new javax.swing.JPanel();
        billLabel = new javax.swing.JLabel();
        orders = new javax.swing.JPanel();
        ordersLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        dateComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        ordersList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(screenSize);
        mainPanel.setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(22, 113, 185));

        headerText.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        headerText.setForeground(new java.awt.Color(255, 255, 255));
        headerText.setText("OBAL Medical Laboratory");

        line.setForeground(new java.awt.Color(255, 255, 255));

        exit.setBackground(new java.awt.Color(250, 251, 252));
        exit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled.png"))); // NOI18N
        exit.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/llljl.PNG"))); // NOI18N
        exitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitBtnMousePressed(evt);
            }
        });
        exit.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 40, 50));

        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize.png"))); // NOI18N
        minimizeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseReleased(evt);
            }
        });
        exit.add(minimizeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 42, 50));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerText)
                    .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(headerText, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(line, javax.swing.GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );

        mainPanel.add(header, java.awt.BorderLayout.NORTH);

        mainPane.setBackground(new java.awt.Color(255, 255, 255));
        mainPane.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(22, 113, 185)));
        mainPane.setPreferredSize(new java.awt.Dimension(1200, 930));
        mainPane.setLayout(new java.awt.BorderLayout());
        mainPanel.add(mainPane, java.awt.BorderLayout.CENTER);

        sidePanel.setBackground(new java.awt.Color(247, 247, 247));
        sidePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 113, 185)));
        sidePanel.setPreferredSize(new java.awt.Dimension(320, 930));
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctors.setBackground(new java.awt.Color(0, 113, 197));
        doctors.setOpaque(false);
        doctors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doctorsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doctorsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                doctorsMousePressed(evt);
            }
        });

        doctorsLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        doctorsLabel.setForeground(new java.awt.Color(45, 137, 206));
        doctorsLabel.setText("Doctors");

        javax.swing.GroupLayout doctorsLayout = new javax.swing.GroupLayout(doctors);
        doctors.setLayout(doctorsLayout);
        doctorsLayout.setHorizontalGroup(
            doctorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorsLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(doctorsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        doctorsLayout.setVerticalGroup(
            doctorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doctorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(doctorsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidePanel.add(doctors, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, -1, -1));

        clients.setBackground(new java.awt.Color(0, 113, 197));
        clients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clientsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clientsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clientsMousePressed(evt);
            }
        });

        clientsLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        clientsLabel.setForeground(new java.awt.Color(255, 255, 255));
        clientsLabel.setText("Clients");

        javax.swing.GroupLayout clientsLayout = new javax.swing.GroupLayout(clients);
        clients.setLayout(clientsLayout);
        clientsLayout.setHorizontalGroup(
            clientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientsLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(clientsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        clientsLayout.setVerticalGroup(
            clientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidePanel.add(clients, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        results.setBackground(new java.awt.Color(0, 113, 197));
        results.setOpaque(false);
        results.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resultsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resultsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resultsMousePressed(evt);
            }
        });

        resultsLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        resultsLabel.setForeground(new java.awt.Color(45, 137, 206));
        resultsLabel.setText("Tests Results");

        javax.swing.GroupLayout resultsLayout = new javax.swing.GroupLayout(results);
        results.setLayout(resultsLayout);
        resultsLayout.setHorizontalGroup(
            resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultsLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(resultsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        resultsLayout.setVerticalGroup(
            resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resultsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidePanel.add(results, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));

        bill.setBackground(new java.awt.Color(0, 113, 197));
        bill.setOpaque(false);
        bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                billMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                billMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                billMousePressed(evt);
            }
        });

        billLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        billLabel.setForeground(new java.awt.Color(45, 137, 206));
        billLabel.setText("Bill & Payment");

        javax.swing.GroupLayout billLayout = new javax.swing.GroupLayout(bill);
        bill.setLayout(billLayout);
        billLayout.setHorizontalGroup(
            billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(billLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        billLayout.setVerticalGroup(
            billLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(billLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(billLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidePanel.add(bill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));

        orders.setBackground(new java.awt.Color(0, 113, 197));
        orders.setOpaque(false);
        orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ordersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ordersMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ordersMousePressed(evt);
            }
        });

        ordersLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ordersLabel.setForeground(new java.awt.Color(45, 137, 206));
        ordersLabel.setText("Orders");

        javax.swing.GroupLayout ordersLayout = new javax.swing.GroupLayout(orders);
        orders.setLayout(ordersLayout);
        ordersLayout.setHorizontalGroup(
            ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(ordersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        ordersLayout.setVerticalGroup(
            ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ordersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        sidePanel.add(orders, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IMG-20200923-WA0007.jpg"))); // NOI18N
        sidePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 720, 190, 180));

        mainPanel.add(sidePanel, java.awt.BorderLayout.LINE_START);

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(22, 113, 185)));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 930));

        dateComboBox.setBackground(new java.awt.Color(255, 255, 254));
        dateComboBox.setMaximumRowCount(5);
        dateComboBox.setAutoscrolls(true);
        dateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateComboBoxActionPerformed(evt);
            }
        });

        ordersList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ordersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ordersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ordersList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel1, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mousePress(JPanel panel) {//change color of option panell
        panel.setBackground(new Color(0, 113, 197));
        clients.setOpaque(false);
        results.setOpaque(false);
        doctors.setOpaque(false);
        bill.setOpaque(false);
        orders.setOpaque(false);
        panel.setOpaque(true);

    }

    private void mousePressLabel(JLabel label) {  // change color of option label(text)
        clientsLabel.setForeground(new Color(45, 137, 206));
        resultsLabel.setForeground(new Color(45, 137, 206));
        billLabel.setForeground(new Color(45, 137, 206));
        doctorsLabel.setForeground(new Color(45, 137, 206));
        ordersLabel.setForeground(new Color(45, 137, 206));
        label.setForeground(new Color(255, 255, 255));
    }

    private void mouseOnOption(JPanel panel, JLabel label) {
        if (panel.isOpaque() == true) {
            return;                                  // already clicked
        }
        panel.setBackground(new Color(0, 174, 239));
        label.setForeground(new Color(255, 255, 255));
        panel.setOpaque(true);
        repaint();
        revalidate();

    }

    private void mouseOffOption(JPanel panel, JLabel label) {
        if (panel.getBackground().getRGB() == new Color(0, 113, 197).getRGB()) {
            return;
        }
        panel.setBackground(new Color(0, 113, 197));
        label.setForeground(new Color(45, 137, 206));
        panel.setOpaque(false);
        repaint();
    }

    private void doctorsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorsMouseEntered
        mouseOnOption(doctors, doctorsLabel);
    }//GEN-LAST:event_doctorsMouseEntered

    private void doctorsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorsMouseExited
        mouseOffOption(doctors, doctorsLabel);

    }//GEN-LAST:event_doctorsMouseExited

    private void doctorsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorsMousePressed
        // TODO add your handling code here:
        mousePress(doctors);
        mousePressLabel(doctorsLabel);
        mainPane.add(doctorsPage);
        orderFrame.setVisible(false);
        clientPage.setVisible(false);
        resultPage.setVisible(false);
        doctorsPage.setVisible(true);
        billPage.setVisible(false);
        repaint();
        revalidate();
    }//GEN-LAST:event_doctorsMousePressed

    private void clientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientsMouseEntered
        mouseOnOption(clients, clientsLabel);
    }//GEN-LAST:event_clientsMouseEntered

    private void clientsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientsMouseExited
        mouseOffOption(clients, clientsLabel);
    }//GEN-LAST:event_clientsMouseExited

    private void clientsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientsMousePressed

        mousePress(clients);
        mousePressLabel(clientsLabel);
        mainPane.add(clientPage);
        orderFrame.setVisible(false);
        doctorsPage.setVisible(false);
        resultPage.setVisible(false);
        billPage.setVisible(false);
        clientPage.setVisible(true);

        repaint();
    }//GEN-LAST:event_clientsMousePressed

    private void resultsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultsMouseEntered
        mouseOnOption(results, resultsLabel);
    }//GEN-LAST:event_resultsMouseEntered

    private void resultsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultsMouseExited
        mouseOffOption(results, resultsLabel);
    }//GEN-LAST:event_resultsMouseExited

    private void resultsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultsMousePressed

        mousePress(results);
        mousePressLabel(resultsLabel);
        mainPane.add(resultPage);
        orderFrame.setVisible(false);
        doctorsPage.setVisible(false);
        clientPage.setVisible(false);
        resultPage.setVisible(true);
        billPage.setVisible(false);

        repaint();
    }//GEN-LAST:event_resultsMousePressed

    private void billMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billMouseEntered
        mouseOnOption(bill, billLabel);
    }//GEN-LAST:event_billMouseEntered

    private void billMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billMouseExited
        mouseOffOption(bill, billLabel);
    }//GEN-LAST:event_billMouseExited

    private void billMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billMousePressed

        mousePress(bill);
        mousePressLabel(billLabel);
        mainPane.add(billPage);
        orderFrame.setVisible(false);
        doctorsPage.setVisible(false);
        clientPage.setVisible(false);
        resultPage.setVisible(false);
        billPage.setVisible(true);
        repaint();
    }//GEN-LAST:event_billMousePressed

    private void dateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateComboBoxActionPerformed
        // TODO add your handling code here:
        ordersList.clearSelection();
        orderFrame.editBtn.setEnabled(false);
        orderFrame.deleteBtn.setEnabled(false);
        java.sql.Date d = (java.sql.Date) dateComboBox.getSelectedItem();
        new InitializeList(d).execute();
    }//GEN-LAST:event_dateComboBoxActionPerformed

    private void ordersListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersListMouseClicked
        // TODO add your handling code here:
        try {
            ImageText i = (ImageText) listModel.getElementAt(ordersList.getSelectedIndex());
            if(i.getOrder().isPaid())
                return;
            if (orderFrame.isVisible()) {
                orderFrame.listOrder = i.getOrder();
                orderFrame.deleteBtn.setEnabled(true);
                orderFrame.editBtn.setEnabled(true);
            }
            if(resultPage.isVisible()){
                resultPage.listClicked(i.getOrder());
            }
            if(billPage.isVisible()){
                billPage.listClicked(i.getOrder());
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {

            ordersList.clearSelection();
        }
    }//GEN-LAST:event_ordersListMouseClicked

    private void ordersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersMouseEntered
        // TODO add your handling code here:
        mouseOnOption(orders, ordersLabel);
    }//GEN-LAST:event_ordersMouseEntered

    private void ordersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersMouseExited
        // TODO add your handling code here:
        mouseOffOption(orders, ordersLabel);
    }//GEN-LAST:event_ordersMouseExited

    private void ordersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersMousePressed
        // TODO add your handling code here:
        mousePress(orders);
        mousePressLabel(ordersLabel);
        mainPane.add(orderFrame);
        clientPage.setVisible(false);
        doctorsPage.setVisible(false);
        resultPage.setVisible(false);
        billPage.setVisible(false);
        orderFrame.setVisible(true);
        repaint();
    }//GEN-LAST:event_ordersMousePressed

    private void ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_ordersMouseClicked

    private void minimizeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseExited
        // TODO add your handling code here:
        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize.png")));
    }//GEN-LAST:event_minimizeBtnMouseExited

    private void minimizeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseEntered
        // TODO add your handling code here:
        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize_blue.png")));
    }//GEN-LAST:event_minimizeBtnMouseEntered

    private void exitBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMousePressed
        try {
            // TODO add your handling code here:
            Thread.sleep(400);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_exitBtnMousePressed

    private void exitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseExited
        // TODO add your handling code here:
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/llljl.PNG")));
    }//GEN-LAST:event_exitBtnMouseExited

    private void exitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitBtnMouseEntered
        // TODO add your handling code here:
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit_blue.png")));
    }//GEN-LAST:event_exitBtnMouseEntered

    private void minimizeBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseReleased
        // TODO add your handling code here:
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnMouseReleased

    private void removeDeletedFromList() {
        JButton r = orderFrame.getDelete();
        r.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.removeElementAt(ordersList.getSelectedIndex());
                r.setEnabled(false);
                orderFrame.editBtn.setEnabled(false);
            }
        });
    }

    private void addNewToList() {
        JButton save = orderFrame.getSave();
        System.out.println("ADDING NEW TO LIST");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.sql.Date d = (java.sql.Date) dateComboBox.getSelectedItem();
                new InitializeList(d).execute();
            }
        });
    }

    private void updatePayedList() {
        JButton done = billPage.getDone();
        done.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                java.sql.Date d = (java.sql.Date) dateComboBox.getSelectedItem();
                System.out.println("UPDATINGGG");
                new InitializeList(d).execute();
            }
        });
    }

    private class InitializeList extends SwingWorker<List<Order>, Void> {

        private Date d;

        public InitializeList(Date d) {
            this.d = d;
        }

        @Override
        protected List<Order> doInBackground() throws Exception {
            return OrderController.instance.findByDate((java.sql.Date) d);
        }

        public void done() {
            try {
                if (get() == null) {
                    return;
                } else {
                    listModel.removeAllElements();
                    List<Order> list;
                    list = get();
                    for (Order o : get()) {
                        if (!o.isPaid()) {
                            listModel.addElement(new ImageText(o,
                                    new ImageIcon(getClass().getResource("/images/false.png"))));
                        } else {
                            listModel.addElement(new ImageText(o,
                                    new ImageIcon(getClass().getResource("/images/truee.png"))));
                        }

                    }
                    ordersList.setCellRenderer(new Renderer());
                    ordersList.setModel(listModel);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private class InitializeDateComboBox extends SwingWorker<List<java.util.Date>, Void> {

        @Override
        protected List<java.util.Date> doInBackground() throws Exception {
            return OrderController.instance.date();
        }

        @Override
        public void done() {
            try {
                if (get() == null) {
                    return;
                } else {
                    LocalDate x = LocalDate.now();
                    Date date = Date.valueOf(x);
                    dateModel.addElement(date);
                    List<java.util.Date> list;
                    list = get();
                    for (java.util.Date d : get()) {
                        if (!d.equals(date)) {
                            dateModel.addElement(d);
                        }
                    }
                    dateComboBox.setModel(dateModel);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExecutionException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
          
        //UIManager.put("ComboBoxUI", Comb)
             /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bill;
    private javax.swing.JLabel billLabel;
    private javax.swing.JPanel clients;
    private javax.swing.JLabel clientsLabel;
    private javax.swing.JComboBox dateComboBox;
    private javax.swing.JPanel doctors;
    private javax.swing.JLabel doctorsLabel;
    private javax.swing.JPanel exit;
    private javax.swing.JLabel exitBtn;
    private javax.swing.JPanel header;
    private javax.swing.JLabel headerText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator line;
    private javax.swing.JPanel mainPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel minimizeBtn;
    private javax.swing.JPanel orders;
    private javax.swing.JLabel ordersLabel;
    public javax.swing.JList ordersList;
    private javax.swing.JPanel results;
    private javax.swing.JLabel resultsLabel;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables
}
