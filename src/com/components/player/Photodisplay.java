/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.components.player;

import AppPackage.AnimationClass;
import com.components.mysqlconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class Photodisplay extends javax.swing.JFrame {
String pic1,pic2,pic3,pic4;
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    AnimationClass ac = new AnimationClass();
    public Photodisplay() {
        initComponents();
       connection = mysqlconnect.ConnectDb();
       slide();
    }
    

   public void slide(){
      new Thread(){
      public void run(){
          while (true) {              
             int count=0; 
          
       try {
            String qry = "SELECT * FROM digitalsignage.picture";
            pst=connection.prepareStatement(qry);
            rs=pst.executeQuery();
            
            if (rs.next()) {
                   pic1=rs.getString("picture1");
           
            pic2=rs.getString("picture2");
           
            pic3=rs.getString("picture3");
          
            pic4=rs.getString("picture4");
         
            }
             switch(count)
    {
                     case 0:
                     
                      jLabel1.setIcon(new javax.swing.ImageIcon(pic1));
                       Thread.sleep(6000);
                      ac.jLabelXLeft(0,-1400,25,7,jLabel1);
                      ac.jLabelXLeft(1400,0,25,7,jLabel2);
                      jLabel2.setIcon(new javax.swing.ImageIcon(pic2));  
                        Thread.sleep(6000);
                      ac.jLabelXRight(-1400,0,25,7,jLabel1);
                      ac.jLabelXRight(0,1400,25,7,jLabel2); 
                      jLabel1.setIcon(new javax.swing.ImageIcon(pic3));
                         Thread.sleep(6000);
                       ac.jLabelXLeft(0,-1400,25,7,jLabel1);
                       ac.jLabelXLeft(1400,0,25,7,jLabel2);
                        jLabel2.setIcon(new javax.swing.ImageIcon(pic4));
                         Thread.sleep(6000);
                        ac.jLabelXRight(-1400,0,25,7,jLabel1);
                       ac.jLabelXRight(0,1400,25,7,jLabel2);
                        count =0;
                        break;
                   
                           
             }
           
        } catch (SQLException ex) {
   
        }     catch (InterruptedException ex) {
                  
              }
          }
        
      
      
      
      
      
      }
      }.start();
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(102, 255, 51));
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(1400, 787));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1400, 787);

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("jLabel2");
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(1400, 787));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1400, 0, 1400, 787);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Photodisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Photodisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Photodisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Photodisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Photodisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
