/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import DB.DatabaseConnection;
import Models.RoomComponent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Payment;
import models.Room;
import builder.PaymentBuilder;
import decorator.WarrantyDecorator;
import factory.RoomFactory;
import java.util.ArrayList;
import singleton.PaymentGateway;
import singleton.ReservationManager;

/**
 *
 * @author moham
 */
public class Main extends javax.swing.JFrame {

    private void loadRooms() { 
    DefaultTableModel model = (DefaultTableModel) roomtable.getModel(); // Assuming tableModel is your JTable

    String sql = "SELECT * FROM rooms"; // SQL query

    try (Connection conn = DatabaseConnection.getInstance().getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            // Add a row for each product
            model.addRow(new Object[]{
                rs.getInt(1),          // ID
                rs.getString(2),     // Name
                rs.getDouble(3),  // Category
                rs.getString(4)      // Price
            });
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Print any SQL exceptions
    }
}
    
    
       private void updateReservationTable() {
    
    
  DefaultTableModel model = (DefaultTableModel) reservationtable.getModel(); 
   // Clear existing rows
   model.setRowCount(0);
     
    int selectedRow = roomtable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a product to clone.");
            return;
        }
         int RoomId = (int) roomtable.getValueAt(selectedRow, 0);
    // Fetch products from the cart
    List <RoomComponent> cartProducts = ReservationManager.getInstance().getResevationItems();
    double totalPrice = 0;

