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
public class CheckoutWindow extends javax.swing.JDialog {

    /**
     * Creates new form CheckoutWindow
     */
    public CheckoutWindow() {
        initComponents();
        summaryFound = false;
        setTitle("Check Out");
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jLabel1.setText("Table No:");

        jButton1.setLabel("Search");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Check out");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel2.setText("Table Summary");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean getSummary(int tableNum)
    {
        Connection cn = null;
        Statement stmt = null;
        
        try {
            //search database
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        try {
            cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
            
        try {
            stmt = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        String sql = "SELECT * FROM guest where TableNumber=" + "'" + 
                tableNum + "'";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                orderSummary += rs.getString("GuestName") + "\n" +
                        rs.getString("Course") + "\n";
                totalPrice += rs.getFloat("Price");
                summaryFound = true;
            }
            return summaryFound;
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
            return false;
        }
    }
    
    private void releaseWaiter(int tableNum)
    {
        Connection cn = null;
        Statement stmt = null;
        String waiter = "";
        int capability = 0;
        
        try {
            //search database
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        try {
            cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
            
        try {
            stmt = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        
        String sq2 = "SELECT * FROM reservation where TableNumber=" + "'" + 
                tableNum + "'";
        try {
            ResultSet rs = stmt.executeQuery(sq2);
            while(rs.next())
            {
                waiter = rs.getString("Waiter");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        
        String sq3 = "SELECT * FROM waiter where WaiterName=" + "'" + 
                waiter + "'";
        try {
            ResultSet rs = stmt.executeQuery(sq3);
            while(rs.next())
            {
                capability = rs.getInt("Capability") + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        
        String sq4 = "UPDATE waiter SET Capability=" +
                        "'" + capability + "' " + "where WaiterName=" 
                        + "'" + waiter + "'";
        try {
            stmt.executeUpdate(sq4);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
    }
    
    private void releaseTable(int tableNum)
    {
        Connection cn = null;
        Statement stmt = null;
        int tableSize = 0;
        int capability = 0;
        
        try {
            //search database
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        try {
            cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
            
        try {
            stmt = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        
        String sq5 = "SELECT * FROM reservation where TableNumber=" + "'" + 
                tableNum + "'";
        try {
            ResultSet rs = stmt.executeQuery(sq5);
            while(rs.next())
            {
                tableSize = rs.getInt("TableSize");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        
        String sq6 = "SELECT * FROM tables where TableSize=" + "'" + 
                tableSize + "'";
        try {
            ResultSet rs = stmt.executeQuery(sq6);
            while(rs.next())
            {
                capability = rs.getInt("AvailableNumber") + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        
        String sq7 = "UPDATE tables SET AvailableNumber=" +
                        "'" + capability + "' " + "where TableSize=" 
                        + "'" + tableSize + "'";
        try {
            stmt.executeUpdate(sq7);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
    }
    
    private void eraseReservation(int tableNum)
    {
        Connection cn = null;
        Statement stmt = null;
        
        try {
            //search database
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        try {
            cn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/rms?zeroDateTimeBehavior=convertToNull", "rmsUser", "12345678" );
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
            
        try {
            stmt = cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        
        String sq8 = "DELETE FROM reservation where TableNumber=" 
                        + "'" + tableNum + "'";
        try {
            stmt.executeUpdate(sq8);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
        
        String sq9 = "DELETE FROM guest where TableNumber=" 
                        + "'" + tableNum + "'";
        try {
            stmt.executeUpdate(sq9);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutWindow.class.getName()).
                    log(Level.SEVERE,
                    null,
                    ex);
        }
    }
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(getSummary(Integer.parseInt(jTextField1.getText()))){
            jTextArea1.setText(orderSummary + "\nTotal Price: " + totalPrice);
            jTextField1.setEditable(false);
            jButton1.setEnabled(false);
            jTextArea1.setEditable(false);
        }else{
            JOptionPane.showMessageDialog(null,"Table not found, please retry.");
        }  
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if(summaryFound){
            JOptionPane.showMessageDialog(null,"Checkout successfully! Welcome to come again!.");
            releaseWaiter(Integer.parseInt(jTextField1.getText()));
            releaseTable(Integer.parseInt(jTextField1.getText()));
            eraseReservation(Integer.parseInt(jTextField1.getText()));
            dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Table not found, please retry.");
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
            java.util.logging.Logger.getLogger(CheckoutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckoutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckoutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckoutWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CheckoutWindow().setVisible(true);
            }
        });
    }
    
    private boolean summaryFound;
    private String orderSummary = "";
    private float totalPrice = 0.0f;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
