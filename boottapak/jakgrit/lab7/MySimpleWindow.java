package boottapak.jakgrit.lab7;

import javax.swing.*;
import java.awt.*;

public class MySimpleWindow extends JFrame {
    protected JPanel buttonPanel;
    protected JPanel mainPanel = new JPanel();
    protected JButton resetButton, submitButton;

    protected MySimpleWindow(String title) {
        super(title);
    }

    protected void addResetAndSubmitBotton() {
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");

        buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        // you need to add "buttonPanel" when call this method
    }

    protected void addComponents() {
        addResetAndSubmitBotton();
        mainPanel.add(buttonPanel);
        mainPanel.setLayout(new FlowLayout(0, 60, 0));

        add(mainPanel);
    }

    protected void setFrameFeatures() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
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
