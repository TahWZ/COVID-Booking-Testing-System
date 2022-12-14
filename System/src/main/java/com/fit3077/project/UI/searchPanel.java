/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fit3077.project.UI;

import com.fit3077.project.UI.utils.loginListener;
import com.fit3077.project.UI.onlineBookingForm;
import com.fit3077.project.UI.homeBookingForm;
import com.fit3077.project.UI.Home;
import com.fit3077.project.models.booking.bookingAPICollection;
import com.fit3077.project.models.booking.bookingCollection;
import com.fit3077.project.models.testingSite.testingSiteAPICollection;
import com.fit3077.project.models.testingSite.testingSite;
import com.fit3077.project.models.testingSite.testingSiteCollection;
import com.fit3077.project.models.user.User;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * The panel use to search for testing sites, allows various filtering functions and check on testing site state on future dates
 * @author User
 */
public class searchPanel extends javax.swing.JPanel implements loginListener {
    
    private Boolean loginState = false;
    private TableRowSorter<TableModel> sorter;
    
    /**
     * Creates new form searchPanel
     */
    public searchPanel() throws Exception {
        initComponents();
        loadSearchTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        comboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        bookButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        dateComboBox = new javax.swing.JComboBox<>();
        comboBox2 = new javax.swing.JComboBox<>();
        homeTestCheckBox = new javax.swing.JCheckBox();

        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Postcode", "Suburb", "Facility type", "Walk-in", "Drive-through", "On-site booking", "On-site testing", "Opening time", "Status", "Waiting time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        searchTable.setColumnSelectionAllowed(true);
        searchTable.setFocusable(false);
        searchTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        searchTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(searchTable);
        searchTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (searchTable.getColumnModel().getColumnCount() > 0) {
            searchTable.getColumnModel().getColumn(0).setMaxWidth(50);
            searchTable.getColumnModel().getColumn(1).setMinWidth(250);
        }

        comboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Drive-through", "Walk-in" }));
        comboBox1.setToolTipText("");

        jLabel2.setText("Advanced search");

        jLabel1.setText("Search by suburb or postcode");

        searchField.setText("Clayton");

        bookButton.setText("Book");
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        dateComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dateComboBoxItemStateChanged(evt);
            }
        });

        comboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Clinic", "GP", "Hospital" }));

        homeTestCheckBox.setText("Home testing");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1260, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(searchField)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                                    .addComponent(homeTestCheckBox)
                                    .addGap(18, 18, 18)
                                    .addComponent(bookButton)))))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookButton)
                        .addComponent(searchButton)
                        .addComponent(dateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(homeTestCheckBox))
                    .addContainerGap(11, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        // TODO add your handling code here:
        if (!loginState){
            JOptionPane.showMessageDialog(this, "Please login to book", "Booking Failed",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int row = searchTable.getSelectedRow();
        int localID = -1;
        if (row != -1){
            localID = (int)searchTable.getValueAt(row,0);
        }
        if (homeTestCheckBox.isSelected()){
            homeBookingForm booking = new homeBookingForm(localID);
            booking.setVisible(true);
        } else{
            onlineBookingForm booking = new onlineBookingForm(localID);
            booking.setVisible(true);
        }
    }//GEN-LAST:event_bookButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        sorter = new TableRowSorter<TableModel>((TableModel)searchTable.getModel());
        ArrayList<RowFilter<Object, Object>> orFilters = new ArrayList<RowFilter<Object, Object>>();
        ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();
        orFilters.add(RowFilter.regexFilter("("+ searchField.getText() +")", 2));
        orFilters.add(RowFilter.regexFilter("("+ searchField.getText() +")", 3));
        andFilters.add(RowFilter.orFilter(orFilters));
        if (comboBox1.getSelectedItem().toString().equals("Walk-in"))
        andFilters.add(RowFilter.regexFilter("(true)", 5));
        if (comboBox1.getSelectedItem().toString().equals("Drive-through"))
        andFilters.add(RowFilter.regexFilter("(true)", 6));
        if (comboBox2.getSelectedItem().toString().equals("Clinic"))
        andFilters.add(RowFilter.regexFilter("(Clinic)", 4));
        if (comboBox2.getSelectedItem().toString().equals("GP"))
        andFilters.add(RowFilter.regexFilter("(GP)", 4));
        if (comboBox2.getSelectedItem().toString().equals("Hospital"))
        andFilters.add(RowFilter.regexFilter("(Hospital)", 4));
        try {
            searchTable.setRowSorter(sorter);
            sorter.setRowFilter(RowFilter.andFilter(andFilters));
        } catch (Exception e){

        }
    }//GEN-LAST:event_searchButtonActionPerformed
    
    private void dateComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dateComboBoxItemStateChanged
        // TODO add your handling code here:
        updateDate();
    }//GEN-LAST:event_dateComboBoxItemStateChanged

    /**
     * Loads the table with all the testing site details
     */
    public void loadSearchTable(){
        testingSiteCollection tsCollection = testingSiteAPICollection.getInstance();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DefaultTableModel model = (DefaultTableModel) searchTable.getModel();
        model.setNumRows(0);
        for (testingSite tsite: tsCollection.getTestingSites()) {
            Object[] row = {
                tsite.getLocalID(),
                tsite.getName(),
                tsite.getPostcode(),
                tsite.getSuburb(),
                tsite.getFacilityType(),
                tsite.getHasWalkIn(),
                tsite.getHasDriveThrough(),
                tsite.getOnSiteBooking(),
                tsite.getOnSiteTesting(),
                tsite.getOpenTime(),
                tsite.getStatus(),
                0
            };
            model.addRow(row);
        }
        DefaultComboBoxModel<String> cbModel = new DefaultComboBoxModel<>();
        LocalDate date = LocalDate.now();
        for (int i = 0;i < Home.getAdvDays(); i++){
            cbModel.addElement(date.plusDays(i).toString());
        }
        dateComboBox.setModel(cbModel);
        updateDate();
    }
    
    /**
     * Updates waiting time when certain fields are changed
     */
    private void updateDate(){
        testingSiteCollection tsCollection = testingSiteAPICollection.getInstance();
        bookingCollection bCollection = bookingAPICollection.getInstance();
        DefaultTableModel model = (DefaultTableModel) searchTable.getModel();
        int i = 0; 
        for (testingSite tsite: tsCollection.getTestingSites()) {
            model.setValueAt(bCollection.getWaitingTime(tsite, dateComboBox.getSelectedItem().toString()), i, 11);
            i++;
        }
    }
    
    //Listener
    public void updateUser(User newUser){
        if (newUser != null)
            loginState = true;
        else
            loginState = false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bookButton;
    private javax.swing.JComboBox<String> comboBox1;
    private javax.swing.JComboBox<String> comboBox2;
    private javax.swing.JComboBox<String> dateComboBox;
    private javax.swing.JCheckBox homeTestCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable searchTable;
    // End of variables declaration//GEN-END:variables
}
