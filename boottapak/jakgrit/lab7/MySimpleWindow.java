package boottapak.jakgrit.lab7;

import javax.swing.*;
import java.awt.*;

/*  This program is MySimpleWindow that extends JFrame. 
 *  
 *  the title is "My Simple Window"
 *  this program creating a simple window 
 *  and has Reset and Submit button
 * 
 *  Author: Jakgrit Boottapak
 *  ID: 663040111-9
 *  Sec: 1
 */

public class MySimpleWindow extends JFrame {
    protected JPanel buttonPanel;
    protected JPanel mainPanel = new JPanel();
    protected JButton resetButton, submitButton;

    // this is constructure to create JFrame and add title
    protected MySimpleWindow(String title) {
        super(title);
    }

    protected JPanel addResetAndSubmitBotton() {
        // create button
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");

        // create button panel and add button to panel
        buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        return buttonPanel;
    }

    protected void addComponents() {
        mainPanel.add(addResetAndSubmitBotton());

        mainPanel.setLayout(new FlowLayout(0, 60, 0));

        add(mainPanel); // Add the main panel to the JFrame
    }

    protected void setFrameFeatures() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
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
