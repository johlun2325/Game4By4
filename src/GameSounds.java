import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class GameSounds {
    public GameSounds() {
    }

    public void playVictorySound() {
        try {
            URL url = GameSounds.class.getResource("winsound.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip victoryClip = AudioSystem.getClip();
            victoryClip.open(audioInputStream);
            victoryClip.start();


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void playTileSound() {
        try {
            URL url = GameSounds.class.getResource("tileMoveSound.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip victoryClip = AudioSystem.getClip();
            victoryClip.open(audioInputStream);
            victoryClip.start();


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
