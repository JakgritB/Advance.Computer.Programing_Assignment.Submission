package boottapak.jakgrit.lab8;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PlayerFormV5 extends PlayerFormV4 {
    protected ImageIcon newImgIcon, openImgIcon, saveImgIcon;
    protected static String footballImgPath = "boottapak\\jakgrit\\lab8\\images\\Football.png";
    protected JPanel footballPanel;

    protected PlayerFormV5(String title) {
        super(title);
    }

    protected void setIcon() {
        newImgIcon = new ImageIcon("boottapak\\jakgrit\\lab8\\images\\New-icon.png");
        openImgIcon = new ImageIcon("boottapak\\jakgrit\\lab8\\images\\Open-icon.png");
        saveImgIcon = new ImageIcon("boottapak\\jakgrit\\lab8\\images\\Save-icon.png");

        newMenuItem.setIcon(newImgIcon);
        openMenuItem.setIcon(openImgIcon);
        saveMenuItem.setIcon(saveImgIcon);
    }

    protected JPanel addFootballImg() {
        ReadImage footballImg = new ReadImage(footballImgPath);
        footballPanel = new JPanel();
        footballImg.setBorder(new EmptyBorder(0, 0, 225, 400));
        footballPanel.add(footballImg);

        return footballPanel;
    }

    @Override
    protected void addMenus() {
        super.addMenus();
        setIcon();
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        mainPanel.add(addFootballImg(), 6);

    }

    public static void createAndShowGUI() {
        PlayerFormV5 msw = new PlayerFormV5("Player Form V5");
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
