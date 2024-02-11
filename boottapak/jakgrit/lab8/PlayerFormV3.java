package boottapak.jakgrit.lab8;

import boottapak.jakgrit.lab7.PlayerFormV2;

import javax.swing.*;

/*  This program is PlayerFormV3 that extends PlayerFormV2. 
 *  
 *  the title is "Player Form V3"
 *  this program creating a window has components:
 *  - componets is similar to PlayerFormV2
 *  
 *  but this program has add new menus:
 *  - File menu: (its menu items =>)
 *      - New menu item
 *      - Open menu item
 *      - Save menu item
 *      - Exit menu item
 *  - Config menu: (its menu =>)
 *      - Color menu (its menu items =>): Red, Green, Blue;
 *      - Size menu (it menu items =>): 16, 20, 24;
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV3 extends PlayerFormV2 {
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu;
    protected JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem;
    protected JMenu colorMenuItem, sizeMenuItem;
    protected JMenuItem redMenuItem, greenMenuItem, blueMenuItem;
    protected JMenuItem size16MenuItem, size20MenuItem, size24MenuItem;

    protected PlayerFormV3(String title) {
        super(title);
    }

    protected JMenu addFileMenu() {
        fileMenu = new JMenu("File");

        fileMenu.add(newMenuItem = new JMenuItem("New"));
        fileMenu.add(openMenuItem = new JMenuItem("Open"));
        fileMenu.add(saveMenuItem = new JMenuItem("Save"));
        fileMenu.addSeparator(); // it's ---- (line) between menu item
        fileMenu.add(exitMenuItem = new JMenuItem("Exit"));

        return fileMenu;
    }

    protected JMenu addConfigMenu() {
        configMenu = new JMenu("Config");

        configMenu.add(colorMenuItem = new JMenu("Color"));
        configMenu.add(sizeMenuItem = new JMenu("Size"));

        colorMenuItem.add(redMenuItem = new JMenuItem("Red"));
        colorMenuItem.add(greenMenuItem = new JMenuItem("Green"));
        colorMenuItem.add(blueMenuItem = new JMenuItem("Blue"));

        sizeMenuItem.add(size16MenuItem = new JMenuItem("16"));
        sizeMenuItem.add(size20MenuItem = new JMenuItem("20"));
        sizeMenuItem.add(size24MenuItem = new JMenuItem("24"));

        return configMenu;
    }

    protected void addMenus() {
        menuBar = new JMenuBar();

        menuBar.add(addFileMenu(), 0);// Add the File menu at index 0
        menuBar.add(addConfigMenu(), 1); // Add the Config menu at index 1

        setJMenuBar(menuBar); // Set the created JMenuBar for the form
    }

    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
        msw.addMenus(); // new added method
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
