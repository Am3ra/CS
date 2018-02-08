import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

/**
 * Audio
 */
public class Audio2 extends JFrame{
    /*
    Clase creadora delaudio
     */
    private File fileSong;
    private AudioInputStream audioStream;
    private Clip clip;

    public void Audio2(String cancion) {
        super("audio TEC");
        reproducir(cancion);
        setSize(400,300);
        setVisible(true);
    }
    
    private void reproducir(String cancion) throws Exception{
        //Obtener nomber
        cancion = "Lazarus.wav";
        //Rekacionar nombre con archivo wav
        fileSong = new File(cancion);
        //Preparar audio stream
        audioStream = AudioSystem.getAudioInputStream(fileSong);
        //reproducir audio
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        
       
    }

    public static void main(String[] args) throws Exception {
        Audio2 audio = new Audio2();
        audio.reproducir("cancion");
    }
}