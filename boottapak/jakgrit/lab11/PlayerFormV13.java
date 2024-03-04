package boottapak.jakgrit.lab11;

import java.io.*;
import javax.swing.*;

public class PlayerFormV13 extends PlayerFormV12 {
    StringBuffer readDataText;

    protected PlayerFormV13(String title) {
        super(title);
    }

    @Override
    protected void handleFileChooser(int openOrSave, String string) {
        super.handleFileChooser(openOrSave, string);
        if (string.equals("Opening file ")) {
            readFile();
        } else if (string.equals("Saving in file ")) {
            writeFile();
        }
    }

    protected void writeFile() {
        try {
            PrintWriter printWriter = new PrintWriter(file);

            getTextAndOther();
            String text = getName + " has nationality as " + getNation
                    + " and was born on " + getBirth
                    + ", has gender as " + getGender
                    + ", is a " + getPlayerType + " player, has hobbies as " + getHobbies
                    + " and plays " + getSport;

            printWriter.println(text);

            printWriter.close();
        } catch (IOException io) {
            JOptionPane.showMessageDialog(this, "Fail to save file");
        } catch (NullPointerException n) {

        }
    }

    protected void readFile() {
        try {
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            String readPathText = "Data read from file " + file.getAbsolutePath() + " is";

            readDataText = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                readDataText.append(line + "\n");
            }

            fileReader.close();
            reader.close();

            JOptionPane.showMessageDialog(this, readPathText + "\n" + readDataText);

        } catch (IOException io) {
            JOptionPane.showMessageDialog(this, "Fail to open file");
        } catch (NullPointerException n) {
            
        }
    }

    public static void createAndShowGUI() {
        PlayerFormV13 msw = new PlayerFormV13("Player Form V13");
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
