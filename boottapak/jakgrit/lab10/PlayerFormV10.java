package boottapak.jakgrit.lab10;

/*  This program is PlayerFormV10 that extends PlayerFormV9. 
 *  
 *  The title is "Player Form V10"
 *  this program has component similar to PlayerFormV9
 *  but has add
 * 
 *  - User can choose the color of text field name, nation, birth
 *  into Red text, Green text and Blue text.
 *  in Config menu -> Color menu.
 * 
 *  - User can set text size of Note
 *  into size 16, 20, 24 and font is Serif and Bold
 *  in Config menu -> Size menu
 * 
 *  - When the user click on New, Open and Save menu 
 *  the program displays the dialog >>> "You click menu <menu item>" <<<
 *                               ex.>>> "You click menu New" <<<
 * 
 *  - When the user click on Exit menu
 *  the program will close.
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class PlayerFormV10 extends PlayerFormV9 {
    Color textFieldColor; // this variable is for set text field color
    String fontName; // this variable is for set font
    int fontStyle, fontSize; // this variable is for set font

    protected PlayerFormV10(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObj = e.getSource();
        if (srcObj == redMenuItem || srcObj == greenMenuItem || srcObj == blueMenuItem) {
            // when user set text color
            handleColorMenu((JMenuItem) srcObj);
        } 
        else if (srcObj == size16MenuItem || srcObj == size20MenuItem || srcObj == size24MenuItem) {
            // when user set text size
            handleTextAreaSizeMenu((JMenuItem) srcObj);
        } 
        else if (srcObj == newMenuItem || srcObj == openMenuItem || srcObj == saveMenuItem) {
            // when user click on menu item
            handleFileMenu((JMenuItem) srcObj);
        } 
        else if (srcObj == exitMenuItem) {
            System.exit(0); // program will close when user click on Exit menu
        }
    }

    protected void handleColorMenu(JMenuItem src) {
        // when user click on any color menu // ex parameter: "redMenuItem"

        if (src == redMenuItem) {
            textFieldColor = Color.RED;
        } else if (src == greenMenuItem) {
            textFieldColor = Color.GREEN;
        } else if (src == blueMenuItem) {
            textFieldColor = Color.BLUE;
        }
        setTextFieldColor(textFieldColor);
    }

    protected void setTextFieldColor(Color color) {
        // this is for set text field color // ex parameter: "Color.RED"

        nameTxtField.setForeground(color);
        nationTxtField.setForeground(color);
        birthTxtField.setForeground(color);
    }

    protected void handleTextAreaSizeMenu(JMenuItem src) {
        // when user select on any text size // ex parameter: "size16MenuItem"

        fontName = "Serif";
        fontStyle = Font.BOLD;
        if (src == size16MenuItem) {
            fontSize = 16;
        } else if (src == size20MenuItem) {
            fontSize = 20;
        } else if (src == size24MenuItem) {
            fontSize = 24;
        }
        setTextAreaSizeAndFont(fontName, fontStyle, fontSize);
    }

    protected void setTextAreaSizeAndFont(String fontName, int fontStyle, int fontSize) {
        // this is for set text area size and font // ex parameter: "Serif","Font.BOLD","16"
        Font font = new Font(fontName, fontStyle, fontSize);
        noteTxtArea.setFont(font);
    }

    protected void handleFileMenu(JMenuItem src) { // handle when user click on "menu item" in File menu
        JOptionPane.showMessageDialog(this, "You click menu " + src.getName());
    }

    @Override
    protected void addListeners() {
        super.addListeners();
        redMenuItem.addActionListener(this);
        greenMenuItem.addActionListener(this);
        blueMenuItem.addActionListener(this);
        size16MenuItem.addActionListener(this);
        size20MenuItem.addActionListener(this);
        size24MenuItem.addActionListener(this);
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        newMenuItem.setName("New");
        openMenuItem.setName("Open");
        saveMenuItem.setName("Save");
    }

    public static void createAndShowGUI() {
        PlayerFormV10 msw = new PlayerFormV10("Player Form V10");
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
