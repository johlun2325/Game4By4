import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class GameLayout extends JFrame implements ActionListener {
    TileGenerator tg = new TileGenerator();
    GameLogic gl = new GameLogic();
    List<String> listInCorrectOrder = new ArrayList<>();
    List<Tiles> listOfShuffledTiles = new ArrayList<>();

    private final int nrOfRows = 4;
    private final int nrOfColumns = 4;
    private final int buttonWidthAndHeight = 150;

    public int getNrOfRows() {
        return nrOfRows;
    }
    public int getNrOfColumns() {
        return nrOfColumns;
    }

    JPanel gamePanel; JPanel namePanel; JPanel cardPanel;
    JPanel buttonPanel; JPanel victoryPanel;
    JLabel gameNameLabel; JLabel victoryLabel;
    JButton newGameBtn; JButton cheatButton;

    CardLayout cardLayout;

    public GameLayout() {
        GameLogic logic = new GameLogic();

        initializeListWithCorrectValues();
//        for (int i = 1; i < nrOfRows * nrOfColumns; i++) {
//            listInCorrectOrder.add(String.valueOf(i));
//        }
//        listInCorrectOrder.add("");


        //initialize elements
        cardLayout = new CardLayout();

        gameNameLabel = new JLabel("Game4By4");
        victoryLabel = new JLabel("Victory!");

        cardPanel = new JPanel(cardLayout);
        victoryPanel = new JPanel(new BorderLayout());
        namePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(nrOfRows, nrOfColumns));
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setSize(buttonWidthAndHeight * nrOfRows, buttonWidthAndHeight * nrOfColumns);


        //initialize new game button and it's actionPerformed method
        newGameBtn = new JButton("New Game");
        newGameBtn.addActionListener(l -> {
            buttonPanel.removeAll();
            logic.addButtonsToBoard(this, this.nrOfRows, this.nrOfColumns, false);
            cardLayout.show(cardPanel, "buttons");
            repaint();
            revalidate();
        });

        //initialize cheat button and it's actionPerformed method

        cheatButton = new JButton("Cheat");
        cheatButton.addActionListener(l -> {
            buttonPanel.removeAll();
            logic.addButtonsToBoard(this, this.getNrOfRows(), this.nrOfColumns, true);
            repaint();
            revalidate();
        });

        //adding buttons to board for first game
        logic.addButtonsToBoard(this, this.getNrOfRows(), this.getNrOfColumns(), false);


        //adding elements to each other
        cardPanel.add("victory", victoryPanel);
        cardPanel.add("buttons", buttonPanel);

        victoryPanel.add(victoryLabel, BorderLayout.CENTER);

        namePanel.add(gameNameLabel, BorderLayout.CENTER);
        namePanel.add(newGameBtn, BorderLayout.WEST);
        namePanel.add(cheatButton, BorderLayout.EAST);

        gamePanel.add(namePanel, BorderLayout.NORTH);
        gamePanel.add(cardPanel, BorderLayout.CENTER);

        //setting what cardLayout to show at the beginning
        cardLayout.show(cardPanel, "buttons");

        //standard settings and adding gamePanel to frame
        this.add(gamePanel);
        setTitle("Game4By4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

//    public void addButtonsToBoard(boolean cheat) {
//        List<String> listToBeShuffled = new ArrayList<>();
//        listOfShuffledTiles.clear();
//
//        for (int i = 1; i < nrOfRows * nrOfColumns; i++) {
//            listToBeShuffled.add(String.valueOf(i));
//        }
//
//        listOfShuffledTiles = tg.createListOfTiles(listToBeShuffled, nrOfRows, nrOfColumns, cheat);
//
//        for (Tiles tiles : listOfShuffledTiles) {
//            tiles.addActionListener(this);
//            buttonPanel.add(tiles);
//        }
//    }


    //actionPerformed method for game buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        GameLogic logic = new GameLogic(); //instans av gamelogic
        Tiles clickedTile = (Tiles) e.getSource();
        for (Tiles tile : this.listOfShuffledTiles) {

            if (!tile.getText().isEmpty()) {
                continue;
            }

            if (logic.isAdjacent(clickedTile, tile)) { //kallar på metod via gamelogic
                String temp = clickedTile.getText();
                clickedTile.setText(tile.getText());
                tile.setText(temp);
            }
        }
        logic.checkForVictory(this); //change to rungame later, argument gamelayout
    }


    //method to initialize the list that contains the correct values
    public void initializeListWithCorrectValues(){
        for (int i = 1; i < nrOfRows * nrOfColumns; i++) {
            listInCorrectOrder.add(String.valueOf(i));
        }
        listInCorrectOrder.add("");
    }

//    public boolean isAdjacent(Tiles clickedTile, Tiles emptyTile) {
//        int rowDiff = Math.abs(clickedTile.getRowNr() - emptyTile.getRowNr());
//        int columnDiff = Math.abs(clickedTile.getColumnNr() - emptyTile.getColumnNr());
//
//        return (rowDiff == 1 && columnDiff == 0)
//                || (columnDiff == 1 && rowDiff == 0);
//    }

//    public void checkForVictory() {
//
//        List<String> currentList = new ArrayList<>();
//        for (Tiles tile : this.listOfShuffledTiles) {
//
//            currentList.add(tile.getText());
//        }
//
//        if (currentList.equals(listInCorrectOrder)) {
//
//            cardLayout.show(cardPanel, "victory");
//            repaint();
//            revalidate();
//
//        }
//
//    }
}

