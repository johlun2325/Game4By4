import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class Game extends JFrame implements ActionListener {
    TileGenerator tg = new TileGenerator();
    GameLogic logic = new GameLogic();

    protected List<String> listInCorrectOrder = new ArrayList<>();
    protected List<Tiles> listOfShuffledTiles = new ArrayList<>();

    private final int nrOfRows = 4;
    private final int nrOfColumns = 4;
    private final int buttonWidthAndHeight = 150;

    public int getNrOfRows() {
        return nrOfRows;
    }

    public int getNrOfColumns() {
        return nrOfColumns;
    }

    JPanel gamePanel; JPanel namePanel;
    JPanel cardPanel; JPanel buttonPanel;
    JPanel victoryPanel;

    JLabel gameNameLabel; JLabel victoryLabel;

    JButton newGameBtn; JButton cheatButton;

    CardLayout cardLayout;


    public Game() {
        setTitle("Game4By4");
        logic.initializeListWithCorrectValues(this);

        this.initializeComponents();

        logic.addButtonsToBoard(this, getNrOfRows(), getNrOfColumns(), false);

        newGameBtn = new JButton("New Game");
        newGameBtn.addActionListener(l -> {
            buttonPanel.removeAll();
            logic.addButtonsToBoard(this, this.nrOfRows, this.nrOfColumns, false);
            cardLayout.show(cardPanel, "buttons");
            repaint();
            revalidate();
        });

        cheatButton = new JButton("Cheat");
        cheatButton.addActionListener(l -> {
            buttonPanel.removeAll();
            logic.addButtonsToBoard(this, this.getNrOfRows(), this.nrOfColumns, true);
            repaint();
            revalidate();
        });


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addComponents();
        this.add(gamePanel);
        this.setVisible(true);
        this.pack();
    }

    private void initializeComponents() {
        cardLayout = new CardLayout();

        gameNameLabel = new JLabel("Game4By4");
        victoryLabel = new JLabel("Victory!");

        cardPanel = new JPanel(cardLayout);
        victoryPanel = new JPanel(new BorderLayout());
        namePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(nrOfRows, nrOfColumns));
        gamePanel = new JPanel(new BorderLayout());
        gamePanel.setSize(buttonWidthAndHeight * nrOfRows, buttonWidthAndHeight * nrOfColumns);

    }

    private void addComponents() {
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
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


}

