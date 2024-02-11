package boottapak.jakgrit.lab8;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

/*  This program is PlayerFormV4 that extends PlayerFormV3. 
 *  
 *  the title is "Player Form V4"
 *  this program creating a window has components:
 *  - componets is similar to PlayerFormV3
 *  
 *  but this program has add new components:
 *  - [Hobbies Checkbox] that has:
 *      - Reading
 *      - Browsing
 *      - Sleeping
 *      - Traveling
 *  - [Sport List] that has:
 *      - Badminton
 *      - Boxing
 *      - Football
 *      - Running
 *  - [Year of experience in this sport] that has:
 *      - Min year: 0
 *      - Max years: 20 
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class PlayerFormV4 extends PlayerFormV3 {
    protected JLabel hobbiesLabel, sportLabel, yearInSportLabel;
    protected JCheckBox readCheckBox, browsCheckBox, sleepCheckBox, travelCheckBox;
    protected JPanel hobbiesLabelPanel, hobbiesCheckBoxPanel, hobbiesPanel;
    protected JPanel sportPanel, yearInSportPanel, yearInSportLabelPanel;
    protected JList<String> sportList;
    protected String[] sport = { "Badminton", "Boxing", "Football", "Running" };
    protected JSlider yearInSportSlider;

    protected PlayerFormV4(String title) {
        super(title);
    }

    protected JPanel addHobbies() {
        hobbiesLabelPanel = new JPanel();
        hobbiesLabelPanel.add(hobbiesLabel = new JLabel("Hobbies:"));
        hobbiesLabelPanel.setLayout(new GridLayout(1, 2));

        hobbiesCheckBoxPanel = new JPanel();
        hobbiesCheckBoxPanel.add(readCheckBox = new JCheckBox("Reading"));
        hobbiesCheckBoxPanel.add(browsCheckBox = new JCheckBox("Browsing"));
        hobbiesCheckBoxPanel.add(sleepCheckBox = new JCheckBox("Sleeping", true));
        hobbiesCheckBoxPanel.add(travelCheckBox = new JCheckBox("Traveling"));

        hobbiesPanel = new JPanel();
        hobbiesPanel.setLayout(new BorderLayout());
        hobbiesPanel.add(hobbiesLabelPanel, BorderLayout.PAGE_START);
        hobbiesPanel.add(hobbiesCheckBoxPanel, BorderLayout.CENTER);

        return hobbiesPanel;
    }

    protected JPanel addSportList() {
        sportLabel = new JLabel("Sport :");
        sportList = new JList<>(sport);
        sportList.setSelectedIndex(2); // Selected item is in index 2

        sportPanel = new JPanel();
        sportPanel.setLayout(new GridLayout(1, 2)); // row:1, cols:2
        sportPanel.add(sportLabel);
        sportPanel.add(sportList);

        return sportPanel;
    }

    protected JPanel addYearInSport() {
        yearInSportLabel = new JLabel("Year of experience in this sport:");

        yearInSportLabelPanel = new JPanel();
        yearInSportLabelPanel.setLayout(new GridLayout(1, 2));
        yearInSportLabelPanel.add(yearInSportLabel);
        yearInSportLabelPanel.setBorder(new EmptyBorder(5, 0, 10, 0));
        // new EmptyBorder(top:5, left:0, bottom:10, right:0)

        yearInSportSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
        // (JSlider.HORIZONTAL, minValue:0, maxValue:20, selectedValue:0)
        yearInSportSlider.setBorder(new EmptyBorder(0, 10, 0, 10));
        yearInSportSlider.setMinorTickSpacing(1); // small lines 1 space apart
        yearInSportSlider.setMajorTickSpacing(5); // big lines 5 space apart
        yearInSportSlider.setPaintTicks(true); // show lines
        yearInSportSlider.setPaintLabels(true); // show number

        yearInSportPanel = new JPanel();
        yearInSportPanel.setLayout(new BoxLayout(yearInSportPanel, BoxLayout.PAGE_AXIS));
        yearInSportPanel.add(yearInSportLabelPanel);
        yearInSportPanel.add(yearInSportSlider);

        return yearInSportPanel;
    }

    @Override
    protected void addComponents() {
        super.addComponents();

        mainPanel.add(addHobbies(), 2);
        mainPanel.add(addSportList(), 3);
        mainPanel.add(addYearInSport(), 4);
    }

    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");
        msw.addMenus();
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
