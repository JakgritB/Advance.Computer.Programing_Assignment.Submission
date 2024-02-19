package boottapak.jakgrit.lab10;

import javax.swing.*;
import javax.swing.event.*;

public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {

    protected PlayerFormV9(String title) {
        super(title);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider src = (JSlider) e.getSource();
        boolean isAdjusting = src.getValueIsAdjusting();
        if (!isAdjusting) {
            int value = src.getValue();
            String sourceStr = src.getName();
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
