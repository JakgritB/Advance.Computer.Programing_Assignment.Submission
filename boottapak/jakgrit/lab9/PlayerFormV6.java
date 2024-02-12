package boottapak.jakgrit.lab9;

import javax.swing.*;
import java.awt.event.*;

import boottapak.jakgrit.lab8.PlayerFormV5;

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener {

    protected PlayerFormV6(String title) {
        super(title);
    }

    protected void addListeners() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) {
            handleSubmitButton();
        } else if (src == resetButton) {

        } else if (src instanceof JTextField) {

        }
    }

    protected void handleSubmitButton() {
        
        JOptionPane.showMessageDialog(this, "Hello world");
    }

    public static void createAndShowGUI() {
        PlayerFormV6 msw = new PlayerFormV6("Player Form V6");
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
