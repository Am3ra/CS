import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
public class AudioGUIMP3 extends JFrame implements ActionListener {
    /*
    Clase creadora delaudio
     */

    private JButton bStart, bStop, bCatalogo;
    private JPanel panel1, panel2;
    private JLabel label1, label2;
    private JTextField tf1;
    private JTextArea taDatos;

    private AudioOSMP3 audioOSMP3 = new AudioOSMP3();

    public AudioGUIMP3() {
        super("audio TEC");
        bStart = new JButton("Start");
        bStop = new JButton("stop");
        bCatalogo = new JButton("Catalogo");
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel("Song:");
        label2 = new JLabel("Now Playing: ");
        tf1 = new JTextField();
        taDatos = new JTextArea(10, 30);
        taDatos.setEditable(false);

        bStart.addActionListener(this);
        bStop.addActionListener(this);
        bCatalogo.addActionListener(this);
        panel1.setLayout(new GridLayout(4, 2));
        panel2.setLayout(new FlowLayout());
        panel1.add(label1);
        panel1.add(tf1);
        panel1.add(bStart);
        panel1.add(bStop);
        panel1.add(bCatalogo);
        panel1.add(label2);

        panel2.add(panel1);
        panel2.add(new JScrollPane(taDatos));
        add(panel2);
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == bStart) {
            try {
                audioOSMP3.reproducir(tf1.getText());
                label2.setText("Now Playing: " + (tf1.getText()));
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        if (event.getSource() == bStop) {
            // System.out.println("ok");
            audioOSMP3.stop();
        }
        if (event.getSource() == bCatalogo) {
            String songs="";
            String lscmd = "ls $PWD/*.mp3";
            try {
                Process p = Runtime.getRuntime().exec(new String[] { "bash", "-c", lscmd });
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = reader.readLine();
                while (line != null) {
                    songs+= line.split("/")[7];
                    line = reader.readLine();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            taDatos.setText(songs);
        }
    }

    public static void main(String[] args) {
        AudioGUIMP3 audioGUIMP3 = new AudioGUIMP3();
    }
}