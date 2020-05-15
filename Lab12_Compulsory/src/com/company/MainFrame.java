package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * MainFrame of JFrame type is the application class
 */
public class MainFrame extends JFrame {
    private DesignPanel designPanel;
    private ControlPanel controlPanel;

    public MainFrame() {
        init();
    }

    /**
     * init method creates the window for UI and adds the ControlPanel and the DesignPanel to the window
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        designPanel = new DesignPanel(this);
        controlPanel = new ControlPanel(this);

        add(controlPanel, BorderLayout.NORTH);
        add(designPanel, BorderLayout.CENTER);
        pack();
    }

    public DesignPanel getDesignPanel() {
        return designPanel;
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
