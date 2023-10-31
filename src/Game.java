import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame implements ActionListener {
    TileGenerator tileGenerator;
    GameLogic logic;
    GameSounds gameSounds;

    protected List<String> listInCorrectOrder;
    protected List<Tiles> listOfShuffledTiles;

    private final int nrOfRows = 4;
    private final int nrOfColumns = 4;


    public int getNrOfRows() {
        return nrOfRows;
    }

    public int getNrOfColumns() {
        return nrOfColumns;
    }

    JPanel gamePanel; JPanel namePanel;
    JPanel cardPanel; JPanel buttonPanel;
    JPanel victoryPanel;

    JLabel victoryLabel;

    JButton newGameButton; JButton cheatButton;

    CardLayout cardLayout;

    public Game() {
        setTitle("Game of 15");
        this.initializeComponents();
        logic.initializeListWithNumbersInCorrectOrder(this);

        logic.addTilesToBoard(this, getNrOfRows(), getNrOfColumns(), false);

        newGameButton.addActionListener(l -> startNewGame(false));
        cheatButton.addActionListener(l -> startNewGame(true));

        this.addComponents();
        this.setUp();
    }

    private void setUp(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }

    private void initializeComponents() {

        listOfShuffledTiles = new ArrayList<>();
        listInCorrectOrder = new ArrayList<>();
        gameSounds = new GameSounds();
        logic = new GameLogic();
        tileGenerator = new TileGenerator();

        cheatButton = new JButton("Cheat");
        cheatButton.setPreferredSize(new Dimension(100,50));
        cheatButton.setFocusable(false);

        newGameButton = new JButton("New Game");
        newGameButton.setPreferredSize(new Dimension(100,50));
        newGameButton.setFocusable(false);

        cardLayout = new CardLayout();

        victoryLabel = new JLabel("Victory!");
        Font victoryFont = new Font("Helvetica", Font.ITALIC,108);
        victoryLabel.setFont(victoryFont);
        victoryLabel.setForeground(new Color(255, 215, 0));

        cardPanel = new JPanel(cardLayout);
        victoryPanel = new JPanel(new BorderLayout());
        namePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(nrOfRows, nrOfColumns));
        gamePanel = new JPanel(new BorderLayout());
    }

    private void addComponents() {
        cardPanel.add("victory", victoryPanel);
        cardPanel.add("buttons", buttonPanel);

        victoryPanel.add(victoryLabel);

        namePanel.add(newGameButton, BorderLayout.WEST);
        namePanel.add(cheatButton, BorderLayout.EAST);

        gamePanel.add(namePanel, BorderLayout.NORTH);
        gamePanel.add(cardPanel, BorderLayout.CENTER);

        cardLayout.show(cardPanel, "buttons");
        this.add(gamePanel);
    }

    private void startNewGame(boolean cheat) {
        buttonPanel.removeAll();
        logic.addTilesToBoard(this, this.nrOfRows, this.nrOfColumns,cheat);
        cardLayout.show(cardPanel, "buttons");
        repaint();
        revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Tiles clickedTile = (Tiles) e.getSource();
        for (Tiles tile : this.listOfShuffledTiles) {

            if (!tile.getText().isEmpty()) {
                continue;
            }

            if (logic.isAdjacent(clickedTile, tile)) {
                String temp = clickedTile.getText();
                clickedTile.setText(tile.getText());
                tile.setText(temp);
                gameSounds.playTileSound();

            }
        }
        logic.checkForVictory(this);
    }

}

