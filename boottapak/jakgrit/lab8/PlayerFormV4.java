package boottapak.jakgrit.lab8;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV4 extends PlayerFormV3 {
    protected JLabel hobbiesLabel;
    protected JCheckBox hobbiesCheckBox;

    protected PlayerFormV4(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {
        super.addComponents();
    }

    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");
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
