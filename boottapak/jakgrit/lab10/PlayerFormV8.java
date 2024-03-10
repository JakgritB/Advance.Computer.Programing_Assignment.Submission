package boottapak.jakgrit.lab10;

/*  This program is PlayerFormV8 that extends PlayerFormV7 implements ListSelectionListener. 
 *  
 *  The title is "Player Form V8"
 *  this program has component similar to PlayerFormV7
 *  but has add ListSelectionListener
 * 
 *  - When the user clicks on a sport list, 
 *  it will show the message 
 *      - only one sport selected >>> "Selected sport is <sport selected>" <<<
 *      - many sport selected >>> "Selected sport is <sport selected> <sport selected> ..... " <<<
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

import java.util.List;
import javax.swing.*;
import javax.swing.event.*;

import boottapak.jakgrit.lab9.PlayerFormV7;

public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {
    StringBuffer sportOutput = new StringBuffer(); // i think it look like array

    protected PlayerFormV8(String title) {
        super(title);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) { // This is List Listener
        sportOutput.setLength(0); // set Output array length to 0 everytime list change
        List<String> selectedSport = sportList.getSelectedValuesList(); // get what user select from sportlist
        boolean isAdjusting = e.getValueIsAdjusting(); // boolean check for "is user selected finish?"
        int numSelected = selectedSport.size();
        for (int i = 0; i < numSelected; i++) {
            sportOutput.append(selectedSport.get(i) + " ");
        }
        // isAdjusting = The user is selecting not finish (program not show tick yet)
        if (!isAdjusting) { // when user finish
            if (numSelected == 1) {
                JOptionPane.showMessageDialog(this, "Selected sport is " + sportOutput);
                // when user click only one list
            } else if (numSelected > 1){
                JOptionPane.showMessageDialog(this, "Selected sports are " + sportOutput);
                // when user click many lists
            }
        }
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        sportList.addListSelectionListener(this); // add list listener to sportlist (not action listener!!)
    }

    public static void createAndShowGUI() {
        PlayerFormV8 msw = new PlayerFormV8("Player Form V8");
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
