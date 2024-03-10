package boottapak.jakgrit.lab11;

import java.io.*;
import javax.swing.*;

/*  This program is PlayerFormV13 that extends PlayerFormV12. 
 *  
 *  The title is "Player Form V13"
 *  this program has component similar to PlayerFormV12
 *  but can Save file and Open File
 * 
 *  >> User can save file in .txt File
 *  -information will get from each component like TextField, CheckBox, RadioButton
 *  
 *  >> User can open .txt file to read file
 *  -when open file program will show message "Data read from file <File Path> is "
 *  -and show infomation from file "<Name> has nationality as <Nation> and was born on <Birth> 
 *                                  has gender as <Gender> is a <PlayerType> player, 
 *                                  has hobbies as <Hobbies> and plays <Sport>"
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV13 extends PlayerFormV12 {
    String playerInfoText; // this is info pettern message
    StringBuffer readDataText; // this is information get from file

    protected PlayerFormV13(String title) {
        super(title);
    }

    @Override
    protected void handleFileChooser(int openOrSave, String string) {
        // this is to see open or save , string is to show message dialog
        super.handleFileChooser(openOrSave, string);
        if (string.equals("Opening file ")) {
            handleOpenFile();

        } else if (string.equals("Saving in file ")) {
            handleSaveFile();
        }
    }

    protected void handleOpenFile() {
        readFile();
    }

    protected void handleSaveFile() {
        setPlayerInfoText();
        writeFile();
    }

    protected void setPlayerInfoText() {
        getTextAndOther(); // get each variable from each component
        playerInfoText = getName + " has nationality as " + getNation
                + " and was born on " + getBirth
                + ", has gender as " + getGender
                + ", is a " + getPlayerType + " player, has hobbies as " + getHobbies
                + " and plays " + getSport;
    }

    protected void writeFile() {
        try {
            PrintWriter printWriter = new PrintWriter(file); // file is file that user selected
            printWriter.println(playerInfoText); // write file
            printWriter.close(); // don't forget this, you need to close
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

            readDataText = new StringBuffer(); // create new memory of StringBuffer
            while ((line = reader.readLine()) != null) { // read each line in file //while info in line isn't null
                readDataText.append(line + "\n");
            }

            fileReader.close(); // don't forget this, you need to close
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
