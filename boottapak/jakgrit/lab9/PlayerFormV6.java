package boottapak.jakgrit.lab9;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

import boottapak.jakgrit.lab8.PlayerFormV5;

/*  This program is PlayerFormV6 that extends PlayerFormV5. 
 *  
 *  The title is "Player Form V6"
 *  this program has component similar to PlayerFormV5
 *  but has add ActionListener
 * 
 *  - When user click on Submit button
 *  it will show message 
 *  >>> "<name> has nationality as <nationality> 
 *  and was born on <date of birth>, has gender as <gender>, 
 *  is a <playertype> player, has hobbies as <hobbies> and plays <sports>" <<<
 * 
 *  - When user click on Reset button
 *  it will reset Name TextField, Nationality TextField and Date of Birth TextField.
 * 
 *  - When the user changes any text field (name, nationality, or date of birth) 
 *  and press Enter on the keyboard, 
 *  the program displays the message dialog showing that text field is updated, 
 *  it will show  >>> "<Textfield Name> is changed to <Textfield Value>" <<<
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener {
    String getName, getNation, getBirth, getGender, getHobbies, getPlayerType;
    List<String> getSport;

    protected PlayerFormV6(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource(); // it get what user click on
        if (src == submitButton) { // when user click submit
            handleSubmitButton();
        } else if (src == resetButton) { // when user click reset
            handleResetButton();
        } else if (src instanceof JTextField) { // when user press "Enter" in TextField
            handleTextField((JTextField) src);
        }
    }

    protected void handleSubmitButton() {
        getTextAndOther(); // initilize each info
        if (getName.isEmpty() || getNation.isEmpty() || getBirth.isEmpty()) { // check if it empty or not
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

    protected void handleTextField(JTextField src) { // when user press "Enter"
        JOptionPane.showMessageDialog(this, src.getName() + " is changed to " + src.getText());
        // use this only once for many textField
    }

    protected void getTextAndOther() { // get and initialize
        getName = nameTxtField.getText();
        getNation = nationTxtField.getText();
        getBirth = birthTxtField.getText();
        getGender = getSelectedGender();
        getPlayerType = (String) playerTypeComboBox.getSelectedItem(); // convert object to String
        getHobbies = getSelectedHobbies();
        getSport = sportList.getSelectedValuesList(); // get all list that user selected
    }

    protected String getSelectedHobbies() {
        StringBuffer selectedHobbies = new StringBuffer(); // create StringBuffer (it's like array)
        if (readCheckBox.isSelected()) { // when readcheckbox is selected
            selectedHobbies.append(readCheckBox.getActionCommand() + " "); // add readCheckbox text to selectedHobbies
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
        return selectedHobbies.toString(); // convert StringBuffer to String
    }

    protected String getSelectedGender() {
        if (maleButton.isSelected()) { // when male is selected
            return maleButton.getText(); // getText from maleButton is ("Male")
        } else if (femaleButton.isSelected()) {
            return femaleButton.getText();
        } else {
            return null;
        }
    }

    protected void addListeners() { // don't forgot to add listener to each component !!!
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
        birthTxtField.setName("Date of Birth"); // setName when you use getName for some Label
    }

    public static void createAndShowGUI() {
        PlayerFormV6 msw = new PlayerFormV6("Player Form V6");
        msw.addMenus();
        msw.addComponents();
        msw.addListeners(); // addListener
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
