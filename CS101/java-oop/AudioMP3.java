import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



/**
 * Audio
 */
public class AudioMP3{

    
    /*
    Clase creadora delaudio
     */
    final JFXPanel fxPanel = new JFXPanel(); 
    private void reproducir(String cancion){
        Media med = new Media(getClass().getResource(cancion).toExternalForm());
        MediaPlayer mPlayer = new MediaPlayer(med);
        while (true) {
            mPlayer.play();
        }
    }

    public static void main(String[] args) {
        AudioMP3 audio = new AudioMP3();
        audio.reproducir("Walkin.mp3");
    }
}