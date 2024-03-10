package boottapak.jakgrit.lab11;

import java.time.LocalDate;
import java.time.format.*;
import javax.swing.*;

import boottapak.jakgrit.lab10.PlayerFormV11;

/*  This program is PlayerFormV12 that extends PlayerFormV11. 
 *  
 *  The title is "Player Form V12"
 *  this program has component similar to PlayerFormV11
 *  but has Checking Data Formats and Handling Exceptions
 * 
 *  >> When user do not enter data in "Name Text Field"
 *  -program will show message "Please enter some data in Name"
 *  -Nation text field will disabled
 * 
 *  >>When user enter data in "Name Text Field"
 *  -program will show message "Name is changed to <data>"
 *  -Nation text field will enabled
 *  -Focus on "Nation text Field"
 * 
 *  >>When user do not enter data in "Nation Text Field"
 *  -program will show message "Please enter some data in Nationality"
 *  -Birth text field will disabled
 * 
 *  >>When user enter data in "Nation Text Field"
 *  -program will show message "Nationality is changed to <data>"
 *  -Birth text field will enabled
 *  -Focus on "Birth Text Field"
 * 
 *  >>When user do not enter or uncorrect in "Birth Text Field"
 *  -program will show message "Please enter a valid date in Date of Birth"
 *  
 *  >>When user enter in correct form in "Birth Text Field", correct form is dd-MM-yyyy
 *  -program will show message "Date of Birth is changed to <dd-MM-yyyy>"
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV12 extends PlayerFormV11 {

    protected PlayerFormV12(String title) {
        super(title);
    }

    @Override
    protected void handleTextField(JTextField src) {
        if (src == nameTxtField) {
            handleNormalTextField(src, nationTxtField, nationTxtField);

        } else if (src == nationTxtField) {
            handleNormalTextField(src, birthTxtField, birthTxtField);

        } else if (src == birthTxtField) {
            handleDateTextField(src);
            
        }
    }

    protected void handleNormalTextField(JTextField textFieldName, JTextField focusTextField, JTextField setEnablTextField) {
        // this is for check text field empty or not
        // ex argument : ( <TextField Selected> , <TextField want to focus next>, <TextField want to enable or disable> )

        if (textFieldName.getText().isEmpty()) {    // user do not enter data
            JOptionPane.showMessageDialog(this, "Please enter some data in " + textFieldName.getName());
            setEnablTextField.setEnabled(false);

        } else if (!textFieldName.getText().isEmpty()) {    // user enter data
            JOptionPane.showMessageDialog(this, textFieldName.getName() + " is changed to " + textFieldName.getText());
            setEnablTextField.setEnabled(true);
            focusTextField.requestFocusInWindow(); // Focus 
        }
    }

    protected void handleDateTextField(JTextField src) {
        // this is for check date
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // you can change this pattern
            LocalDate parsedDate = LocalDate.parse(src.getText(), formatter);
            JOptionPane.showMessageDialog(this, "Date of Birth is changed to " + formatter.format(parsedDate));
        } catch (DateTimeParseException e) {
            // this is when user enter not same as pattern
            JOptionPane.showMessageDialog(this, "Please enter a valid date in " + src.getName());
        }
    }

    public static void createAndShowGUI() {
        PlayerFormV12 msw = new PlayerFormV12("Player Form V12");
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
