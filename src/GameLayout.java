import javax.swing.*;
import java.awt.*;

public class GameLayout extends JFrame {

    JPanel gameArea;
    JButton newGame;


    public GameLayout(){
        newGame = new JButton("New Game");
        gameArea = new JPanel(new GridLayout(4,4));
        this.add(gameArea);
        gameArea.add(newGame);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }


}