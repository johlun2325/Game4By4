import java.util.ArrayList;
import java.util.List;

public class TileGenerator {

    public TileGenerator() {
    }

    public List<Tiles> createListOfTiles (List<String> listOfTileNames, int rows, int columns) {
        List<Tiles> listToReturn = new ArrayList<>();
        int counter = 0;
        for (int c = 1; c <=columns ; c++) {
            for (int r = 1; r <=rows ; r++) {
                Tiles tile = new Tiles((listOfTileNames.get(counter)), r, c);
                listToReturn.add(tile);
                counter++;

            }
        }
        return listToReturn;
    }
}
