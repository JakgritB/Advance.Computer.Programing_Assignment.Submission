package boottapak.jakgrit.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV4 extends PlayerFormV3 {

    protected PlayerFormV4(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainPanel.add(addPlayerInfoInput());

        mainPanel.add(addPlayerType());

        mainPanel.add(addNote());

        mainPanel.add(addResetAndSubmitBotton());

        add(mainPanel, BorderLayout.SOUTH); // Add the main panel to the JFrame
        super.addComponents();
    }

    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
        msw.addMenus();
        msw.addComponents();
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
