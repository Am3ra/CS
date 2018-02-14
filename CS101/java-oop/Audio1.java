import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Audio
 */
public class Audio1 {
    /*
    Clase creadora delaudio
     */
    private File fileSong;
    private AudioInputStream audioStream;
    private Clip clip;
    
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
        while (true) {
            clip.start();
        }
       
    }

    public static void main(String[] args) throws Exception {
        Audio1 audio = new Audio1();
        audio.reproducir("cancion");
    }
}