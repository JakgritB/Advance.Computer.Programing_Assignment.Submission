package boottapak.jakgrit.lab10;

/*  This program is PlayerFormV11 that extends PlayerFormV10. 
 *  
 *  The title is "Player Form V11"
 *  this program has component similar to PlayerFormV10
 *  but has add
 * 
 *  - Custom menu item in Config menu
 *  that can customize text color in great detail.
 * 
 *  - When user click on Custom menu
 *  the program will displays the Color Chooser Dialog
 *  for user to select color to set text field color.
 * 
 *  - User can select any file to open 
 *  by click on "Open menu" in File menu.
 *  After open file, it will show message "Opening file <opened file path>".
 * 
 *  - User can type in the file name or select a file to save
 *  by click on "Save menu" in File menu.
 *  After save file, it will show message "Saving in file <saved file path>"
 * 
 *  - Shortcut key for each menu:
 *      - In main page:
 *              - to call File menu to slide down: Alt + F
 *              - New menu: Ctrl + N key
 *              - Open menu: Ctrl + O key
 *              - Save menu: Ctrl + S key
 *              - Exit menu: Ctrl + Q key
 *      - When File menu slide down:
 *              - New menu: N key
 *              - Open menu: O key
 *              - Save menu: S key
 *              - Exit menu: Q key
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class PlayerFormV11 extends PlayerFormV10 {
    protected JMenuItem customColorMenuItem;
    protected JFileChooser fileChooser; // this is fileChooser window
    protected Color chosenColor; // this variable will keep color that user select in color chooser

    protected PlayerFormV11(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObj = e.getSource();
        if (srcObj == customColorMenuItem) { // when user click on Custom color
            handleCustomColorMI();
        } 
        else if (srcObj == openMenuItem) {
            // when user want to open file
            fileChooser = new JFileChooser(); // create new windows "file Chooser"

            handleFileChooser(fileChooser.showOpenDialog(this), "Opening file ");
            // ex argument : ( <openFile or saveFile> , <string when finish selected> )
        } 
        else if (srcObj == saveMenuItem) {
            // when user want to save file
            fileChooser = new JFileChooser(); // create new windows "file Chooser"
            handleFileChooser(fileChooser.showSaveDialog(this), "Saving in file ");
            // ex argument : ( <openFile or saveFile> , <string when finish selected> )
        }
    }

    protected void handleFileChooser(int openOrSave, String string) {
        // this is for show file chooser
        // ex argument : ( <openFile or saveFile> , <string when finish selected> )

        int returnVal = openOrSave; // this is value of file that user get

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // if user chosen file // if user don't choose any file, will not do this code

            File file = fileChooser.getSelectedFile(); // get selected file from file chooser
            JOptionPane.showMessageDialog(this, string + file.getAbsolutePath()); // show path of file
        }
    }

    protected void handleCustomColorMI() {
        // this method is for set text color in great detail

        chosenColor = JColorChooser.showDialog(this, "Choose Text Color", nameTxtField.getForeground());
        // // // // // // // // ex argument : (<mother windown> , <title> , <get first color from?>)
        // "chosenColor" will get color from color chooser
        // at first colorChooser will get first color from text field
        // and show color chooser dialog for user to selected color

        setTextFieldColor(chosenColor); // this will call method in "V10" to set text field color
    }

    @Override
    protected void handleFileMenu(JMenuItem src) {
        if (src == openMenuItem) {
            // this line have no code, because don't want to show message when click open menu
            // to bypass to show file chooser to open file
        } else if (src == saveMenuItem) {
            // this line have no code, because don't want to show message when click save menu
            // to bypass to show file chooser to save file
        } else {
            JOptionPane.showMessageDialog(this, "You click menu " + src.getName());
            //when click another menu, it will show message
        }
    }

    protected void enableKeyboard() {
        // this is when File menu slide down
        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + F key or F key
        newMenuItem.setMnemonic(KeyEvent.VK_N); // N key
        openMenuItem.setMnemonic(KeyEvent.VK_O); // O key
        saveMenuItem.setMnemonic(KeyEvent.VK_S); // S key
        exitMenuItem.setMnemonic(KeyEvent.VK_Q); // Q key

        // this is when in the main page
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); // Ctrl + N key
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); // Ctrl + O key
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK)); // Ctrl + S key
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK)); // Ctrl + Q key
    }

    @Override
    protected void addMenus() {
        super.addMenus();
        colorMenuItem.add(customColorMenuItem = new JMenuItem("Custom"));
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        customColorMenuItem.addActionListener(this);
        fileMenu.addActionListener(this);
    }

    public static void createAndShowGUI() {
        PlayerFormV11 msw = new PlayerFormV11("Player Form V11");
        msw.addMenus();
        msw.addComponents();
        msw.addListeners();
        msw.enableKeyboard();
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