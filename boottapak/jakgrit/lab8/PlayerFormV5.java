package boottapak.jakgrit.lab8;

import javax.swing.*;

/*  This program is PlayerFormV5 that extends PlayerFormV4. 
 *  
 *  the title is "Player Form V5"
 *  this program creating a window has components:
 *  - componets is similar to PlayerFormV4
 *  
 *  but this program has add new components:
 *      - Football Image
 * 
 *  and has add icon image to:
 *      - New menu
 *      - Open menu
 *      - Save menu
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV5 extends PlayerFormV4 {
    protected ImageIcon newImgIcon, openImgIcon, saveImgIcon;
    protected static String FOOTBALL_IMG_PATH = "boottapak\\jakgrit\\lab8\\images\\Football.png";
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
        ReadImage footballImg = new ReadImage(FOOTBALL_IMG_PATH);
        // use ReadImage class to read picture file

        return footballImg;
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
