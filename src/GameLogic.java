import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    JFrame jf = new JFrame();
    GameSounds gameSounds = new GameSounds();

    public void initializeListWithCorrectValues(Game gameLayout) {
        for (int i = 1; i < gameLayout.getNrOfRows() * gameLayout.getNrOfColumns(); i++) {
            gameLayout.listInCorrectOrder.add(String.valueOf(i));
        }
        gameLayout.listInCorrectOrder.add("");
        System.out.println("initiering komplett");
    }

    public void addButtonsToBoard(Game gameLayout, int nrOfRows, int nrOfColumns, boolean cheat) {
        List<String> listToBeShuffled = new ArrayList<>();

        gameLayout.listOfShuffledTiles.clear();

        for (int i = 1; i < nrOfRows * nrOfColumns; i++) {
            listToBeShuffled.add(String.valueOf(i));
        }
        //eller instans av tg direkt i metod? Vad är snyggast?
        gameLayout.listOfShuffledTiles = gameLayout.tg.createListOfTiles(listToBeShuffled, nrOfRows, nrOfColumns, cheat);

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
}
