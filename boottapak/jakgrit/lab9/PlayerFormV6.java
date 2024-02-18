package boottapak.jakgrit.lab9;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import boottapak.jakgrit.lab8.PlayerFormV5;

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener {
    String getName, getNation, getBirth, getGender, getHobbies, getPlayerType;
    List<String> getSport;

    protected PlayerFormV6(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) {
            handleSubmitButton();
        } else if (src == resetButton) {
            handleResetButton();
        } else if (src instanceof JTextField) {
            handleTextField((JTextField) src);
        }
    }

    protected void handleSubmitButton() {
        getTextAndOther();
        if (getName.isEmpty() || getNation.isEmpty() || getBirth.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You have not filled in all the required information.");
        } else {
            String text = getName + " has nationality as " + getNation
                    + " and was born on " + getBirth
                    + ", has gender as " + getGender
                    + ", is a " + getPlayerType + " player, has hobbies as " + getHobbies
                    + " and plays " + getSport;
            JOptionPane.showMessageDialog(this, text);
        }
    }

    protected void handleResetButton() {
        nameTxtField.setText(null);
        nationTxtField.setText(null);
        birthTxtField.setText(null);
    }

    protected void handleTextField(JTextField src) {
        JOptionPane.showMessageDialog(this, src.getName() + " is changed to " + src.getText());
    }

    protected void getTextAndOther() {
        getName = nameTxtField.getText();
        getNation = nationTxtField.getText();
        getBirth = birthTxtField.getText();
        getGender = getSelectedGender();
        getPlayerType = (String) playerTypeComboBox.getSelectedItem();
        getHobbies = getSelectedHobbies();
        getSport = sportList.getSelectedValuesList();
    }

    protected String getSelectedHobbies() {
        StringBuffer selectedHobbies = new StringBuffer();
        if (readCheckBox.isSelected()) {
            selectedHobbies.append(readCheckBox.getActionCommand() + " ");
        }
        if (browsCheckBox.isSelected()) {
            selectedHobbies.append(browsCheckBox.getActionCommand() + " ");
        }
        if (sleepCheckBox.isSelected()) {
            selectedHobbies.append(sleepCheckBox.getActionCommand() + " ");
        }
        if (travelCheckBox.isSelected()) {
            selectedHobbies.append(travelCheckBox.getActionCommand() + " ");
        }
        return selectedHobbies.toString();
    }

    protected String getSelectedGender() {
        if (maleButton.isSelected()) {
            return maleButton.getText();
        } else if (femaleButton.isSelected()) {
            return femaleButton.getText();
        } else {
            return null;
        }
    }

    protected void addListeners() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        nameTxtField.addActionListener(this);
        nationTxtField.addActionListener(this);
        birthTxtField.addActionListener(this);
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        nameTxtField.setName("Name");
        nationTxtField.setName("Nationality");
        birthTxtField.setName("Date of Birth");
    }

    public static void createAndShowGUI() {
        PlayerFormV6 msw = new PlayerFormV6("Player Form V6");
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
