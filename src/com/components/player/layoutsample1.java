/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.components.player;

import AppPackage.AnimationClass;
import com.components.Home;
import com.components.mysqlconnect;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerEventAdapter;
import uk.co.caprica.vlcj.player.list.MediaListPlayerMode;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author lenovo
 */
public class layoutsample1 extends javax.swing.JFrame {
  private MediaPlayerFactory mediaPlayerFactory1,mediaPlayerFactory;
   private EmbeddedMediaPlayer mediaPlayer1,mediaPlayer;
    
    private int screen;
    Connection connection = null;
    PreparedStatement pst = null;
    //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    //GraphicsDevice[] gs = ge.getScreenDevices();
ResultSet rs = null;

      AnimationClass ac = new AnimationClass();
    public layoutsample1() {
        connection = mysqlconnect.ConnectDb();
        initComponents();
        populatelabel();        
        player();
        slide();
    }
     /* public static void showOnScreen(int screen, MediaMainWindow frame) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        if (screen > -1 && screen < gs.length) {
            frame.setScreen(screen);
            gs[screen].setFullScreenWindow(frame);
            frame.validate();
        } else if (gs.length > 0) {
            gs[0].setFullScreenWindow(frame);
        } else {
            throw new RuntimeException("No Screens Found");
        }
    }
    public void setScreen(int screen) {
    this.screen = screen;
        }*/
    public void player(){
        
        
     NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "lib");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
        
        
      mediaPlayerFactory = new MediaPlayerFactory();
        CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(canvas1);

      mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(videoSurface);

        MediaListPlayer mediaListPlayer = mediaPlayerFactory.newMediaListPlayer();

        mediaListPlayer.addMediaListPlayerEventListener(new MediaListPlayerEventAdapter() {
            @Override
            public void nextItem(MediaListPlayer mediaListPlayer, libvlc_media_t item, String itemMrl) {
                System.out.println("nextItem()");
            }
        });

        mediaListPlayer.setMediaPlayer(mediaPlayer); // Important, associate the media player with the media list player

        MediaList mediaList = mediaPlayerFactory.newMediaList();
        String[] options = {};
        
        try {
            
              String qry = "SELECT * FROM digitalsignage.layout1media1";
        pst=connection.prepareStatement(qry);
            rs=pst.executeQuery();
            while (rs.next()) {
                String txt1=rs.getString("path");
         
        mediaList.addMedia(txt1, options);
        // jTextField1.setText(txt1);
            }
        } catch (Exception e) {
        }
     
        
        
     

        mediaListPlayer.setMediaList(mediaList);
        mediaListPlayer.setMode(MediaListPlayerMode.LOOP);
         mediaListPlayer.play();


 mediaPlayerFactory1 = new MediaPlayerFactory();
        CanvasVideoSurface videoSurface1 = mediaPlayerFactory1.newVideoSurface(canvas2);

     mediaPlayer1 = mediaPlayerFactory1.newEmbeddedMediaPlayer();
        mediaPlayer1.setVideoSurface(videoSurface1);

        MediaListPlayer mediaListPlayer1 = mediaPlayerFactory1.newMediaListPlayer();

        mediaListPlayer1.addMediaListPlayerEventListener(new MediaListPlayerEventAdapter() {
            @Override
            public void nextItem(MediaListPlayer mediaListPlayer, libvlc_media_t item, String itemMrl) {
                System.out.println("nextItem()");
            }
        });

        mediaListPlayer1.setMediaPlayer(mediaPlayer1); // Important, associate the media player with the media list player
MediaList mediaList1 = mediaPlayerFactory.newMediaList();
        String[] options1 = {};
        
        try {
            
            String qry = "SELECT * FROM digitalsignage.layout1media2";
        pst=connection.prepareStatement(qry);
            rs=pst.executeQuery();
            while (rs.next()) {
                String txt1=rs.getString("path");
         
        mediaList1.addMedia(txt1, options1);
       rs.close();
                pst.close();
            }
        } catch (Exception e) {
        }

        mediaListPlayer1.setMediaList(mediaList1);
        mediaListPlayer1.setMode(MediaListPlayerMode.LOOP);
        mediaListPlayer1.play();
        mediaPlayer1.release();
        mediaPlayerFactory1.release();
        
        
  /*  for(;;) {
         try {
             Thread.sleep(500);
        
            mediaPlayer.setChapter(3);
           // mediaPlayer1.setChapter(3);
            Thread.sleep(5000);
            mediaListPlayer.playNext();
            //mediaListPlayer1.playNext();
         } catch (Exception e) {
         }
  
    }
*/}
    public void slide()
{
   new Thread(){
        public void run(){
            try {
                
           
        while(true){            
            
      
    ac.jLabelXRight(-1400, 1400, 60, 5, label3);
    label3.setBounds(-1400, 500, 1400, 200);
    Thread.sleep(2000);
     ac.jLabelXRight(-2800, 1400, 60, 5, label4);
    label4.setBounds(-2800, 500, 1400, 200);
    Thread.sleep(2000);
        
        }
         } catch (Exception e) {
            }
        
    }
            }.start();
            
}

   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        jPanel4 = new javax.swing.JPanel();
        canvas2 = new java.awt.Canvas();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1420, 810));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
        jPanel3.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        canvas1.setFont(new java.awt.Font("Trajan Pro", 3, 24)); // NOI18N
        canvas1.setPreferredSize(new java.awt.Dimension(698, 500));
        jPanel3.add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, -1));

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 700, 500);

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 5));
        jPanel4.setPreferredSize(new java.awt.Dimension(700, 500));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        canvas2.setFont(new java.awt.Font("Trajan Pro", 3, 24)); // NOI18N
        canvas2.setPreferredSize(new java.awt.Dimension(695, 500));
        jPanel4.add(canvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 690, -1));

        getContentPane().add(jPanel4);
        jPanel4.setBounds(700, 0, 700, 500);

        label3.setFont(new java.awt.Font("Trajan Pro 3", 1, 36)); // NOI18N
        label3.setPreferredSize(new java.awt.Dimension(1400, 300));
        getContentPane().add(label3);
        label3.setBounds(-1400, 500, 1400, 300);

        label4.setBackground(new java.awt.Color(51, 255, 153));
        label4.setFont(new java.awt.Font("Trajan Pro 3", 1, 36)); // NOI18N
        label4.setPreferredSize(new java.awt.Dimension(1400, 200));
        getContentPane().add(label4);
        label4.setBounds(-2800, 500, 1400, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      mediaPlayer.stop();
    mediaPlayer.release();
    mediaPlayerFactory.release();
        mediaPlayer1.stop();
    mediaPlayer1.release();
    mediaPlayerFactory1.release();
        dispose();
    
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(layoutsample1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(layoutsample1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(layoutsample1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(layoutsample1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      //   showOnScreen(1, new MediaMainWindow());// to show in screeensssssss 
     // showOnScreen(2, new MediaMainWindow());
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              new layoutsample1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    // End of variables declaration//GEN-END:variables

private void populatelabel() {
     String textfrom ="SELECT text1 from sliding_text ";
     String getS = null;   
     try{
        pst = connection.prepareStatement(textfrom);
        rs = pst.executeQuery();
        if (rs.next()) {
          getS =rs.getString("text1");
         
                 }
        label3.setText(getS);
        label4.setText(getS);
        }   catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
