import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

/**
 * Audio
 */
public class Audio2 extends JFrame implements ActionListener{
    /*
    Clase creadora delaudio
     */
    private File fileSong;
    private AudioInputStream audioStream;
    private Clip clip;
    private JButton bStart, bStop;
    private JPanel panel1,panel2;
    private JLabel label1,label2;
    private JTextField tf1;


    public Audio2() {
        super("audio TEC");
        bStart = new JButton("Start");
        bStop= new JButton("stop");
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 =  new JLabel("Song:");
        label2 =  new JLabel("Now Playing: ");
        tf1 = new JTextField();

        bStart.addActionListener(this);
        bStop.addActionListener(this);
        panel1.setLayout(new GridLayout(3,2));
        panel2.setLayout(new FlowLayout());
        panel1.add(label1);
        panel1.add(tf1);
        panel1.add(bStart);
        panel1.add(bStop);
        panel1.add(label2);

        panel2.add(panel1);
        add(panel2);
        setSize(400,300);
        // setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource()==bStart) {
            try {
                reproducir(tf1.getText()+".wav");
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }
        if (event.getSource()==bStop) {
            // System.out.println("ok");
            clip.stop();
        }
    }
    public JPanel getPanel2() {
        return panel2;
    }
    
    private void reproducir(String cancion) throws Exception {
        //Rekacionar nombre con archivo wav
        label2.setText("Now Playing: "+cancion);
        fileSong = new File(cancion);
        //Preparar audio stream
        audioStream = AudioSystem.getAudioInputStream(fileSong);
        //reproducir audio
        clip = AudioSystem.getClip();
            if (clip.isRunning()) {
                clip.stop();
            }
        clip.open(audioStream);
        clip.start();
        
    }
    public static void main(String[] args) throws Exception {
        Audio2 audio = new Audio2();
    }
}