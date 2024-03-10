package boottapak.jakgrit.lab11;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

/*  This program is PlayerFormV14 that extends PlayerFormV13. 
 *  
 *  The title is "Player Form V14"
 *  this program has component similar to PlayerFormV13
 *  but can Save file as Object and Open Object File to fill form
 *  and add
 * 
 *  >> Fill menu
 *      -user can select to fill or not
 *      if select Fill >>> Yes
 *      {   user can save file and open file as Object }
 *      if select Fill >>> No
 *      {   user can save file and open file as Txt }
 * 
 *  >> User can save object file in .obj File
 *  -information will get from each component like TextField, CheckBox, RadioButton
 *  -it will save as Object file
 *  
 *  >> User can open .obj file to read file
 *  -program will show each action in program like "Gender has changed to Male"
 *  -program will show message "Data read from file <File Path> is "
 *  -and show infomation from file "<Name> has nationality as <Nation> and was born on <Birth> 
 *                                  has gender as <Gender> is a <PlayerType> player, 
 *                                  has hobbies as <Hobbies> and plays <Sport>"
 *  -*Program will fill each componet like from file that user open
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV14 extends PlayerFormV13 {
    protected JMenu fillMenu;
    protected JRadioButtonMenuItem yesFillMenuItem, noFillMenuItem;
    protected ButtonGroup fillMenuButtonGroup;
    protected ArrayList<String> hobbiesArrayList, sportsArrayList;
    protected int yearInSport;

    protected String name, nationality, dob, playerType, gender;
    protected ArrayList<String> hobbies, sports;
    protected int year;

    protected PlayerFormV14(String title) {
        super(title);
    }

    protected JMenu addFillMenu() {
        // add Fill Menu to Menu Bar
        fillMenu = new JMenu("Fill");

        yesFillMenuItem = new JRadioButtonMenuItem("Yes");
        noFillMenuItem = new JRadioButtonMenuItem("No", true);

        fillMenuButtonGroup = new ButtonGroup();
        fillMenuButtonGroup.add(yesFillMenuItem);
        fillMenuButtonGroup.add(noFillMenuItem);

        fillMenu.add(yesFillMenuItem);
        fillMenu.add(noFillMenuItem);

        return fillMenu;
    }

    protected ArrayList<String> getHobbiesArrayList() {
        hobbiesArrayList = new ArrayList<String>();

        if (readCheckBox.isSelected()) {
            hobbiesArrayList.add(readCheckBox.getActionCommand());
        }
        if (browsCheckBox.isSelected()) {
            hobbiesArrayList.add(browsCheckBox.getActionCommand());
        }
        if (sleepCheckBox.isSelected()) {
            hobbiesArrayList.add(sleepCheckBox.getActionCommand());
        }
        if (travelCheckBox.isSelected()) {
            hobbiesArrayList.add(travelCheckBox.getActionCommand());
        }
        return hobbiesArrayList;
    }

    protected ArrayList<String> getSportsArrayList() {
        sportsArrayList = new ArrayList<String>();

        sportsArrayList = (ArrayList<String>) sportList.getSelectedValuesList();

        return sportsArrayList;
    }

    protected int getYearInSport() {
        yearInSport = yearInSportSlider.getValue();

        return yearInSport;
    }

    protected void objStreamWriterOfPlayer() {
        getTextAndOther();
        Player player = new Player(getName, getNation, getBirth, getPlayerType, getGender,
                getHobbiesArrayList(), getSportsArrayList(), getYearInSport());
        // set each variable to Object
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(player);

            oos.close();
            fos.close();

        } catch (IOException io) {
            JOptionPane.showMessageDialog(this, "Fail to save file");
        } catch (NullPointerException n) {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fail to save file");
        }
    }

    protected void objStreamReaderOfPlayer() {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Player player = (Player) ois.readObject();
            // get Object from file and cast to Player

            name = player.getName();
            nationality = player.getNationality();
            dob = player.getDob();
            playerType = player.getPlayerType();
            gender = player.getGender();
            hobbies = player.getHobbies();
            sports = player.getSports();
            year = player.getYear();

            fis.close();
            ois.close();

        } catch (IOException io) {
            JOptionPane.showMessageDialog(this, "Fail to open file");
        } catch (NullPointerException n) {

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fail to open file");
        }
    }

    protected void readFileFromObject() {
        String readPathText = "Data read from file " + file.getAbsolutePath() + " is";
        String readDataText = name + " has nationality as " + nationality
                + " and was born on " + dob
                + ", has gender as " + gender
                + ", is a " + playerType + " player, has hobbies as " + hobbies
                + " and plays " + sports;

        JOptionPane.showMessageDialog(this, readPathText + "\n" + readDataText);
    }

    protected void fillForm() {
        try {
            // fill Name Text Field
            nameTxtField.setText(name);

            // fill Nation Text Field
            nationTxtField.setText(nationality);

            // fill Birth Text Field
            birthTxtField.setText(dob);

            // set Gender RadioButton
            if (gender.equals("Male")) {
                maleButton.setSelected(true);
            } else if (gender.equals("Female")) {
                femaleButton.setSelected(true);
            }

            // set PlayerType ComboBox
            if (playerType.equals("Beginner")) {
                playerTypeComboBox.setSelectedIndex(0);
            } else if (playerType.equals("Amateur")) {
                playerTypeComboBox.setSelectedIndex(1);
            } else if (playerType.equals("Professional")) {
                playerTypeComboBox.setSelectedIndex(2);
            }

            // set Hobbies CheckBox
            sleepCheckBox.setSelected(false);   // you need to set false first
            for (int i = 0; i < hobbies.size(); i++) { // check each ArrayList
                if (hobbies.get(i).equals("Reading")) {
                    readCheckBox.setSelected(true);
                } else if (hobbies.get(i).equals("Browsing")) {
                    browsCheckBox.setSelected(true);
                } else if (hobbies.get(i).equals("Sleeping")) {
                    sleepCheckBox.setSelected(true);
                } else if (hobbies.get(i).equals("Traveling")) {
                    travelCheckBox.setSelected(true);
                }
            }

            //  set SportList
            sportList.clearSelection(); // clear selection first
            for (int i = 0; i < sports.size(); i++) {
                if (sports.get(i).equals("Badminton")) {
                    sportList.addSelectionInterval(0, 0);
                    // add selection      (<Fisrt selection>, <Last Selection>)
                } else if (sports.get(i).equals("Boxing")) {
                    sportList.addSelectionInterval(1, 1);
                } else if (sports.get(i).equals("Football")) {
                    sportList.addSelectionInterval(2, 2);
                } else if (sports.get(i).equals("Running")) {
                    sportList.addSelectionInterval(3, 3);
                }
            }

            // set Year In Sport Slider
            yearInSportSlider.setValue(year);

        } catch (NullPointerException nu) {
            JOptionPane.showMessageDialog(this, "Something in file is error");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fail to filling form");
        }
    }

    @Override
    protected void handleOpenFile() {
        if (yesFillMenuItem.isSelected()) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    objStreamReaderOfPlayer();
                    fillForm();
                    readFileFromObject();
                }
            });
        } else if (noFillMenuItem.isSelected()) {
            // check file is .txt or .obj
            if (file.getAbsolutePath().endsWith(".txt")) {
                super.handleOpenFile(); // read txt file
            } else if (file.getAbsolutePath().endsWith(".obj")) {
                objStreamReaderOfPlayer();  //read obj file
                readFileFromObject();   // show message from file
            }
        }
    }

    @Override
    protected void handleSaveFile() {   // check in fill menu is Yes or No
        if (yesFillMenuItem.isSelected()) {
            objStreamWriterOfPlayer();
        } else if (noFillMenuItem.isSelected()) {
            super.handleSaveFile();
        }
    }

    @Override
    protected void addMenus() {
        super.addMenus();

        menuBar.add(addFillMenu(), 2);
        setJMenuBar(menuBar);
    }

    public static void createAndShowGUI() {
        PlayerFormV14 msw = new PlayerFormV14("Player Form V14");
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
