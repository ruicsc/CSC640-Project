/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Chase
 */
public class CheckinWindow extends javax.swing.JDialog {

    /**
     * Creates new form CheckinWindow
     */
    public CheckinWindow() {
        initComponents();
        setTitle("Check In");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Last Name:");

        jLabel2.setText("Cell Phone:");

        jLabel3.setText("Group Size:");

        jLabel4.setText("Table No :");

        jLabel5.setText("Waiter:");

        jButton1.setText("Search");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Check in");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean getReservation(String custName, String phoneNum)
    {
        Connection cn = null;
        Statement stmt = null;
        
        try {
            //search database
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        try {
            cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
            
        try {
            stmt = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        String sql = "SELECT * FROM reservation where CustName=" + "'" + 
                custName + "'" + " and Phone=" + "'" + phoneNum + "'";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                tableSize = rs.getInt("TableSize");
            }
            if(tableSize != 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
            return false;
        }
    }
    
    private String getAvailableWaiter()
    {
        Connection cn = null;
        Statement stmt = null;
        String waiter = "";
        int capability = 0;
        
        try {
            //search database
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        try {
            cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
            
        try {
            stmt = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        String sq2 = "SELECT * FROM waiter where 1";
        try {
            ResultSet rs = stmt.executeQuery(sq2);
            while(rs.next())
            {
                if(rs.getInt("Capability") > capability){
                    capability = rs.getInt("Capability");
                    waiter = rs.getString("WaiterName");
                }
            }
            freeLoad = capability - 1;
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        
        return waiter;
    }
    
    private boolean getAvailableTable()
    {
        Connection cn = null;
        Statement stmt = null;
        boolean result = false;
        
        try {
            //search database
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        try {
            cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
            
        try {
            stmt = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        String sq3 = "SELECT * FROM tables where TableSize=" 
                + Integer.toString(tableSize);
        try {
            ResultSet rs = stmt.executeQuery(sq3);
            while(rs.next()){
                if(rs.getInt("AvailableNumber") > 0){
                    freeTable= rs.getInt("AvailableNumber") - 1;
                    result = true;
                }
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
            return false;
        }
    }
    
    private boolean isOccupied(int tableNum)
    {
        Connection cn = null;
        Statement stmt = null;
        
        try {
            //search database
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        try {
            cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
            
        try {
            stmt = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        String sq4 = "SELECT * FROM reservation where TableNumber=" 
                + "'" + tableNum + "'";
        try {
            ResultSet rs = stmt.executeQuery(sq4);
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
            return true;
        }
    }
    
    private boolean isCheckedIn(String custName, String phoneNum)
    {
        Connection cn = null;
        Statement stmt = null;
        boolean result = true;
        
        try {
            //search database
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        try {
            cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
            
        try {
            stmt = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        String sq4 = "SELECT * FROM reservation where CustName=" 
                + "'" + custName + "' " + "and Phone=" + "'" +
                phoneNum + "'";
        try {
            ResultSet rs = stmt.executeQuery(sq4);
            while(rs.next()){
                if(rs.getInt("TableNumber") == 0){
                    result = false;
                }
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(CheckinWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
            return true;
        }
    }
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (getReservation(jTextField1.getText(),jTextField2.getText())){
            if(!getAvailableWaiter().equals("")){
                JOptionPane.showMessageDialog(null,"Reservation found, please check in.");
                jTextField5.setText(getAvailableWaiter());
                jTextField1.setEditable(false);
                jTextField2.setEditable(false);
                jTextField5.setEditable(false);
                jButton1.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null,"No waiter available, please wait a moment.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Reservation not found!");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Connection cn = null;
        Statement stmt = null;
        
        if(Integer.parseInt(jTextField3.getText()) > tableSize){
            JOptionPane.showMessageDialog(null,"Group size can't be bigger than " + tableSize + ".");
        }else if(isOccupied(Integer.parseInt(jTextField4.getText()))){
            JOptionPane.showMessageDialog(null,"Table " + jTextField4.getText() + " is occupied, please retry.");
        }else if(Integer.parseInt(jTextField4.getText()) > 18 || Integer.parseInt(jTextField4.getText()) < 1){
            JOptionPane.showMessageDialog(null,"Table number should be from 1 to 18.");
        }else if(!getAvailableTable()){
            JOptionPane.showMessageDialog(null,"Table of size " + tableSize + " is full, please wait a moment.");
        }else if(isCheckedIn(jTextField1.getText(), jTextField2.getText())){
            JOptionPane.showMessageDialog(null,"Customer has already checked in.");
        }else{
            try {
                //search database
                Class.forName( "com.mysql.jdbc.Driver" );
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CheckinWindow.class.getName()).
                        log(Level.SEVERE,
                        null,
                        ex);
            }
            try {
                cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
            } catch (SQLException ex) {
                Logger.getLogger(CheckinWindow.class.getName()).
                        log(Level.SEVERE,
                        null,
                        ex);
            }

            try {
                stmt = cn.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(CheckinWindow.class.getName()).
                        log(Level.SEVERE,
                        null,
                        ex);
            }

            String sq5 = "UPDATE waiter SET Capability=" +
                        "'" + freeLoad + "' " + "where WaiterName=" 
                        + "'" + jTextField5.getText() + "'";
            try {
                stmt.executeUpdate(sq5);
            } catch (SQLException ex) {
                Logger.getLogger(CheckinWindow.class.getName()).
                        log(Level.SEVERE,
                        null,
                        ex);
            }

            String sq6 = "UPDATE tables SET AvailableNumber=" +
                        "'" + freeTable + "' " + "where TableSize=" 
                        + "'" + tableSize + "'";
            try {
                stmt.executeUpdate(sq6);
            } catch (SQLException ex) {
                Logger.getLogger(CheckinWindow.class.getName()).
                        log(Level.SEVERE,
                        null,
                        ex);
            }

            String sq7 = "UPDATE reservation SET GroupSize=" + "'" 
                    + jTextField3.getText() + "' " + ",TableNumber=" + "'" +
                    jTextField4.getText() + "' " + ",Waiter=" + "'" +
                    jTextField5.getText() + "' " + "where CustName=" + "'" +
                    jTextField1.getText() + "' " + "and Phone=" + "'" +
                    jTextField2.getText() + "'";
            try {
                stmt.executeUpdate(sq7);
            } catch (SQLException ex) {
                Logger.getLogger(CheckinWindow.class.getName()).
                        log(Level.SEVERE,
                        null,
                        ex);
            }
            JOptionPane.showMessageDialog(null,"Checked in successfully!");
            dispose();
        }
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(CheckinWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckinWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckinWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckinWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckinWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
    private int tableSize = 0;
    private int freeLoad = 0;
    private int freeTable = 0;
}
