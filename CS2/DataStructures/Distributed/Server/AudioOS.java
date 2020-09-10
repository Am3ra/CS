import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * AudioOS
 */
public class AudioOS {
    private File fileSong;
    private AudioInputStream audioStream;
    private Clip clip;

    public void reproducir(String cancion) throws Exception {
        //Rekacionar nombre con archivo wav
        
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
    public void stop() {
        clip.stop();
    }
}