    for (RoomComponent room : cartProducts) {
        model.addRow(new Object[]{                
            //make method handle this bug
            room.getId(),
            room.getType(),
            room.getPrice(),
            room.getStatus()
        });
        totalPrice += room.getPrice();
    }

}
        private void updatePaymentTable() {
            
 DefaultTableModel model = (DefaultTableModel) paymentable.getModel(); // Assuming tableModel is your JTable

   String sql=  "SELECT * FROM payments";            // SQL query

    try (Connection conn = DatabaseConnection.getInstance().getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            // Add a row for each product
            model.addRow(new Object[]{
                rs.getInt(1),
                rs.getString(2),     // Location
                rs.getString(3),  // TotalPrice
                rs.getString(4),      // Type       
                rs.getString(5),     // Location
                rs.getString(6),  // TotalPrice
                rs.getString(7),
            });
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Print any SQL exceptions
    }

}
    public Main() {
        initComponents();
        loadRooms(); 
        updatePaymentTable();
        
    customerbox.addItem("standard");
    customerbox.addItem("corporate");
    customerbox.addItem("vip");
    paybox.addItem("bank transfer");
    paybox.addItem("Credit Card");
    paybox.addItem("PayPal");
    }

       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        typetxt = new javax.swing.JTextField();
        pricetxt = new javax.swing.JTextField();
        statustxt = new javax.swing.JTextField();
        addroom = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        roomtable = new javax.swing.JTable();
        cloneroom = new javax.swing.JButton();
        ReserveButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationtable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        warntybutton = new javax.swing.JButton();
        ConfirmButton = new javax.swing.JButton();
        paybox = new javax.swing.JComboBox<>();
        customerbox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        paymentable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 204, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/elimende-inagella-h1cjajmECUU-unsplash.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setText("Type");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setText("Price");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setText("Status");

        typetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typetxtActionPerformed(evt);
            }
        });

        pricetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricetxtActionPerformed(evt);
            }
        });

        statustxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statustxtActionPerformed(evt);
            }
        });

        addroom.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        addroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/add.png"))); // NOI18N
        addroom.setText("Add Room");
        addroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addroomActionPerformed(evt);
            }
        });

        roomtable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        roomtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Type", "Price", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(roomtable);
        if (roomtable.getColumnModel().getColumnCount() > 0) {
            roomtable.getColumnModel().getColumn(0).setMinWidth(1);
            roomtable.getColumnModel().getColumn(0).setPreferredWidth(1);
            roomtable.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        cloneroom.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cloneroom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/8665311_clone_icon (3).png"))); // NOI18N
        cloneroom.setText("Clone");
        cloneroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cloneroomActionPerformed(evt);
            }
        });

        ReserveButton.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ReserveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/9332214_reserve_icon.png"))); // NOI18N
        ReserveButton.setText("Reserve");
        ReserveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReserveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1071, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(statustxt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(cloneroom, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(ReserveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addroom))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(statustxt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(typetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReserveButton)
                    .addComponent(cloneroom, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addroom, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );

        jTabbedPane1.addTab("Room", jPanel6);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Choose Payment method");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Enter your name");

        nametxt.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        reservationtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RoomId", "Type", "Price", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reservationtable);
        if (reservationtable.getColumnModel().getColumnCount() > 0) {
            reservationtable.getColumnModel().getColumn(0).setMinWidth(1);
            reservationtable.getColumnModel().getColumn(0).setPreferredWidth(1);
            reservationtable.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Choose Customer profile");

        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/8664938_trash_can_delete_remove_icon (1).png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        warntybutton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        warntybutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/add.png"))); // NOI18N
        warntybutton.setText("Add Room Service (15$)");
        warntybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warntybuttonActionPerformed(evt);
            }
        });

        ConfirmButton.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ConfirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/2190986_approved_check_checkbox_checkmark_confirm_icon (1).png"))); // NOI18N
        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        paybox.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        paybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payboxActionPerformed(evt);
            }
        });

        customerbox.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(customerbox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(paybox, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(warntybutton)
                                .addGap(62, 62, 62)
                                .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(paybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warntybutton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        jTabbedPane1.addTab("Reservation", jPanel5);

        paymentable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "type", "price", "status", "CustomerName", "CustomerProfile", "PaymentMethod"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(paymentable);
        if (paymentable.getColumnModel().getColumnCount() > 0) {
            paymentable.getColumnModel().getColumn(0).setMinWidth(1);
            paymentable.getColumnModel().getColumn(0).setPreferredWidth(1);
            paymentable.getColumnModel().getColumn(0).setMaxWidth(1);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Payment", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReserveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReserveButtonActionPerformed
        // TODO add your handling code here:
        try {
            // الحصول على الصف المحدد من الجدول

            int selectedRow = roomtable.getSelectedRow(); // Replace with your actual table name

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a product to clone.");
                return;
            }

            int RoomId = (int) roomtable.getValueAt(selectedRow, 0);
            String type = (String) roomtable.getValueAt(selectedRow, 1);
            double price = (double) roomtable.getValueAt(selectedRow, 2);
            String status = (String) roomtable.getValueAt(selectedRow, 3);

            RoomComponent room = RoomFactory.createRoomWithId(RoomId,type,price,status);

            ReservationManager.getInstance().addRoom(room);

            JOptionPane.showMessageDialog(null, type + " added to the cart.");
            DefaultTableModel model = (DefaultTableModel) reservationtable.getModel();
            model.setRowCount(0);
            updateReservationTable();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding product to the cart.");
        }
    }//GEN-LAST:event_ReserveButtonActionPerformed

    private void cloneroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cloneroomActionPerformed
        // TODO add your handling code here:
        try {
            // الحصول على الصف المحدد من الجدول
            int selectedRow = roomtable.getSelectedRow(); // Replace with your actual table name

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a product to clone.");
                return;
            }

            // قراءة بيانات المنتج المحدد من الجدول
            String type = (String) roomtable.getValueAt(selectedRow, 1); // Replace with your table name
            double price = (double) roomtable.getValueAt(selectedRow, 2);
            String status = (String) roomtable.getValueAt(selectedRow, 3);
            // إنشاء المنتج الأصلي
            Room originalProduct = RoomFactory.createRoom(type, price, status);

            // استنساخ المنتج باستخدام نمط Prototype
            Room clonedProduct = originalProduct.clone();

            // إضافة المنتج المستنسخ إلى قاعدة البيانات
            DatabaseConnection.getInstance().insertRoom(clonedProduct);

            JOptionPane.showMessageDialog(null, "Product cloned successfully!");
            DefaultTableModel model = (DefaultTableModel) roomtable.getModel();
            model.setRowCount(0);
            loadRooms();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error cloning product: " + ex.getMessage());
            ex.printStackTrace();
        }

    }//GEN-LAST:event_cloneroomActionPerformed

    private void addroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addroomActionPerformed

        try {
            // Read data from the fields
            String type = typetxt.getText();
            double Price = Double.parseDouble(pricetxt.getText());
            String status = statustxt.getText();

            // Validate input
            if (type.isEmpty() || statustxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                return;
            }
            // Create the new product
            Room product = RoomFactory.createRoom(type,Price,status);

            // Insert product into the database
            DatabaseConnection.getInstance().insertRoom(product);

            // Clear the fields
            typetxt.setText("");
            pricetxt.setText("");
            statustxt.setText("");

            // Success message
            JOptionPane.showMessageDialog(null, "Product added successfully!");
            DefaultTableModel model = (DefaultTableModel) roomtable.getModel();
            model.setRowCount(0);
            loadRooms();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid price.");
        }

    }//GEN-LAST:event_addroomActionPerformed

    private void statustxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statustxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statustxtActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) reservationtable.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        // TODO add your handling code here:
            
      String CstmrProfile;
       double totalPrice=0;
       String customername ;
       String CstmrName;
       
       List<String>types =new ArrayList<>();
       List<String>prices =new ArrayList<>();
       List<String>status =new ArrayList<>();
       
       types =ReservationManager.getInstance().getType();
       prices =ReservationManager.getInstance().getPrice();
       status =ReservationManager.getInstance().getStatus();

        try {
        // Simulate total amount calculation (you should calculate this from the cart data)
        double totalAmount = ReservationManager.getInstance().calculateReservationTotal();
        
        if (totalAmount <= 0 ) {
            JOptionPane.showMessageDialog(null, "Cart is empty!");
            return;
        }
        
         if (nametxt.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Name is required!");
            return;
        }   

        // Prompt the user for payment type
        CstmrName=nametxt.getText();
        String paymentType = (String)paybox.getSelectedItem();
        CstmrProfile=(String)customerbox.getSelectedItem();
        
        
        totalPrice=totalAmount; 

        if (CstmrName == null || paymentType.isEmpty()||CstmrProfile.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All filed is required!");
            return;
        }

         int index=0;
         
        
        PaymentBuilder builder =new PaymentBuilder();  
//        Payment payment=builder  
//                .setPrice(Double.parseDouble(prices.get(index)))
//                .setType(types.get(index))
//                .setStatus(status.get(index))
//                .setCustomername(CstmrName)
//                .setCustomerprofile(CstmrProfile)
//                .setPaymentmethod(paymentType)
//                .build();
        Payment payment = new Payment(types.get(index),Double.parseDouble(prices.get(index)),status.get(index),CstmrName,CstmrProfile,paymentType);
           
        System.out.println("this is moooooooooo  "+types.get(index));
        index++;
//        int guaranteeChoice = JOptionPane.showConfirmDialog(null, "Choose Yes if you want guarantee with ", "User Confirmation", JOptionPane.YES_NO_OPTION);
//        if (guaranteeChoice==JOptionPane.YES_OPTION){order=PriceDecorator(order);}
        
        DatabaseConnection.getInstance().insertPayment(payment);           
        // Use the Singleton PaymentGateway to process payment
        PaymentGateway paymentGateway = PaymentGateway.getInstance();

        boolean paymentSuccess = PaymentGateway.getInstance().processPayment(paymentType, totalAmount, CstmrName);

        if (paymentSuccess) {
            JOptionPane.showMessageDialog(null, "Payment successful! Total: $" + totalAmount);
            DefaultTableModel model = (DefaultTableModel) reservationtable.getModel();
            model.setRowCount(0);
            updatePaymentTable();
          
            
            // Clear the cart after successful payment
            ReservationManager.getInstance().clearCart();
            index=0;
            updateReservationTable(); // Refresh the cart table in the GUI
        } else {
            JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred during payment.");
    }
        
        
    }//GEN-LAST:event_ConfirmButtonActionPerformed
 public static double convertStringToDouble(String str) {
        try {
            return Double.parseDouble(str); // Directly convert
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + str);
            return 0; // Handle error appropriately
        }
    }
    private void payboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payboxActionPerformed

    private void warntybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warntybuttonActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = reservationtable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a product to add extended warranty.");
        return;
    }

    // Get the selected product from CartManager
    RoomComponent selectedProduct = ReservationManager.getInstance().getResevationItems().get(selectedRow);

    // Wrap the product with the WarrantyDecorator
    RoomComponent warrantyProduct = new WarrantyDecorator(selectedProduct);

    // Update the product in CartManager
    ReservationManager.getInstance().updateRoom(selectedRow, warrantyProduct);

    // Update the cart table to reflect the changes
    updateReservationTable();
             
    }//GEN-LAST:event_warntybuttonActionPerformed

    private void typetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typetxtActionPerformed

    private void pricetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricetxtActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JButton ReserveButton;
    private javax.swing.JButton addroom;
    private javax.swing.JButton cloneroom;
    private javax.swing.JComboBox<String> customerbox;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nametxt;
    private javax.swing.JComboBox<String> paybox;
    private javax.swing.JTable paymentable;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JTable reservationtable;
    private javax.swing.JTable roomtable;
    private javax.swing.JTextField statustxt;
    private javax.swing.JTextField typetxt;
    private javax.swing.JButton warntybutton;
    // End of variables declaration//GEN-END:variables
}
