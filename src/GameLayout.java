import javax.swing.*;
import java.awt.*;


public class GameLayout extends JFrame {

    private int rows = 4;
    private int columns = 4;
    private int buttonWidthAndHeight = 70;


    JPanel gamePanel; // som grund för hela spelytan
    JPanel namePanel; // för rubrik
    JPanel buttonPanel; // att placera alla knappar på
    JLabel gameNameLabel;

    JButton btnEmpty = new JButton(); //"" eller ingenting?
    JButton newGameBtn = new JButton("New Game");

    public GameLayout(){

        gameNameLabel = new JLabel("Game4By4");
        namePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(rows, columns));
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setSize(buttonWidthAndHeight*rows,buttonWidthAndHeight*columns);
        gameNameLabel = new JLabel("Rubrik");

        namePanel.add(gameNameLabel);
        namePanel.add(newGameBtn);

        createButtons();
        buttonPanel.add(btnEmpty); //highest z-value of all buttons, added last, int clickedButtonIndex = getComponentZOrder(button)

        gamePanel.add(namePanel, BorderLayout.NORTH);
        gamePanel.add(buttonPanel, BorderLayout.CENTER);

        this.add(namePanel);
        this.add(gamePanel);

//        setFocusable(false);
        setTitle("Game4By4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    private void createButtons() {
        ButtonAction ba = new ButtonAction();
        int numCols = 4;
        int numRows = 4;
        for (int i = 1; i < numRows * numCols; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(ba);
            buttonPanel.add(button);
        }
    }


}