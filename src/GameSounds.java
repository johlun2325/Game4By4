import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class GameSounds {
    public GameSounds() {
    }

    public void playVictorySound() {
        try {
            URL source = GameSounds.class.getResource("src/winsound.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(source);
            Clip victoryClip = AudioSystem.getClip();
            victoryClip.open(audioInputStream);
            victoryClip.start();


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
