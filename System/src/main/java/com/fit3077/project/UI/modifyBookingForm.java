/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fit3077.project.UI;

import com.fit3077.project.models.booking.Booking;
import com.fit3077.project.models.booking.bookingAPI;
import com.fit3077.project.models.booking.bookingAPICollection;
import com.fit3077.project.models.booking.bookingCollection;
import com.fit3077.project.models.user.User;
import com.fit3077.project.models.testingSite.testingSite;
import com.fit3077.project.models.testingSite.testingSiteAPICollection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Form which allows users to modify details of a booking
 * @author User
 */
public class modifyBookingForm extends javax.swing.JFrame {

    private Booking currentBooking;
    private User currentPatient;
    private testingSite selectedTS;
    
    /**
     * Creates new form bookingForm
     */
    public modifyBookingForm(Booking currentBooking) {
        initComponents();
        loadDates();
        this.currentBooking = currentBooking;
        testingSiteIDField.setText(String.valueOf(currentBooking.getBookSite().getLocalID()));
        bookingIDField.setText(currentBooking.getID());
        patientNameField.setText(currentBooking.getPatient().getFullName());
        changeTestingSite();
        updateWaitingTime();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        testingSiteNameField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        waitingTimeField = new javax.swing.JTextField();
        testingSiteIDField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        changeButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        dateComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        bookingIDField = new javax.swing.JTextField();
        patientNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Modify booking");

        jLabel2.setText("Patient name");

        jLabel5.setText("Waiting time");

        jLabel6.setText("Testing site name");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        testingSiteNameField.setEditable(false);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        waitingTimeField.setEditable(false);

        jLabel4.setText("Testing site ID");

        changeButton.setText("Change");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Date");

        dateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dateComboBoxItemStateChanged(evt);
            }
        });

        jLabel8.setText("Booking ID");

        bookingIDField.setEditable(false);

        patientNameField.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bookingIDField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(testingSiteIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(changeButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(patientNameField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(waitingTimeField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(submitButton)
                                        .addGap(70, 70, 70)
                                        .addComponent(cancelButton))
                                    .addComponent(testingSiteNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(bookingIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(patientNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(testingSiteIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(changeButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(testingSiteNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(waitingTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Patches the booking on the API Web Service
     */
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (selectedTS == null){
            JOptionPane.showMessageDialog(this, "Please select a testing site before submit", "Submit failed",JOptionPane.INFORMATION_MESSAGE);
        } else if (!selectedTS.getOnSiteTesting()){
            JOptionPane.showMessageDialog(this, "Selected testing site does not provide on-site testing", "Submit failed",JOptionPane.INFORMATION_MESSAGE);
        } else{  
            String lastModTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date());
            
            //Creates a save point
            currentBooking.createSavepoint(lastModTime);
            
            //Loads additionalInfo data
            String additionalInfo = "{}";
                additionalInfo = "{" +
                "\"QRcode\":\"" + currentBooking.getQRcode() + "\"," +
                "\"testType\":\"" + currentBooking.getTestType() + "\"," +
                "\"homeTest\":" + currentBooking.isHomeTest() + "," +        
                "\"URL\":\"" + " " + "\"," +
                "\"lastModifiedTime\":\"" + lastModTime + "\"," +
                currentBooking.getBookingCaretaker().getMementosJSON() +
                "}";
            
            //Sets the fields to patch
            String jsonString = "{" +
            "\"testingSiteId\":\"" + selectedTS.getID() + "\"," +
            "\"startTime\":\"" + dateComboBox.getSelectedItem() + "T" + selectedTS.getOpenTime() + ":00.000Z" + "\"," +
            "\"additionalInfo\":" + additionalInfo + "" +
            "}";

            //If successful, display success in a message box
            if (bookingAPI.patchBookings(jsonString, currentBooking.getID())){
                JOptionPane.showMessageDialog(this, "Booking successfully modified.", "Patching successful",JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    /**
     * Closes te display
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Changes the testingSite based on user's input
     */
    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        // TODO add your handling code here:
        changeTestingSite();
    }//GEN-LAST:event_changeButtonActionPerformed

    /**
     * invokes the updateWaitingTime method when the combo box's selected item changes
     */
    private void dateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dateComboBoxItemStateChanged
        // TODO add your handling code here:
        if (selectedTS!=null){
            updateWaitingTime();
        }
    }//GEN-LAST:event_dateComboBoxItemStateChanged

    /**
     * Changes the waiting time (Number of booking * 20)
     */
    private void updateWaitingTime(){
        bookingCollection bCollection = bookingAPICollection.getInstance();
        waitingTimeField.setText(String.valueOf(bCollection.getWaitingTime(selectedTS, dateComboBox.getSelectedItem().toString())));
    }
    
    /**
     * Search and replaces the testing site using local ID
     */
    private void changeTestingSite(){
        try{
            testingSiteAPICollection tCollection = testingSiteAPICollection.getInstance();
            int id = Integer.parseInt(testingSiteIDField.getText());
            testingSite tsite = tCollection.getTestingSiteByLocalID(id);
            if (tsite == null){
                JOptionPane.showMessageDialog(this, "Invalid testing site ID", "Change failed",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            selectedTS = tsite;
            testingSiteNameField.setText(tsite.getName());
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "An error occured", "Error",JOptionPane.ERROR_MESSAGE);
        }
        updateWaitingTime();
    }
    
    /**
     * Loads the dates on the combo box
     */
    private void loadDates(){
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<>();
        LocalDate date = LocalDate.now();
        for (int i = 0;i < Home.getAdvDays(); i++){
            cbModel.addElement(date.plusDays(i).toString());
        }
        dateComboBox.setModel(cbModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bookingIDField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeButton;
    private javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField patientNameField;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField testingSiteIDField;
    private javax.swing.JTextField testingSiteNameField;
    private javax.swing.JTextField waitingTimeField;
    // End of variables declaration//GEN-END:variables
}
