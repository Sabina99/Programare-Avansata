package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * DesignPanel class receives the class from ControlPanel and creates a design with the absolute positioning of the given components
 */
public class DesignPanel extends JPanel {
    private final MainFrame frame;
    private BufferedImage image;
    private Graphics2D graphics;
    private Integer xComponent = 30;
    private Integer yComponent = 30;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * init method creates the panel necessary for showing the components
     */
    private void init() {
        setPreferredSize(new Dimension(800, 600));
        setBorder(BorderFactory.createEtchedBorder());
    }

    /**
     * drawComponent method receives the class name from the control panel, loads dynamically the class and creates and adds an
     * instance of the component to the DesignPanel, with absolute positioning
     *
     * @param component
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void drawComponent(String component) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class cls = Class.forName(component);
        JComponent obj = (JComponent) cls.newInstance();
        Container pane = frame.getContentPane();


        pane.setLayout(null);
        Insets insets = pane.getInsets();
        Dimension size = obj.getPreferredSize();

        pane.add(obj);
        obj.setBounds(xComponent + insets.left, yComponent + insets.top,
                size.width, size.height);

        if (xComponent > 750) {
            xComponent = 30;
        } else if (yComponent > 550) {
            yComponent = 30;
            xComponent += 50;
        } else
            yComponent += 50;
    }
}