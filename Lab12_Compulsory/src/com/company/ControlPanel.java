package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * ControlPanel class of JPanel type creates the control panel with the necessary buttons and textfield
 */
public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private JLabel label = new JLabel("    Give Swing class:");
    private JTextField textField = new JTextField();
    private JButton exitButton = new JButton("Exit");
    private JButton createButton = new JButton("Create");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * init method adds the buttons, label and textfield to the panel, it also adds action listeners to the buttons
     */
    private void init() {
        setLayout(new GridLayout(1, 4));
        exitButton.addActionListener(this::exit);
        createButton.addActionListener(event -> {
            try {
                create(event);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        add(label);
        add(textField);
        add(createButton);
        add(exitButton);
    }

    /**
     * exit method is the action listener for the exit button
     *
     * @param event
     */
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    /**
     * create method is the action listener to the button responsible for receiving the data from the textfield and sending it to
     * the design panel
     *
     * @param event
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    private void create(ActionEvent event) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String component = textField.getText();
        frame.getDesignPanel().drawComponent(component);
    }
}