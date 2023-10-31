import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    JFrame jf = new JFrame();
    GameSounds gameSounds = new GameSounds();

    public void initializeListWithNumbersInCorrectOrder(Game gameLayout) {
        gameLayout.listInCorrectOrder = generateNumberListBasedOnRowsAndColumns(gameLayout.getNrOfRows(), gameLayout.getNrOfColumns());
        gameLayout.listInCorrectOrder.add("");


    }

    public void addTilesToBoard(Game gameLayout, int nrOfRows, int nrOfColumns, boolean cheat) {
        List<String> listToBeShuffled;

        gameLayout.listOfShuffledTiles.clear();

        listToBeShuffled = generateNumberListBasedOnRowsAndColumns(nrOfRows, nrOfColumns);

        gameLayout.listOfShuffledTiles = gameLayout.tileGenerator.createListOfTiles(listToBeShuffled, nrOfRows, nrOfColumns, cheat);

        for (Tiles tiles : gameLayout.listOfShuffledTiles) {
            tiles.addActionListener(gameLayout);
            gameLayout.buttonPanel.add(tiles);
        }
    }

    public boolean isAdjacent(Tiles clickedTile, Tiles emptyTile) {
        int rowDiff = Math.abs(clickedTile.getRowNr() - emptyTile.getRowNr());
        int columnDiff = Math.abs(clickedTile.getColumnNr() - emptyTile.getColumnNr());

        return (rowDiff == 1 && columnDiff == 0)
                || (columnDiff == 1 && rowDiff == 0);
    }

    public void checkForVictory(Game gameLayout) {

        List<String> currentList = new ArrayList<>();
        for (Tiles tile : gameLayout.listOfShuffledTiles) {
            currentList.add(tile.getText());
        }

        if (currentList.equals(gameLayout.listInCorrectOrder)) {
            gameLayout.cardLayout.show(gameLayout.cardPanel, "victory");
            gameSounds.playVictorySound();
            jf.repaint();
            jf.revalidate();
        }
    }

    public List<String> generateNumberListBasedOnRowsAndColumns(int rows, int columns) {
        List<String> listToReturn = new ArrayList<>();

        for (int i = 1; i < rows * columns; i++) {
            listToReturn.add(String.valueOf(i));

        }
        return listToReturn;
    }
}
