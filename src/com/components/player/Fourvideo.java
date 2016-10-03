package com.components.player;

import com.components.mysqlconnect;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
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
public class Fourvideo extends javax.swing.JFrame {
private MediaPlayerFactory mediaPlayerFactory,mediaPlayerFactory1,mediaPlayerFactory2,mediaPlayerFactory3;
   private EmbeddedMediaPlayer mediaPlayer1,mediaPlayer,mediaPlayer2,mediaPlayer3;
      Connection connection = null;
    PreparedStatement pst = null;
ResultSet rs = null;
    public Fourvideo() {
        initComponents();
        connection = mysqlconnect.ConnectDb();
        player();
    }

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
            
            String qry = "SELECT * FROM layout2media1";
        pst=connection.prepareStatement(qry);
        rs=pst.executeQuery();
        while (rs.next()) {
        String txt1=rs.getString("media1");
                        
        mediaList.addMedia(txt1, options);
        }
        rs.close();
       pst.close();
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
            
            String qry = "SELECT * FROM layout2media2";
        pst=connection.prepareStatement(qry);
            rs=pst.executeQuery();
            while (rs.next()) {
                String txt1=rs.getString("media2");
         
        mediaList1.addMedia(txt1, options1);
        // jTextField1.setText(txt1);
            }
            
            
        } catch (Exception e) {
        }

        mediaListPlayer1.setMediaList(mediaList1);
        mediaListPlayer1.setMode(MediaListPlayerMode.LOOP);
        mediaListPlayer1.play();
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
  
    }*/
                
     NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "lib");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
        
        
    mediaPlayerFactory2 = new MediaPlayerFactory();
        CanvasVideoSurface videoSurface2 = mediaPlayerFactory2.newVideoSurface(canvas3);

    mediaPlayer2 = mediaPlayerFactory2.newEmbeddedMediaPlayer();
        mediaPlayer2.setVideoSurface(videoSurface2);

        MediaListPlayer mediaListPlayer2 = mediaPlayerFactory2.newMediaListPlayer();

        mediaListPlayer2.addMediaListPlayerEventListener(new MediaListPlayerEventAdapter() {
            @Override
            public void nextItem(MediaListPlayer mediaListPlayer, libvlc_media_t item, String itemMrl) {
                System.out.println("nextItem()");
            }
        });

        mediaListPlayer2.setMediaPlayer(mediaPlayer2); // Important, associate the media player with the media list player

        MediaList mediaList2 = mediaPlayerFactory2.newMediaList();
        String[] options2 = {};
        
        try {
            
            String qry = "SELECT * FROM layout2media3";
        pst=connection.prepareStatement(qry);
            rs=pst.executeQuery();
            while (rs.next()) {
                String txt1=rs.getString("media3");
         
        mediaList2.addMedia(txt1, options2);
        // jTextField1.setText(txt1);
            }
        } catch (Exception e) {
        }
     
        
        
     

        mediaListPlayer2.setMediaList(mediaList2);
        mediaListPlayer2.setMode(MediaListPlayerMode.LOOP);
         mediaListPlayer2.play();


 mediaPlayerFactory3 = new MediaPlayerFactory();
        CanvasVideoSurface videoSurface3 = mediaPlayerFactory3.newVideoSurface(canvas4);

       mediaPlayer3 = mediaPlayerFactory3.newEmbeddedMediaPlayer();
        mediaPlayer3.setVideoSurface(videoSurface3);

        MediaListPlayer mediaListPlayer3 = mediaPlayerFactory3.newMediaListPlayer();

        mediaListPlayer3.addMediaListPlayerEventListener(new MediaListPlayerEventAdapter() {
            @Override
            public void nextItem(MediaListPlayer mediaListPlayer, libvlc_media_t item, String itemMrl) {
                System.out.println("nextItem()");
            }
        });

        mediaListPlayer3.setMediaPlayer(mediaPlayer3); // Important, associate the media player with the media list player
MediaList mediaList3 = mediaPlayerFactory.newMediaList();
        String[] options3 = {};
        
        try {
            
            String qry = "SELECT * FROM layout2media4";
        pst=connection.prepareStatement(qry);
            rs=pst.executeQuery();
            while (rs.next()) {
                String txt1=rs.getString("media4");
         
        mediaList3.addMedia(txt1, options3);
        // jTextField1.setText(txt1);
            }
            
            
        } catch (Exception e) {
        }

        mediaListPlayer3.setMediaList(mediaList3);
        mediaListPlayer3.setMode(MediaListPlayerMode.LOOP);
        mediaListPlayer3.play();

     
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        jPanel2 = new javax.swing.JPanel();
        canvas2 = new java.awt.Canvas();
        jPanel3 = new javax.swing.JPanel();
        canvas3 = new java.awt.Canvas();
        jPanel4 = new javax.swing.JPanel();
        canvas4 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Close");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        canvas1.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel1.add(canvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        canvas2.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel2.add(canvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        canvas3.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel3.add(canvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        canvas4.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel4.add(canvas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    mediaPlayer.stop();
    mediaPlayer.release();
    mediaPlayerFactory.release();
        mediaPlayer1.stop();
    mediaPlayer1.release();
    mediaPlayerFactory1.release();
         mediaPlayer2.stop();
    mediaPlayer2.release();
    mediaPlayerFactory2.release();
        mediaPlayer3.stop();
    mediaPlayer3.release();
    mediaPlayerFactory3.release();
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased

    }//GEN-LAST:event_jButton1MouseReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Fourvideo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fourvideo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fourvideo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fourvideo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
       new Fourvideo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private java.awt.Canvas canvas3;
    private java.awt.Canvas canvas4;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
