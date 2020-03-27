package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class ConfigurationPanel extends JFrame implements MouseListener, MouseMotionListener
{
    public JTextField tf1, tf2, tf3; JLabel l, ll, lll, pan; JButton b1, b2, b3, b4;

    public JTextField getTf1() {
        return tf1;
    }

    public JTextField getTf2() {
        return tf2;
    }

    public JTextField getTf3() {
        return tf3;
    }

    ConfigurationPanel(){
        pan=new JLabel("Panel");
        pan.setBounds(290,30, 50,20);

        tf1=new JTextField("10");
        tf1.setBounds(70,60, 100,20);
        l=new JLabel("size: ");
        l.setBounds(20,60, 50,20);

        tf2=new JTextField("20");
        tf2.setBounds(250,60, 100,20);
        ll=new JLabel("size: ");
        ll.setBounds(200,60, 50,20);

        tf3=new JTextField("3");
        tf3.setBounds(430,60, 100,20);
        lll=new JLabel("stroke: ");
        lll.setBounds(380,60, 50,20);

        b1=new JButton("Load");
        b1.setBounds(75,525,95,30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        b2=new JButton("Exit");
        b2.setBounds(175,525,95,30);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {  System.exit(0);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        b3=new JButton("Reset");
        b3.setBounds(275,525,95,30);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setBackground(Color.lightGray);
                }
                catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        b4=new JButton("Save");
        b4.setBounds(375,525,95,30);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        add(b2);add(b3);add(ll);add(tf2);add(pan);
        addMouseListener(this);



        setSize(600,600);
        setLayout(null);
        setVisible(true);
    }


    public void mouseClicked(MouseEvent e)
    {

        
        Graphics g = getGraphics();
        g.setColor(Color.lightGray);
        g.drawRect(0, 0, 600, 600);
        Random rand=new Random();
        float ro = rand.nextFloat();
        float go = rand.nextFloat();
        float bo = rand.nextFloat();
        Color randomColor = new Color(ro, go, bo);
        g.setColor(randomColor);

        // get X and y position
        int x, y;
        x = e.getX();
        y = e.getY();  System.out.print(x + " " + y);
        JTextField nou;
        nou = tf2;
        String size = nou.getText();
        int resultSize = Integer.parseInt(size);
        g.fillOval(x, y, resultSize, resultSize);
    }

    public void mouseMoved(MouseEvent e)
    {
    }

    public void mouseDragged(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mousePressed(MouseEvent e)
    {
    }

}
