package boottapak.jakgrit.lab8;

import boottapak.jakgrit.lab7.PlayerFormV2;

import javax.swing.*;

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
        fileMenu.addSeparator();
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

        menuBar.add(addFileMenu());
        menuBar.add(addConfigMenu());

        setJMenuBar(menuBar);
    }

    @Override
    protected void addComponents() {
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
