import javax.swing.*;
import java.awt.*;

public class Tiles extends JButton {
    private int rowNr;
    private int columnNr;

    public Tiles(String text, int rowNr, int columnNr) {
        super(text);
        this.rowNr = rowNr;
        this.columnNr = columnNr;
    }

    public int getRowNr() {
        return rowNr;
    }

    public int getColumnNr() {
        return columnNr;
    }
}
