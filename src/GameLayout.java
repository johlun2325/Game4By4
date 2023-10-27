import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameLayout extends JFrame {
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

    JButton btnEmpty = new JButton(); //"" eller ingenting?
    JButton newGameBtn = new JButton("New Game");

    public GameLayout(){



        gameNameLabel = new JLabel("Game4By4");
        namePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(rows, columns));
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setSize(buttonWidthAndHeight*rows,buttonWidthAndHeight*columns);
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

        gamePanel.add(namePanel, BorderLayout.NORTH);
        gamePanel.add(buttonPanel, BorderLayout.CENTER);

        this.add(gamePanel);

//        setFocusable(false);
        setTitle("Game4By4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public void addButtonsToBoard(){
        listInCorrectOrder.clear();
        listOfShuffledTiles.clear();
        for (int i = 1; i <rows*columns ; i++) {
            listInCorrectOrder.add(String.valueOf(i));
        }

        listOfShuffledTiles = tg.createListOfTiles(listInCorrectOrder, rows, columns);

        for(Tiles tiles: listOfShuffledTiles) {
            buttonPanel.add(tiles);
        }
    }
}