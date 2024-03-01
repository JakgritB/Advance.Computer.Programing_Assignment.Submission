package boottapak.jakgrit.lab11;

import java.time.LocalDate;
import java.time.format.*;
import javax.swing.*;

import boottapak.jakgrit.lab10.PlayerFormV11;

public class PlayerFormV12 extends PlayerFormV11 {

    protected PlayerFormV12(String title) {
        super(title);
    }

    @Override
    protected void handleTextField(JTextField src) {
        if (src == nameTxtField && src.getText().isEmpty()) {
            handleEmptyTextField(src, nameTxtField, nationTxtField);

        } else if (src == nationTxtField && src.getText().isEmpty()) {
            handleEmptyTextField(src, nationTxtField, birthTxtField);

        } else if (src == birthTxtField) {
            handleDateTextField(src);

        } else {
            nationTxtField.setEnabled(true);
            birthTxtField.setEnabled(true);
            super.handleTextField(src);
        }
    }

    protected void handleEmptyTextField(JTextField textFieldName, JTextField focusTextField,
            JTextField noEnableTextField) {
        JOptionPane.showMessageDialog(this, "Please enter some data in " + textFieldName.getName());
        focusTextField.requestFocusInWindow();
        noEnableTextField.setEnabled(false);
    }

    protected void handleDateTextField(JTextField src) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate parsedDate = LocalDate.parse(src.getText(), formatter);
            JOptionPane.showMessageDialog(this, "Date of Birth is changed to " + formatter.format(parsedDate));
        } catch (DateTimeParseException e) {
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
