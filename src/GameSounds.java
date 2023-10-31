import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class GameSounds {
    public GameSounds() {
    }

    public void playVictorySound() {
        URL url = GameSounds.class.getResource("winsound.wav");
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);) {

            Clip victoryClip = AudioSystem.getClip();
            victoryClip.open(audioInputStream);
            victoryClip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void playTileSound() {
        URL url = GameSounds.class.getResource("tileMoveSound.wav");
        try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);){

            Clip victoryClip = AudioSystem.getClip();
            victoryClip.open(audioInputStream);
            victoryClip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}
