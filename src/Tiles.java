import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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

    public void setRowNr(int rowNr) {
        this.rowNr = rowNr;
    }

    public void setColumnNr(int columnNr) {
        this.columnNr = columnNr;
    }
}
