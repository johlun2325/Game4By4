import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class GameLayout extends JFrame implements ActionListener {
    TileGenerator tg = new TileGenerator();
    List<String> listInCorrectOrder = new ArrayList<>();
    List<Tiles> listOfShuffledTiles = new ArrayList<>();

    private int rows = 4;
    private int columns = 4;
    private int buttonWidthAndHeight = 70;

    JPanel gamePanel; // som grund för hela spelytan
    JPanel namePanel; // för rubrik
    JPanel buttonPanel; // att placera alla knappar på
    JLabel gameNameLabel;

    JButton newGameBtn = new JButton("New Game");
    JButton cheatButton = new JButton("Cheat");

    public GameLayout() {

        for (int i = 1; i < nrOfRows * nrOfColumns; i++) {
            listInCorrectOrder.add(String.valueOf(i));
        }
        listInCorrectOrder.add("");

        gameNameLabel = new JLabel("Game4By4");
        namePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(rows, columns));
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setSize(buttonWidthAndHeight * nrOfRows, buttonWidthAndHeight * nrOfColumns);
        gameNameLabel = new JLabel("Rubrik");

        newGameBtn.addActionListener(l -> {
            buttonPanel.removeAll();
            addButtonsToBoard();
            repaint();
            revalidate();
        });

        addButtonsToBoard();

        namePanel.add(gameNameLabel, BorderLayout.CENTER);
        namePanel.add(newGameBtn, BorderLayout.WEST);
        namePanel.add(cheatButton, BorderLayout.EAST);

        gamePanel.add(namePanel, BorderLayout.NORTH);
        gamePanel.add(buttonPanel, BorderLayout.CENTER);

        this.add(gamePanel);

//        setFocusable(false);
        setTitle("Game4By4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public void addButtonsToBoard(boolean cheat) {
        List<String> listToBeShuffled = new ArrayList<>();
        listOfShuffledTiles.clear();

        for (int i = 1; i < nrOfRows * nrOfColumns; i++) {
            listToBeShuffled.add(String.valueOf(i));
        }

        listOfShuffledTiles = tg.createListOfTiles(listInCorrectOrder, rows, columns);

        for(Tiles tiles: listOfShuffledTiles) {
            buttonPanel.add(tiles);
        }
    }
}