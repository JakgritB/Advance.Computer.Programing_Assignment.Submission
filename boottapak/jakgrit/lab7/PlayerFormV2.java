package boottapak.jakgrit.lab7;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV2 extends PlayerFormV1 {
    protected JLabel playerTypeLabel, noteLabel;
    protected JPanel playerTypePanel;
    protected JComboBox<String> playerTypeComboBox;
    protected JTextArea noteTxtArea;
    protected JPanel notePanel;

    protected PlayerFormV2(String title) {
        super(title);
    }

    protected void addPlayerType() {
        playerTypeLabel = new JLabel("Player Type:");

        playerTypeComboBox = new JComboBox<String>();
        playerTypeComboBox.addItem("Beginner");
        playerTypeComboBox.addItem("Amateur");
        playerTypeComboBox.addItem("Professional");
        playerTypeComboBox.setSelectedItem("Amateur");
        playerTypeComboBox.setEditable(false);

        playerTypePanel = new JPanel();
        playerTypePanel.setLayout(new GridLayout(1, 2));
        playerTypePanel.add(playerTypeLabel);
        playerTypePanel.add(playerTypeComboBox);

        // you need to add "playerTypePanel" when call this method
    }

    protected void addNote() {
        noteLabel = new JLabel("Note:");
        noteTxtArea = new JTextArea(3, 35);

        noteTxtArea.setText("Thailand will face Oman at the " +
                "Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in " +
                "their second match of the 2023 AFC Asian Cup, Group F.\n\n");
        noteTxtArea.setCaretPosition(0);
        JScrollPane scrollPane = new JScrollPane(noteTxtArea);
        noteTxtArea.setLineWrap(true);
        noteTxtArea.setWrapStyleWord(true);

        notePanel = new JPanel();
        notePanel.setLayout(new GridLayout(2, 1, 0, -10));
        notePanel.add(noteLabel);
        notePanel.add(scrollPane);

        // you need to add "notePanel" when call this method
    }

    @Override
    protected void addComponents() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        addPlayerInfoInput();
        mainPanel.add(playerInfoPanel);

        addPlayerType();
        mainPanel.add(playerTypePanel);

        addNote();
        mainPanel.add(notePanel);

        addResetAndSubmitBotton();
        mainPanel.add(buttonPanel);

        add(mainPanel);
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
