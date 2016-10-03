/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.components.player;

import AppPackage.AnimationClass;
import com.components.mysqlconnect;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerEventAdapter;
import uk.co.caprica.vlcj.player.list.MediaListPlayerMode;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;



public class MediaMainWindow extends javax.swing.JFrame {
   private int screen;
   AnimationClass ac = new AnimationClass();
   GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] gs = ge.getScreenDevices();
   ResultSet rs = null;
    Connection connection = null;
    PreparedStatement pst = null;
    
   
   int timeRun=0;
    private MediaPlayerFactory mediaPlayerFactory1,mediaPlayerFactory;
   private EmbeddedMediaPlayer mediaPlayer1,mediaPlayer;
 
    public MediaMainWindow() {
        connection = mysqlconnect.ConnectDb();
    final String jnaLibraryPath = System.getProperty("jna.library.path");
        final StringBuilder newJnaLibraryPath = new StringBuilder(jnaLibraryPath != null ? (jnaLibraryPath + ":") : "");
        newJnaLibraryPath.append("lib");
        System.setProperty("jna.library.path", newJnaLibraryPath.toString());

        initComponents();
        populatejLabel();
       player();
        CLOCK();
        slide();
     
    /*try{webService();}
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Couldnt fetch weather data from the web");
    }*/
       
    }
    
  public static void showOnScreen(int screen, MediaMainWindow frame) {
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
        }
