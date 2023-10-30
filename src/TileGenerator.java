import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.awt.Font.BOLD;

public class TileGenerator {

    public TileGenerator() {
    }

    public List<Tiles> createListOfTiles (List<String> listOfTileNames, int rows, int columns, boolean cheat) {
        List<Tiles> listToReturn = new ArrayList<>();
        if (!cheat) {
            Collections.shuffle(listOfTileNames);
        }
        listOfTileNames.add("");
        int counter = 0;
        for (int c = 1; c <=columns ; c++) {
            for (int r = 1; r <=rows ; r++) {
                Font buttonFont = new Font("Arial",BOLD,26);
                Tiles tile = new Tiles((listOfTileNames.get(counter)), r, c);
                tile.setFont(buttonFont);
                tile.setBorder(new LineBorder(Color.gray));
                tile.setMargin(new Insets(0,0,0,0));
                tile.setPreferredSize(new Dimension(100,100));
                listToReturn.add(tile);
                counter++;
            }
        }
        return listToReturn;
    }
}
