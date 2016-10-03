import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static uk.co.caprica.vlcj.binding.LibVlcFactory.factory;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;


public class MultiThreadedWindow extends JFrame implements ActionListener {

    private JPanel topPanel = new JPanel();
    private JPanel statusPanel = new JPanel();
    private JButton playButton = new JButton("Play");private JButton btnStop = new JButton("Stop");
    private JButton btnPause = new JButton("Pause");
    private MediaPlayerFactory factory0, factory1, factory2, factory3;
    private EmbeddedMediaPlayer mediaPlayer0, mediaPlayer1, mediaPlayer2, mediaPlayer3;




    int Video_Width = 600;
    int Video_Height = 300;
    int Num_Video = 2;

    public MultiThreadedWindow() {
        final String jnaLibraryPath = System.getProperty("jna.library.path");
        final StringBuilder newJnaLibraryPath = new StringBuilder(jnaLibraryPath != null ? (jnaLibraryPath + ":") : "");
        newJnaLibraryPath.append("lib");
        System.setProperty("jna.library.path", newJnaLibraryPath.toString());



        playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });

        btnStop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               stop();
            }
        });

        btnPause.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               pause();
            }
        });


        topPanel.add(playButton);
        topPanel.add(btnStop);
        topPanel.add(btnPause);

        this.setSize(1000, 800);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new FlowLayout());


        Canvas[] videoCanvas = new Canvas[Num_Video];
        JPanel[] vidPanel = new JPanel[Num_Video];

        for (int i = 0; i < Num_Video; i++) {
            vidPanel[i] = new JPanel();
            videoCanvas[i] = new Canvas();

            vidPanel[i].setPreferredSize(new Dimension(Video_Width, Video_Height));
            vidPanel[i].setBackground(Color.black);
            vidPanel[i].setLayout(new BorderLayout());

            videoCanvas[i].setBackground(Color.black);
            vidPanel[i].add(videoCanvas[i], BorderLayout.CENTER);

            mainPanel.add(vidPanel[i]);

        }

/*
MediaPlayerFactory factory[] = new MediaPlayerFactory[Num_Video];
EmbeddedMediaPlayer mediaPlayer[] = new EmbeddedMediaPlayer[Num_Video];
  for (int i = 0; i <Num_Video; i++) 
  {
        
      factory[i] = new MediaPlayerFactory();
mediaPlayer[i] = factory[i].newEmbeddedMediaPlayer();
mediaPlayer[i].setVideoSurface(factory[i].newVideoSurface(videoCanvas[i]));
mediaPlayer[i].setPlaySubItems(true);
  mediaPlayer[i].addMediaPlayerEventListener(new MediaPlayerEventAdapter() {

            @Override
            public void mediaSubItemAdded(MediaPlayer mediaPlayer, libvlc_media_t subItem) {
                List<String> items = mediaPlayer.subItems();
                System.out.println(items);
            }
        });

  }
        */

       factory0 = new MediaPlayerFactory();
        mediaPlayer0 = factory0.newEmbeddedMediaPlayer();
        mediaPlayer0.setVideoSurface(factory0.newVideoSurface(videoCanvas[0]));
        mediaPlayer0.setPlaySubItems(true);
        mediaPlayer0.addMediaPlayerEventListener(new MediaPlayerEventAdapter() {

            @Override
            public void mediaSubItemAdded(MediaPlayer mediaPlayer, libvlc_media_t subItem) {
                List<String> items = mediaPlayer.subItems();
                System.out.println(items);
            }
        });

        factory1 = new MediaPlayerFactory();
        mediaPlayer1 = factory1.newEmbeddedMediaPlayer();
        mediaPlayer1.setVideoSurface(factory1.newVideoSurface(videoCanvas[1]));
        mediaPlayer1.setPlaySubItems(true);
        mediaPlayer1.addMediaPlayerEventListener(new MediaPlayerEventAdapter() {

            @Override
            public void mediaSubItemAdded(MediaPlayer mediaPlayer, libvlc_media_t subItem) {
                List<String> items = mediaPlayer.subItems();
                System.out.println(items);
            }
        });
/*
        factory2 = new MediaPlayerFactory();
        mediaPlayer2 = factory2.newEmbeddedMediaPlayer();
        mediaPlayer2.setVideoSurface(factory2.newVideoSurface(videoCanvas[2]));
        mediaPlayer2.setPlaySubItems(true);
        mediaPlayer2.addMediaPlayerEventListener(new MediaPlayerEventAdapter() {

            @Override
            public void mediaSubItemAdded(MediaPlayer mediaPlayer, libvlc_media_t subItem) {
                List<String> items = mediaPlayer.subItems();
                System.out.println(items);
            }
        });

       factory3 = new MediaPlayerFactory();
        mediaPlayer3 = factory3.newEmbeddedMediaPlayer();
        mediaPlayer3.setVideoSurface(factory3.newVideoSurface(videoCanvas[3]));
        mediaPlayer3.setPlaySubItems(true);
        mediaPlayer3.addMediaPlayerEventListener(new MediaPlayerEventAdapter() {

            @Override
            public void mediaSubItemAdded(MediaPlayer mediaPlayer, libvlc_media_t subItem) {
                List<String> items = mediaPlayer.subItems();
                System.out.println(items);
            }
        });
        */
       
        this.add(topPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(statusPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) throws IllegalStateException {

        if (e.getActionCommand().equals("OK")) {
            this.dispose();
        }
    }

    private void start() {
        this.setVisible(true);
    }
public void setStandardMediaoption(string mediaoption[]){


}
    private void play() {
       
        mediaPlayer0.playMedia("F:\\1.mp4");
        mediaPlayer1.playMedia("F:\\hd.mp4");
        mediaPlayer2.playMedia("adj.mkv");
        mediaPlayer3.playMedia("F:\\hd.mp4");
    }

    private void stop() {
        mediaPlayer0.stop();
        mediaPlayer1.stop();
        mediaPlayer2.stop();
        mediaPlayer3.stop();
    }

    private void pause() {
        mediaPlayer0.pause();
        mediaPlayer1.pause();
        mediaPlayer2.pause();
        mediaPlayer3.pause();
    }

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MultiThreadedWindow().start();
            }
        });
    }}

  //  @Override
   // public void actionPerformed(ActionEvent e) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
//}