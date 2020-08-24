/**
 * AudioOS
 */
import java.io.*;
import javax.sound.sampled.*;

public class AudioOS {
    Clip clip;
    public synchronized void play(final InputStream in) throws Exception {
        AudioInputStream ais = AudioSystem.getAudioInputStream(in);
        try{
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            // Thread.sleep(100);
            // clip.drain();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stop() {
        clip.close();
    }
}