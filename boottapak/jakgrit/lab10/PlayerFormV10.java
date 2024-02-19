package boottapak.jakgrit.lab10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class PlayerFormV10 extends PlayerFormV9 {
    Color textColor;
    String fontName;
    int fontStyle, fontSize;

    protected PlayerFormV10(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObj = e.getSource();
        JMenuItem srcMI = (JMenuItem) srcObj;
        if (srcMI == redMenuItem || srcMI == greenMenuItem || srcMI == blueMenuItem) {
            handleColorMenu(srcMI);
        } else if (srcMI == size16MenuItem || srcMI == size20MenuItem || srcMI == size24MenuItem) {
            handleTextSizeMenu(srcMI);
        } else if (srcMI == newMenuItem || srcMI == openMenuItem || srcMI == saveMenuItem) {
            handleFileMenu(srcMI);
        } else if (srcMI == exitMenuItem) {
            System.exit(0);
        }
    }

    protected void handleColorMenu(JMenuItem src) {
        if (src == redMenuItem) {
            textColor = Color.RED;
        } else if (src == greenMenuItem) {
            textColor = Color.GREEN;
        } else if (src == blueMenuItem) {
            textColor = Color.BLUE;
        }
        setTextColor(textColor);
    }

    protected void setTextColor(Color color) {
        nameTxtField.setForeground(color);
        nationTxtField.setForeground(color);
        birthTxtField.setForeground(color);
    }

    protected void handleTextSizeMenu(JMenuItem src) {
        fontName = "Serif";
        fontStyle = Font.BOLD;
        if (src == size16MenuItem) {
            fontSize = 16;
        } else if (src == size20MenuItem) {
            fontSize = 20;
        } else if (src == size24MenuItem) {
            fontSize = 24;
        }
        setTextSizeAndFont(fontName, fontStyle, fontSize);
    }

    protected void setTextSizeAndFont(String fontName, int fontStyle, int fontSize) {
        Font font = new Font(fontName, fontStyle, fontSize);
        noteTxtArea.setFont(font);
    }

    protected void handleFileMenu(JMenuItem src) {
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