public void slide()
{
   new Thread(){
        public void run(){
            try {
                
           
        while(true){            
            
      
    ac.jLabelXRight(-1400, 1400, 60, 5, label);
    label.setBounds(-1400, 500, 1400, 300);
    Thread.sleep(2000);
     ac.jLabelXRight(-2800, 1400, 60, 5, label2);
    label2.setBounds(-2800, 500, 1400, 300);
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

        jButton1 = new javax.swing.JButton();
        jTemplate1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        canvas1 = new java.awt.Canvas();
        jPanel4 = new javax.swing.JPanel();
        canvas2 = new java.awt.Canvas();
        jTemplate2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Clock = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cloudIcon = new javax.swing.JLabel();
        set = new javax.swing.JLabel();
        temperature = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        wind = new javax.swing.JLabel();
        visibility = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        humidity = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Signage Player");
        setName("Signage Player\n"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1400, 700));
        getContentPane().setLayout(null);

        jButton1.setText("Close");
        jButton1.setPreferredSize(new java.awt.Dimension(65, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(700, 680, 65, 23);

        jTemplate1.setBackground(new java.awt.Color(255, 51, 51));
        jTemplate1.setMaximumSize(new java.awt.Dimension(1200, 600));
        jTemplate1.setMinimumSize(new java.awt.Dimension(1200, 700));
        jTemplate1.setPreferredSize(new java.awt.Dimension(1000, 500));
        jTemplate1.setLayout(null);

        jPanel3.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel3.setLayout(null);

        canvas1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel3.add(canvas1);
        canvas1.setBounds(0, 0, 500, 500);

        jTemplate1.add(jPanel3);
        jPanel3.setBounds(0, 0, 500, 500);

        jPanel4.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel4.setLayout(null);

        canvas2.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel4.add(canvas2);
        canvas2.setBounds(0, 0, 500, 500);

        jTemplate1.add(jPanel4);
        jPanel4.setBounds(500, 0, 500, 500);

        getContentPane().add(jTemplate1);
        jTemplate1.setBounds(0, 0, 1000, 500);

        jTemplate2.setBackground(new java.awt.Color(255, 255, 255));
        jTemplate2.setPreferredSize(new java.awt.Dimension(400, 500));
        jTemplate2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 150));
        jPanel1.setLayout(null);

        Clock.setBackground(new java.awt.Color(255, 0, 51));
        Clock.setFont(new java.awt.Font("DS-Digital", 1, 55)); // NOI18N
        Clock.setForeground(new java.awt.Color(0, 0, 204));
        Clock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Clock.setText("00:00:00 AM");
        Clock.setToolTipText("");
        Clock.setPreferredSize(new java.awt.Dimension(400, 120));
        jPanel1.add(Clock);
        Clock.setBounds(0, 11, 400, 86);

        jTemplate2.add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 150);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 350));
        jPanel2.setLayout(null);

        cloudIcon.setBackground(new java.awt.Color(0, 0, 0));
        cloudIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/components/ICONS/WEATHER_ICONS/cloudy.png"))); // NOI18N
        jPanel2.add(cloudIcon);
        cloudIcon.setBounds(10, 48, 64, 70);

        set.setBackground(new java.awt.Color(153, 153, 153));
        set.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        set.setForeground(new java.awt.Color(102, 102, 102));
        set.setText("status");
        jPanel2.add(set);
        set.setBounds(10, 0, 263, 42);

        temperature.setBackground(new java.awt.Color(153, 153, 153));
        temperature.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        temperature.setText("temp");
        jPanel2.add(temperature);
        temperature.setBounds(74, 70, 350, 49);

        location.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        location.setForeground(new java.awt.Color(153, 153, 153));
        location.setPreferredSize(new java.awt.Dimension(400, 0));
        jPanel2.add(location);
        location.setBounds(0, 299, 394, 45);

        wind.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        wind.setForeground(new java.awt.Color(153, 153, 153));
        wind.setText("Variable at 2 MPH ");
        jPanel2.add(wind);
        wind.setBounds(70, 180, 270, 33);

        visibility.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        visibility.setForeground(new java.awt.Color(153, 153, 153));
        visibility.setText("4 MILES");
        jPanel2.add(visibility);
        visibility.setBounds(70, 220, 273, 34);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Wind:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 180, 79, 34);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Visibility:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 220, 79, 34);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Humidity:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 260, 79, 34);

        humidity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        humidity.setForeground(new java.awt.Color(153, 153, 153));
        humidity.setText("94");
        jPanel2.add(humidity);
        humidity.setBounds(70, 260, 273, 34);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Feels Like");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(185, 48, 88, 22);

        jTemplate2.add(jPanel2);
        jPanel2.setBounds(0, 150, 400, 350);

        getContentPane().add(jTemplate2);
        jTemplate2.setBounds(1000, 0, 400, 500);

        label.setBackground(new java.awt.Color(255, 255, 204));
        label.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label.setText("New Offer at shop no 20 !!!!!! SALE !!SALE!!!SALE");
        label.setMaximumSize(new java.awt.Dimension(49, 19));
        label.setPreferredSize(new java.awt.Dimension(1400, 200));
        getContentPane().add(label);
        label.setBounds(-1400, 500, 1400, 200);

        label2.setBackground(new java.awt.Color(255, 255, 204));
        label2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        label2.setText("New Offer at shop no 20 !!!!!! SALE !!SALE!!!SALE");
        label2.setPreferredSize(new java.awt.Dimension(1400, 200));
        getContentPane().add(label2);
        label2.setBounds(-2800, 500, 1400, 200);

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
     showOnScreen(1, new MediaMainWindow());
      //showOnScreen(2, new MediaMainWindow());
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            
            public void run() {
   
    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Clock;
    private java.awt.Canvas canvas1;
    private java.awt.Canvas canvas2;
    private javax.swing.JLabel cloudIcon;
    private javax.swing.JLabel humidity;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jTemplate1;
    private javax.swing.JPanel jTemplate2;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel location;
    private javax.swing.JLabel set;
    private javax.swing.JLabel temperature;
    private javax.swing.JLabel visibility;
    private javax.swing.JLabel wind;
    // End of variables declaration//GEN-END:variables

 private void CLOCK() {
    new Thread(){
         public void run(){
         while(timeRun==0)
        {
        Calendar cal= new GregorianCalendar();
        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int am_pm = cal.get(Calendar.AM_PM);
        String day_night="";
        if(am_pm==1)
        {
        day_night="PM";
        }else{
        day_night="AM";
        }
        String time = hour+":"+min+":"+sec+" "+day_night;
        Clock.setText(time);
        }
        }
        }.start();
         
    }

   /* private void GetLayout() {
    
    d3= new Layot3();
       
        
         
        jTemplate3.setLayout(layot);
        GridBagConstraints e = new GridBagConstraints();
        e.gridx = 0;
        e.gridy = 0;
        
        
        jTemplate3.add(d3,e);
        
        
        
        
        d3.setVisible(true);
    }
*/
    private void webService() {           
    try {
        GlobalWeather service = new GlobalWeather();
         GlobalWeatherSoap s = service.getGlobalWeatherSoap();
        String xmlResultStringWeather= s.getWeather("Kathmandu", "Nepal");
        
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlResultStringWeather));
        
        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("CurrentWeather");
        
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            
            NodeList Location = element.getElementsByTagName("Location");
            Element line = (Element) Location.item(0);
            location.setText(getCharacterDataFromElement(line));
            
            NodeList Temperature = element.getElementsByTagName("Temperature");
            line = (Element) Temperature.item(0);
            temperature.setText(getCharacterDataFromElement(line));
            
            NodeList Wind = element.getElementsByTagName("Wind");
            line = (Element) Wind.item(0);
            wind.setText(getCharacterDataFromElement(line));
            
            NodeList RelativeHumidity = element.getElementsByTagName("RelativeHumidity");
            line = (Element) RelativeHumidity.item(0);
            humidity.setText(getCharacterDataFromElement(line));
            
            NodeList Visibility = element.getElementsByTagName("Visibility");
            line = (Element) Visibility.item(0);
            visibility.setText(getCharacterDataFromElement(line));
            
            NodeList SkyConditions = element.getElementsByTagName("SkyConditions");
            line = (Element) SkyConditions.item(0);
            set.setText(getCharacterDataFromElement(line));
            String s1= getCharacterDataFromElement(line);
            setIconImage(s1);
    }
    } catch (ParserConfigurationException | SAXException | IOException ex) {
        Logger.getLogger(MediaMainWindow.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void setIconImage(String s2){
    String s1=" mostly cloudy";
    String s5=" thunderstorms";
    String s3=" partly cloudy";
    String s4=" rain";
    if(s1.equalsIgnoreCase(s2))
    {
        ImageIcon icon = createImageIcon("/com/components/ICONS/WEATHER_ICONS/cloudy.png");
        cloudIcon.setIcon(icon);
    }
    
    else if(s3.equalsIgnoreCase(s2))
    {
        ImageIcon icon = createImageIcon("/com/components/ICONS/WEATHER_ICONS/partly_cloudy.png");
        cloudIcon.setIcon(icon);
    }
    
    else if(s3.equalsIgnoreCase(s2))
    {
        ImageIcon icon = createImageIcon("/com/components/ICONS/WEATHER_ICONS/rain.png");
        cloudIcon.setIcon(icon);
    }
    
    else if(s3.equalsIgnoreCase(s2))
    {
        ImageIcon icon = createImageIcon("/com/components/ICONS/WEATHER_ICONS/thunderstorms.png");
        cloudIcon.setIcon(icon);
    }
    }
    
    public static String getCharacterDataFromElement(Element e) {
    Node child = e.getFirstChild();
    if (child instanceof CharacterData) {
      CharacterData cd = (CharacterData) child;
      return cd.getData();
    }
    return "";
    }
    
     protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = MediaMainWindow.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private void player() {
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
                String txt2=rs.getString("path");
         
        mediaList1.addMedia(txt2, options1);
       rs.close();
                pst.close();
            }
        } catch (Exception e) {
        }

        mediaListPlayer1.setMediaList(mediaList1);
        mediaListPlayer1.setMode(MediaListPlayerMode.LOOP);
        mediaListPlayer1.play();
       
    }

    private void populatejLabel() {
     String textfrom ="SELECT text1 from sliding_text ";
     String getS = null;   
     try{
        pst = connection.prepareStatement(textfrom);
        rs = pst.executeQuery();
        if (rs.next()) {
          getS =rs.getString("text1");
         
                 }
        label.setText(getS);
        label2.setText(getS);
        }   catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }

    

