/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fit3077.project.UI;

import com.fit3077.project.UI.utils.bookingsListener;
import com.fit3077.project.models.booking.Booking;
import com.fit3077.project.models.booking.bookingAPICollection;
import com.fit3077.project.models.booking.bookingCollection;
import com.fit3077.project.models.booking.bookingNotification;
import com.fit3077.project.models.testingSite.testingSite;
import com.fit3077.project.models.user.User;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 * Panel which displays the history of booking changes that occur throughout run time
 * (Only for receptionists, and only shows changes to bookings in their workplace)
 * @author User
 */
public class bookingHistoryPanel extends javax.swing.JPanel implements bookingsListener{

    User currentUser;
    testingSite selectedTestingSite;
    
    /**
     * Creates new panel bookingHistoryPanel
     */
    public bookingHistoryPanel(testingSite selectedTestingSite) {
        initComponents();
        this.selectedTestingSite = selectedTestingSite;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookingHistoryTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bookingHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "Action", "Last modified"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bookingHistoryTable);
        if (bookingHistoryTable.getColumnModel().getColumnCount() > 0) {
            bookingHistoryTable.getColumnModel().getColumn(1).setMinWidth(350);
            bookingHistoryTable.getColumnModel().getColumn(1).setMaxWidth(350);
            bookingHistoryTable.getColumnModel().getColumn(2).setMinWidth(250);
            bookingHistoryTable.getColumnModel().getColumn(2).setMaxWidth(250);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1086, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Booking History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 
    /**
     * (bookingListener class method)
     * Called whenever a change to bookings is detected
     * Refreshes and adds the change to the table, 
     * allows users to see recent action were made to the recently changed booking
     */
    public void refreshBookings(bookingNotification bNotification){
        bookingCollection bCollection = bookingAPICollection.getInstance();
        DefaultTableModel model = (DefaultTableModel) bookingHistoryTable.getModel();
        Booking b = bCollection.getRecentBooking();
        if (b.getBookSite().getID() == this.selectedTestingSite.getID()){
            String lastModifiedTime;
            if (bNotification == bookingNotification.DELETED){
                lastModifiedTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
            } else{
                lastModifiedTime = b.getLastModTime();
            }
            try{
                Object[] row = {
                    b.getID(),
                    bNotification.toString(),
                    lastModifiedTime
                };
                model.addRow(row);
            } catch (Exception e){}
        } else if (bNotification == bookingNotification.MODIFIED && bCollection.getPreviousBookingSiteID() == this.selectedTestingSite.getID()){
            try{
                Object[] row = {
                    b.getID(),
                    bookingNotification.MOVED.toString(),
                    b.getLastModTime()
                };
                model.addRow(row);
            } catch (Exception e){}
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bookingHistoryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}