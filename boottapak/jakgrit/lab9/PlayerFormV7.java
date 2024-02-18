package boottapak.jakgrit.lab9;

import javax.swing.*;
import java.awt.event.*;

public class PlayerFormV7 extends PlayerFormV6 implements ItemListener {

    protected PlayerFormV7(String title) {
        super(title);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object srcObj = e.getSource();
        if (srcObj == maleButton && e.getStateChange() == ItemEvent.SELECTED) {
            handleGnderButton((JRadioButton) srcObj);
        } else if (srcObj == femaleButton && e.getStateChange() == ItemEvent.SELECTED) {
            handleGnderButton((JRadioButton) srcObj);
        } else if (srcObj == readCheckBox || srcObj == browsCheckBox ||
                srcObj == sleepCheckBox || srcObj == travelCheckBox) {
            handleHobbiesCheckbox((JCheckBox) srcObj);
        }
    }

    protected void handleGnderButton(JRadioButton src) {
        JOptionPane.showMessageDialog(this, "Gender is updated to " + src.getName());
    }

    protected void handleHobbiesCheckbox(JCheckBox src) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                if (src.isSelected()) {
                    JOptionPane.showMessageDialog(PlayerFormV7.this, src.getName() + " is one of the hobbies");
                } else {
                    JOptionPane.showMessageDialog(PlayerFormV7.this,
                            src.getName() + " is no longer one of the hobbies");
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
    protected void addListeners() {
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
