import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TileGenerator {

    public TileGenerator() {
    }

    public List<Tiles> createListOfTiles (List<String> listOfTileNames, int rows, int columns) {
        ButtonAction ba = new ButtonAction();
        List<Tiles> listToReturn = new ArrayList<>();
        Collections.shuffle(listOfTileNames);
        int counter = 0;
        for (int c = 1; c <=columns ; c++) {
            for (int r = 1; r <=rows ; r++) {
                Tiles tile = new Tiles((listOfTileNames.get(counter)), r, c);
                tile.setSize(70,70);
                tile.addActionListener(ba);
                listToReturn.add(tile);
                counter++;
            }
        }
        return listToReturn;
    }
}
