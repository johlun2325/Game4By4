import javax.swing.*;
import java.awt.*;


/*TO-DO//
* Panel för hela spelytan, Border Layout nord center syd.*
* Panel för north del - för Spelnamn-label *
* Panel för center del, (spelytan med knappar) - grid *
* Panel för south del - (new game knapp och label med rubrik) - grid
* Skapa knappar 1-15 samt new game *
* Skapa label "Rubrik på spel" *
* initiera element med layouts och text.*
*
* setSize
* setResizable = false
* ram?
* set action listeners på knappar
* ny klass för hantering av actionPerformed
*  */



public class GameLayout extends JFrame {

    JPanel gamePanel; // som grund för hela spelytan
    JPanel namePanel; // för rubrik
    JPanel buttonPanel; // att placera alla knappar på
    JPanel newGamePanel; // för new game knapp
    JLabel gameName;

    JButton btn1 = new JButton("1"); JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3"); JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5"); JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7"); JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9"); JButton btn10 = new JButton("10");
    JButton btn11 = new JButton("11"); JButton btn12 = new JButton("12");
    JButton btn13 = new JButton("13"); JButton btn14 = new JButton("14");
    JButton btn15 = new JButton("15");
    JButton btnEmpty = new JButton();
    JButton newGameBtn = new JButton("New Game");

    public GameLayout(){
        gameName = new JLabel("Game4By4");
        namePanel = new JPanel(new BorderLayout());
        buttonPanel = new JPanel(new GridLayout(4,4));
        newGamePanel = new JPanel(new GridLayout(1,2));
        gamePanel = new JPanel(new BorderLayout());


        namePanel.add(gameName);
        newGamePanel.add(newGameBtn);
        buttonPanel.add(btn1); buttonPanel.add(btn2); buttonPanel.add(btn3);
        buttonPanel.add(btn4); buttonPanel.add(btn5); buttonPanel.add(btn6);
        buttonPanel.add(btn7); buttonPanel.add(btn8); buttonPanel.add(btn9);
        buttonPanel.add(btn10); buttonPanel.add(btn11); buttonPanel.add(btn12);
        buttonPanel.add(btn13); buttonPanel.add(btn14); buttonPanel.add(btn15);


        buttonPanel.add(btnEmpty); //highest z-value of all buttons, added last, int clickedButtonIndex = getComponentZOrder(button)

        gamePanel.add(namePanel, BorderLayout.NORTH);
        gamePanel.add(buttonPanel, BorderLayout.CENTER);
        gamePanel.add(newGamePanel, BorderLayout.SOUTH);

        this.add(gamePanel);

//        setFocusable(false);
        setTitle("Game4By4");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }


}