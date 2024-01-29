package boottapak.jakgrit.lab7;

import javax.swing.*;
import java.awt.*;

/*  This program is PlayerFormV2 that extends PlayerFormV1. 
 *  
 *  the title is "Player Form V2"
 *  this program creating a window has components:
 *  - componets is similar to PlayerFormV1
 *  - but have "Player type" and "Note"
 *      before reset and submit button 
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV2 extends PlayerFormV1 {
    protected JLabel playerTypeLabel, noteLabel;
    protected JPanel playerTypePanel;
    protected JComboBox<String> playerTypeComboBox;
    protected JTextArea noteTxtArea;
    protected JPanel notePanel;

    // this is constructure to create JFrame and add title
    protected PlayerFormV2(String title) {
        super(title);
    }

    protected JPanel addPlayerType() {
        // create label and ComboBox(Select box)
        playerTypeLabel = new JLabel("Player Type:");

        playerTypeComboBox = new JComboBox<String>();
        playerTypeComboBox.addItem("Beginner");
        playerTypeComboBox.addItem("Amateur");
        playerTypeComboBox.addItem("Professional");
        playerTypeComboBox.setSelectedItem("Amateur"); // it show Amateur as first
        playerTypeComboBox.setEditable(false); // can't edit ComboBox by user

        // create panel and add label,combobox to panel
        playerTypePanel = new JPanel();
        playerTypePanel.setLayout(new GridLayout(1, 2));
        playerTypePanel.add(playerTypeLabel);
        playerTypePanel.add(playerTypeComboBox);

        return playerTypePanel;
    }

    protected JPanel addNote() {
        // create label and text area
        noteLabel = new JLabel("Note:");
        noteTxtArea = new JTextArea(3, 35);

        noteTxtArea.setText("Thailand will face Oman at the " +
                "Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in " +
                "their second match of the 2023 AFC Asian Cup, Group F.\n\n");
        noteTxtArea.setCaretPosition(0); // this line is show first part to user
        // create scroll pane in note area
        JScrollPane scrollPane = new JScrollPane(noteTxtArea);
        noteTxtArea.setLineWrap(true); // cut line when full of column
        noteTxtArea.setWrapStyleWord(true); // cut line when finish word

        // create panel and add label,text area to panel
        notePanel = new JPanel();
        notePanel.setLayout(new GridLayout(2, 1, 0, -10));
        notePanel.add(noteLabel);
        notePanel.add(scrollPane);

        return notePanel;
    }

    @Override
    protected void addComponents() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainPanel.add(addPlayerInfoInput());

        mainPanel.add(addPlayerType());

        mainPanel.add(addNote());

        mainPanel.add(addResetAndSubmitBotton());

        add(mainPanel); // Add the main panel to the JFrame
    }

    public static void createAndShowGUI() {
        PlayerFormV2 msw = new PlayerFormV2("Player Form V2");
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
