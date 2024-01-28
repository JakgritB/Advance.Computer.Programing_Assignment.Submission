package boottapak.jakgrit.lab7;

import javax.swing.*;
import java.awt.*;

public class PlayerFormV1 extends MySimpleWindow {
    protected JLabel nameLabel, nationLabel, birthLabel, genderLabel;
    protected JTextField nameTxtField, nationTxtField, birthTxtField;
    protected JRadioButton maleButton, femaleButton;
    protected ButtonGroup genderButtonGroup;
    protected JPanel playerInfoPanel, genderButtonPanel;
    protected int txtFieldLength = 15;

    protected PlayerFormV1(String title) {
        super(title);
    }

    protected void addGenderButtons() {
        genderButtonGroup = new ButtonGroup();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female", true);

        genderButtonPanel = new JPanel();
        genderButtonPanel.add(maleButton);
        genderButtonPanel.add(femaleButton);
        genderButtonGroup.add(maleButton);
        genderButtonGroup.add(femaleButton);

        // you need to add "genderButtonPanel" when call this method
    }

    protected void addPlayerInfoInput() {
        nameLabel = new JLabel("Name:");
        nameTxtField = new JTextField(txtFieldLength);
        nationLabel = new JLabel("Nationality:");
        nationTxtField = new JTextField(txtFieldLength);
        birthLabel = new JLabel("Date of Birth (eg.,31-01-2005):");
        birthTxtField = new JTextField(txtFieldLength);
        genderLabel = new JLabel("Gender:");

        playerInfoPanel = new JPanel();
        playerInfoPanel.add(nameLabel);
        playerInfoPanel.add(nameTxtField);
        playerInfoPanel.add(nationLabel);
        playerInfoPanel.add(nationTxtField);
        playerInfoPanel.add(birthLabel);
        playerInfoPanel.add(birthTxtField);
        playerInfoPanel.add(genderLabel);

        addGenderButtons();
        playerInfoPanel.add(genderButtonPanel);

        playerInfoPanel.setLayout(new GridLayout(4, 2, 10, 5));

        // you need to add "playerInfoPanel" when call this method
    }

    @Override
    protected void addComponents() {
        mainPanel.setLayout(new BorderLayout());

        addPlayerInfoInput();
        mainPanel.add(playerInfoPanel, BorderLayout.NORTH);

        super.addResetAndSubmitBotton();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
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
