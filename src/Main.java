import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // new GameLayout();
        TileGenerator tg = new TileGenerator();


        List<String> testList = new ArrayList<>();
        testList.add("1"); testList.add("2"); testList.add("3");testList.add("4");
        Collections.shuffle(testList);

        List<Tiles> lista = tg.createListOfTiles(testList, 2,2);

        for (Tiles tile: lista){
            System.out.println("name " + tile.getText());
            System.out.println(tile.getRowNr());
            System.out.println(tile.getColumnNr());
            System.out.println("---");
        }





        //New branch added - Development
    }
}