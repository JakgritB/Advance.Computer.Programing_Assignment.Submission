package boottapak.jakgrit.lab9;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/*  This program is DiceGameWindow that extends JFrame. 
 *  
 *  the title is "DiceGameWindow Version 1"
 *  this program creating a window has components:
 *  - Random number drawing dice
 * 
 *  Dice is create by Class DiceImageCanvas
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class DiceGameWindow extends JFrame {
    protected DiceImageCanvas diceImageCanvas;
    protected int diceRoll;
    protected JPanel buttonsPanel;
    protected JButton rollButton, highButton, lowButton;

    public DiceGameWindow(String title) {
        super(title);
        Random rand = new Random();
        diceRoll = rand.nextInt(6) + 1; // random number 1-6
        diceImageCanvas = new DiceImageCanvas(diceRoll); // draw dice
    }

    public void setFrameFeatures() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void addComponents() {
        buttonsPanel = new JPanel(new FlowLayout());
        rollButton = new JButton("Roll");
        highButton = new JButton("High");
        lowButton = new JButton("Low");
        buttonsPanel.add(highButton);
        buttonsPanel.add(lowButton);
        buttonsPanel.add(rollButton);

        this.setLayout(new BorderLayout());
        this.add(buttonsPanel, BorderLayout.NORTH);
        this.add(diceImageCanvas, BorderLayout.CENTER);
    }

    public static void createAndShowGUI() {
        DiceGameWindow dgw = new DiceGameWindow("DiceGameWindow Version 1");
        dgw.addComponents();
        dgw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
