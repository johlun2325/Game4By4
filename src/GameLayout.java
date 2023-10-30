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

    private int nrOfRows = 4;
    private int nrOfColumns = 4;
    private int buttonWidthAndHeight = 70;

    JPanel gamePanel; // som grund för hela spelytan
    JPanel namePanel; // för rubrik
    JPanel cardPanel;
    JPanel buttonPanel; // att placera alla knappar på
    JPanel victoryPanel;
    JLabel gameNameLabel;
    JButton newGameBtn = new JButton("New Game");
    JButton cheatButton = new JButton("Cheat");
    JLabel victoryLabel;
    CardLayout cardLayout;

    public GameLayout() {

        for (int i = 1; i < nrOfRows * nrOfColumns; i++) {
            listInCorrectOrder.add(String.valueOf(i));
        }
        listInCorrectOrder.add("");

        cardLayout = new CardLayout();
        gameNameLabel = new JLabel("Game4By4");
        victoryLabel = new JLabel("Victory!");
        cardPanel = new JPanel(cardLayout);
        victoryPanel = new JPanel(new BorderLayout());
        namePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(nrOfRows, nrOfColumns));
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setSize(buttonWidthAndHeight * nrOfRows, buttonWidthAndHeight * nrOfColumns);


        newGameBtn.addActionListener(l -> {
            buttonPanel.removeAll();
            addButtonsToBoard(false);
            cardLayout.show(cardPanel, "buttons");
            repaint();
            revalidate();
        });

        cheatButton.addActionListener(l -> {
            buttonPanel.removeAll();
            addButtonsToBoard(true);
            repaint();
            revalidate();
        });

        addButtonsToBoard(false);

        cardPanel.add("victory", victoryPanel);
        cardPanel.add("buttons", buttonPanel);

        victoryPanel.add(victoryLabel, BorderLayout.CENTER);

        namePanel.add(gameNameLabel, BorderLayout.CENTER);
        namePanel.add(newGameBtn, BorderLayout.WEST);
        namePanel.add(cheatButton, BorderLayout.EAST);

        gamePanel.add(namePanel, BorderLayout.NORTH);
        gamePanel.add(cardPanel, BorderLayout.CENTER);

        cardLayout.show(cardPanel, "buttons");
        this.add(gamePanel);

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

        listOfShuffledTiles = tg.createListOfTiles(listToBeShuffled, nrOfRows, nrOfColumns, cheat);

        for (Tiles tiles : listOfShuffledTiles) {
            tiles.addActionListener(this);
            buttonPanel.add(tiles);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Tiles clickedTile = (Tiles) e.getSource();
        for (Tiles tile : this.listOfShuffledTiles) {

            if (!tile.getText().isEmpty()) {
                continue;
            }

            if (isAdjacent(clickedTile, tile)) {
                String temp = clickedTile.getText();
                clickedTile.setText(tile.getText());
                tile.setText(temp);
            }
        }
        checkForVictory();
    }

    public boolean isAdjacent(Tiles clickedTile, Tiles emptyTile) {
        int rowDiff = Math.abs(clickedTile.getRowNr() - emptyTile.getRowNr());
        int columnDiff = Math.abs(clickedTile.getColumnNr() - emptyTile.getColumnNr());

        return (rowDiff == 1 && columnDiff == 0)
                || (columnDiff == 1 && rowDiff == 0);
    }

    public void checkForVictory() {

        List<String> currentList = new ArrayList<>();
        for (Tiles tile : this.listOfShuffledTiles) {

            currentList.add(tile.getText());
        }

        if (currentList.equals(listInCorrectOrder)) {

            cardLayout.show(cardPanel, "victory");
            repaint();
            revalidate();

        }

    }
}

