import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * AudioOS
 */
public class AudioOSMP3 {
    /*
    Clase creadora delaudio
     */
    MediaPlayer mPlayer;
    final JFXPanel fxPanel = new JFXPanel();

    public void reproducir(String cancion) {
        Media med = new Media(getClass().getResource(cancion).toExternalForm());
        mPlayer = new MediaPlayer(med);
        if (mPlayer.getStatus().toString()=="PLAYING"){
            mPlayer.stop();
        }
        mPlayer.play();
    }

    public void stop() {
        mPlayer.stop();
    }
}