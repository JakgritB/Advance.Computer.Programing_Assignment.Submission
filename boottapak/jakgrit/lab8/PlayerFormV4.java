package boottapak.jakgrit.lab8;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

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
        sportList.setSelectedIndex(2);

        sportPanel = new JPanel();
        sportPanel.setLayout(new GridLayout(1, 2));
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

        yearInSportSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
        yearInSportSlider.setBorder(new EmptyBorder(0, 10, 0, 10));
        yearInSportSlider.setMinorTickSpacing(1);
        yearInSportSlider.setMajorTickSpacing(5);
        yearInSportSlider.setPaintTicks(true);
        yearInSportSlider.setPaintLabels(true);

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
