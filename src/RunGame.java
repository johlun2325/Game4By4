import java.awt.font.GlyphMetrics;
import java.util.ArrayList;
import java.util.List;

public class RunGame {
    List<String> listInCorrectOrder = new ArrayList<>();

    RunGame(){
        GameLogic logic = new GameLogic();
        GameLayout g = new GameLayout();

        g.initializeListWithCorrectValues();
        logic.addButtonsToBoard(g, g.getNrOfRows(), g.getNrOfColumns(), false);




    }


}
