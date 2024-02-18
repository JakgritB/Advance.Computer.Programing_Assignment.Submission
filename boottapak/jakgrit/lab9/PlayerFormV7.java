package boottapak.jakgrit.lab9;

import javax.swing.*;
import java.awt.event.*;

/*  This program is PlayerFormV7 that extends PlayerFormV6. 
 *  
 *  the title is "Player Form V7"
 *  this program has component similar to PlayerFormV6
 *  but has add ItemListener
 * 
 *  - When the user clicks at a Gender Radio button, 
 *  it will show the message >>> "Gender is updated to <selected gender>" <<<
 * 
 *  - When the user selects a Hobbies Checkbox, 
 *  the program displays the dialog >>> "<hobby> is one of the hobbies" <<<
 * 
 *  - When the user deselects a Hobbies checkbox, 
 *  the program displays the dialog >>> "<hobby> is no longer one of the hobbies" <<<
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV7 extends PlayerFormV6 implements ItemListener {

    protected PlayerFormV7(String title) {
        super(title);
    }

    @Override
    public void itemStateChanged(ItemEvent e) { // item state change for gender button, checkBox
        Object srcObj = e.getSource(); // this is get what user clicked on
        if (srcObj == maleButton && e.getStateChange() == ItemEvent.SELECTED) { // if user click on "Male"
            handleGnderButton((JRadioButton) srcObj);
        } else if (srcObj == femaleButton && e.getStateChange() == ItemEvent.SELECTED) { // if user click on "Female"
            handleGnderButton((JRadioButton) srcObj);
        } else if (srcObj == readCheckBox || srcObj == browsCheckBox || // if user select on eachcheckbox
                srcObj == sleepCheckBox || srcObj == travelCheckBox) {
            handleHobbiesCheckbox((JCheckBox) srcObj);
        }
    }

    protected void handleGnderButton(JRadioButton src) { // when user select on Gender
        JOptionPane.showMessageDialog(this, "Gender is updated to " + src.getName());
    }

    protected void handleHobbiesCheckbox(JCheckBox src) { // when user select on checkbox
        SwingUtilities.invokeLater(new Runnable() { // You NEED to write in this way because Thread Safe, !!!
            public void run() {                     // If you don't do this it will not show Tick in checkbox !!!,
                if (src.isSelected()) {
                    JOptionPane.showMessageDialog(PlayerFormV7.this, src.getName() + " is one of the hobbies"); // when user Selected
                } else {
                    JOptionPane.showMessageDialog(PlayerFormV7.this,
                            src.getName() + " is no longer one of the hobbies"); // when user Deselected
                }
            }
        });
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        maleButton.setName("Male");
        femaleButton.setName("Female");
        readCheckBox.setName("Reading");
        browsCheckBox.setName("Browsing");
        sleepCheckBox.setName("Sleeping");
        travelCheckBox.setName("Traveling");
    }

    @Override
    protected void addListeners() { // don't forgot to add listener to each component !!!
        super.addListeners();
        maleButton.addItemListener(this);
        femaleButton.addItemListener(this);
        readCheckBox.addItemListener(this);
        browsCheckBox.addItemListener(this);
        sleepCheckBox.addItemListener(this);
        travelCheckBox.addItemListener(this);
    }

    public static void createAndShowGUI() {
        PlayerFormV7 msw = new PlayerFormV7("Player Form V7");
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
