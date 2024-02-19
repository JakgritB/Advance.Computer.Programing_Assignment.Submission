package boottapak.jakgrit.lab10;

import java.util.List;
import javax.swing.*;
import javax.swing.event.*;

import boottapak.jakgrit.lab9.PlayerFormV7;

public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {
    StringBuffer sportOutput = new StringBuffer();;

    protected PlayerFormV8(String title) {
        super(title);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        sportOutput.setLength(0);
        List<String> selectedSport = sportList.getSelectedValuesList();
        boolean isAdjusting = e.getValueIsAdjusting();
        int numSelected = selectedSport.size();
        for (int i = 0; i < numSelected; i++) {
            sportOutput.append(selectedSport.get(i) + " ");
        }
        if (!isAdjusting) {
            if (numSelected == 1) {
                JOptionPane.showMessageDialog(this, "Selected sport is " + sportOutput);
                // when user click only one list
            } else {
                JOptionPane.showMessageDialog(this, "Selected sport are " + sportOutput);
                // when user click many lists
            }
        }
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        sportList.addListSelectionListener(this);
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
