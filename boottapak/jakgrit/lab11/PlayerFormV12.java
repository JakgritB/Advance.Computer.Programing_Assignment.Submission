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
        if (src == nameTxtField) {
            handleNormalTextField(src, nationTxtField, nationTxtField);

        } else if (src == nationTxtField) {
            handleNormalTextField(src, birthTxtField, birthTxtField);

        } else if (src == birthTxtField) {
            handleDateTextField(src);
            
        }
    }

    protected void handleNormalTextField(JTextField textFieldName, JTextField focusTextField,
            JTextField setEnablTextField) {
        if (textFieldName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + textFieldName.getName());
            setEnablTextField.setEnabled(false);

        } else if (!textFieldName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, textFieldName.getName() + " is changed to " + textFieldName.getText());
            setEnablTextField.setEnabled(true);
            focusTextField.requestFocusInWindow();
        }
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
