package boottapak.jakgrit.lab11;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

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

        if (readCheckBox.isSelected()) { // when readcheckbox is selected
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

    protected void fillForm() {
        try {
            nameTxtField.setText(name);
            nationTxtField.setText(nationality);
            birthTxtField.setText(dob);
            if (gender.equals("Male")) {
                maleButton.setSelected(true);
            } else if (gender.equals("Female")) {
                femaleButton.setSelected(true);
            }

            if (playerType.equals("Beginner")) {
                playerTypeComboBox.setSelectedIndex(0);
            } else if (playerType.equals("Amateur")) {
                playerTypeComboBox.setSelectedIndex(1);
            } else if (playerType.equals("Professional")) {
                playerTypeComboBox.setSelectedIndex(2);
            }

            sleepCheckBox.setSelected(false);
            for (int i = 0; i < hobbies.size(); i++) {
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

            sportList.clearSelection();
            for (int i = 0; i < sports.size(); i++) {
                if (sports.get(i).equals("Badminton")) {
                    sportList.addSelectionInterval(0, 0);
                } else if (sports.get(i).equals("Boxing")) {
                    sportList.addSelectionInterval(1, 1);
                } else if (sports.get(i).equals("Football")) {
                    sportList.addSelectionInterval(2, 2);
                } else if (sports.get(i).equals("Running")) {
                    sportList.addSelectionInterval(3, 3);
                }
            }

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
            objStreamReaderOfPlayer();
            fillForm();
        } else if (noFillMenuItem.isSelected()) {
            super.handleOpenFile();
        }
    }

    @Override
    protected void handleSaveFile() {
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
