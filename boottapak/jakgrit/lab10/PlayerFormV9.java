package boottapak.jakgrit.lab10;

/*  This program is PlayerFormV9 that extends PlayerFormV8 implements ChangeListener. 
 *  
 *  The title is "Player Form V9"
 *  this program has component similar to PlayerFormV8
 *  but has add ChangeListener
 * 
 *  - After the user slide a year of experience in this sport slider, 
 *  it will show the message >>> "<slider name> is <selected number>" <<<
 *                        ex.>>> "Year of experience is 10" <<<
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

import javax.swing.*;
import javax.swing.event.*;

public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {

    protected PlayerFormV9(String title) {
        super(title);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // This is for "slider" or something that change, also in color chooser
        JSlider src = (JSlider) e.getSource(); // get object and type cast to JSlide
        boolean isAdjusting = src.getValueIsAdjusting(); // boolean check for "is user selected finish?"

        // isAdjusting = The user is selecting not finish (program not show tick yet)
        if (!isAdjusting) {
            // when user finish selected
            int value = src.getValue(); // get number from slider
            String sourceStr = src.getName(); // get name from slider
            JOptionPane.showMessageDialog(this, sourceStr + " is " + value);
        }
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        yearInSportSlider.addChangeListener(this);
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        yearInSportSlider.setName("Year of experience in this sport");
    }

    public static void createAndShowGUI() {
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9");
        msw.addMenus();
        msw.addComponents();
        msw.addListeners();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
