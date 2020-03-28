package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * The class ConfigurationPanel creates all of the components necessary: mainframe, panels and canvas
 */

class ConfigurationPanel extends JFrame implements MouseListener, MouseMotionListener {
    private JTextField tf1, tf2, tf3;
    JLabel l, ll, lll, pan;
    JButton b1, b2, b3, b4;

    public JTextField getTf1() {
        return tf1;
    }

    public JTextField getTf2() {
        return tf2;
    }

    public JTextField getTf3() {
        return tf3;
    }

    /**
     * createLabel creates a label with the specified parameters
     * returns the created label
     *
     * @param name
     * @param val1
     * @param val2
     * @param val3
     * @param val4
     * @return
     */

    private JLabel createLabel(String name, int val1, int val2, int val3, int val4) {
        JLabel nameL = new JLabel(name);
        nameL.setBounds(val1, val2, val3, val4);
        return nameL;
    }

    /**
     * createTextField creates a text field with the specified parameters
     * returns it
     *
     * @param name
     * @param val1
     * @param val2
     * @param val3
     * @param val4
     * @return
     */
    private JTextField createTextField(String name, int val1, int val2, int val3, int val4) {
        JTextField nameL = new JTextField(name);
        nameL.setBounds(val1, val2, val3, val4);
        return nameL;
    }

    /**
     * createButton creates a button with the specified parameters
     * returns it
     *
     * @param name
     * @param val1
     * @param val2
     * @param val3
     * @param val4
     * @return
     */
    private JButton createButton(String name, int val1, int val2, int val3, int val4) {
        JButton nameL = new JButton(name);
        nameL.setBounds(val1, val2, val3, val4);
        return nameL;
    }

    /**
     * createPanel creates all the labels and text fields
     */
    private void createPanel() {
        pan = createLabel("Panel", 290, 30, 50, 20);
        tf1 = createTextField("10", 70, 60, 100, 20);
        l = createLabel("sides: ", 20, 60, 50, 20);
        tf2 = createTextField("20", 250, 60, 100, 20);
        ll = createLabel("size: ", 200, 60, 50, 20);
        tf1 = createTextField("3", 430, 60, 100, 20);
        lll = createLabel("stroke: ", 300, 60, 50, 20);
    }

    /**
     * createControls creates all the buttons
     */
    private void createControls() {
        b1 = createButton("Load", 75, 525, 95, 30);
        b2 = createButton("Exit", 175, 525, 95, 30);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    System.exit(0);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        b3 = createButton("Reset", 275, 525, 95, 30);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setBackground(Color.lightGray);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        b4 = createButton("Save", 375, 525, 95, 30);
    }

    /**
     * ConfigurationPanel sets the window size, adds all the necessary parts and adds a mouse listener
     */
    ConfigurationPanel() {
        createPanel();
        createControls();

        add(b2);
        add(b3);
        add(b1);
        add(b4);
        add(ll);
        add(tf2);
        add(pan);

        addMouseListener(this);
        setSize(600, 600);
        setLayout(null);
        setVisible(true);
    }


    public void mouseClicked(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    /**
     * mousePressed creates when the mouse is pressed a circle with the given size and a random color
     *
     * @param e
     */
    public void mousePressed(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(Color.lightGray);
        g.drawRect(0, 0, 600, 600);
        Random rand = new Random();
        float ro = rand.nextFloat();
        float go = rand.nextFloat();
        float bo = rand.nextFloat();
        Color randomColor = new Color(ro, go, bo);
        g.setColor(randomColor);

        int x, y;
        x = e.getX();
        y = e.getY();
        System.out.print(x + " " + y);
        JTextField nou;
        nou = tf2;
        String size = nou.getText();
        int resultSize = Integer.parseInt(size);
        g.fillOval(x, y, resultSize, resultSize);

    }

}
