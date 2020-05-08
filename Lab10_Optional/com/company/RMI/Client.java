package com.company.RMI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * The class Client receives user's commands and sends them to the server. It also creates the interface for the user
 *
 */

public class Client extends JFrame {

    private Integer submittedRow, submittedColumn;

    private JTextField tf1, tf2, tf3;
    JLabel l, ll, lll;
    JButton b1, b2;

    /**
     * drwPanel method creates the buttons and the textfields and shows in the created window
     *
     * @param service
     */
    private void drawPanel(HelloService service) {
        createPanel();
        createControls(service);

        add(b1);
        add(b2);
        add(tf1);
        add(tf2);
        add(ll);
        add(l);

        setSize(400, 600);
        setLayout(null);
        setVisible(true);
    }

    /**
     * createLabel method creates a label with the name labelName and the given parameters
     *
     * @param labelName
     * @param x
     * @param y
     * @param width
     * @param heigth
     * @return
     */
    private JLabel createLabel(String labelName, int x, int y, int width, int heigth) {
        JLabel nameL = new JLabel(labelName);
        nameL.setBounds(x, y, width, heigth);
        return nameL;
    }

    /**
     * createTextField method creates a TextField with the given parameters
     *
     * @param x
     * @param y
     * @param width
     * @param heigth
     * @return
     */
    private JTextField createTextField(int x, int y, int width, int heigth) {
        JTextField nameL = new JTextField();
        nameL.setBounds(x, y, width, heigth);
        return nameL;
    }

    /**
     * createButton method creates a button with the name buttonName and the given parameters
     *
     * @param buttonName
     * @param x
     * @param y
     * @param width
     * @param heigth
     * @return
     */
    private JButton createButton(String buttonName, int x, int y, int width, int heigth) {
        JButton nameL = new JButton(buttonName);
        nameL.setBounds(x, y, width, heigth);
        return nameL;
    }

    /**
     * createPanel method calls the methods for text fields and labels
     *
     */
    private void createPanel() {
        tf1 = createTextField(135, 50, 50, 20);
        l = createLabel("Row: ", 75, 50, 50, 20);
        tf2 = createTextField(265, 50, 50, 20);
        ll = createLabel("Column: ", 195, 50, 50, 20);
    }

    /**
     * showWinner method shows the winner at the end of the game
     *
     * @param playerNumber
     * @param g
     */
    private void showWinner(int playerNumber, Graphics g) {
        tf1.setVisible(false);
        tf2.setVisible(false);
        l.setVisible(false);
        ll.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        g.setColor(Color.white);
        g.fillRect(0, 0, 400, 600);

        if (playerNumber == 1)
            lll = createLabel("BLACK WINS!!!", 150, 50, 200, 20);
        else
            lll = createLabel("RED WINS!!!", 150, 50, 200, 20);
        add(lll);
    }

    /**
     *  createPanel method calls the methods for buttons and adds an action listener for when the buttons are pressed
     * @param service
     */
    private void createControls(HelloService service) {

        b1 = createButton("Submit", 100, 100, 95, 20);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Graphics g = getGraphics();
                    g.setColor(Color.black);
                    makeMove(g, service);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        b2 = createButton("Exit", 200, 100, 95, 20);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    System.exit(0);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

    }

    /**
     * makeMove method takes the information from the textfield and sends it to be verified if it is a valid move
     * it also draws the board
     * @param g
     * @param service
     * @throws RemoteException
     */
    public void makeMove(Graphics g, HelloService service) throws RemoteException {
        int i, j;
        for (i = 20; i <= 356; i = i + 24)
            for (j = 200; j < 536; j = j + 24)
                g.drawRect(i, j, 24, 24);
        String s1 = tf1.getText();
        String s2 = tf2.getText();
        submittedRow = Integer.parseInt(s1);
        submittedColumn = Integer.parseInt(s2);
        submitMoveInWindow(g, service);

    }

    /**
     * submitMoveInWindow sends the information given by the user to another method (handleMove)
     * it is valid it draws the pieces on the board
     * @param g
     * @param service
     * @throws RemoteException
     */
    private void submitMoveInWindow(Graphics g, HelloService service) throws RemoteException {
        String isOk = handleMove(service);
        System.out.println(isOk) ;
        if (isOk.equals("ok-move")) {
            System.out.println("Move done");
            if (service.getPlayer() == 1)
                g.setColor(Color.black);
            else
                g.setColor(Color.red);
            g.fillOval(20 + (submittedRow - 1) * 24 + 2, 200 + (submittedColumn - 1) * 24 + 2, 20, 20);
        } else {
            if (isOk.equals("nok")) {
                System.out.println("Move not available");
            }
            if (!isOk.equals("nok") && !isOk.equals("ok-move")) {
                int playerNumber = service.getPlayer();
                if (playerNumber == 1)
                    g.setColor(Color.black);
                else
                    g.setColor(Color.red);
                g.fillOval(20 + (submittedRow - 1) * 24 + 2, 200 + (submittedColumn - 1) * 24 + 2, 20, 20);
                showWinner(playerNumber, g);
                System.out.println(isOk);
            }
        }

}

    /**
     * main communicates with the user from the terminal, the user must create a game and join it to be able to submit a move
     * @param args
     * @throws RemoteException
     * @throws NotBoundException
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        HelloService service = (HelloService) Naming.lookup("rmi://localhost:5099/hello");
        int ok = 1;
        String resultToCommand = getCommand(service);
        if (resultToCommand.equals("create game")) {
            handleGame(service);
            resultToCommand = getCommand(service);
            if (resultToCommand.equals("join game")) {
                handlePlayer(service);
                Client client = new Client();
                client.drawPanel(service);
            }
        }
    }

    /**
     * handleMove sends the infotrmation to the server to check if the move is valid
     * returns a string that says if it is valid
     *
     * @param service
     * @return
     * @throws RemoteException
     */
    private String handleMove(HelloService service) throws RemoteException {

        service.giveRow(submittedColumn);
        service.giveColumn(submittedRow);

        String result = service.getResult();
        if (result.equals("Move submitted"))
            return "ok-move";
        else if (result.equals("not ok"))
            return "nok";
        else
            return result;
    }

    /**
     * handleGame method creates a game
     * @param service
     * @throws RemoteException
     */
    private static void handleGame(HelloService service) throws RemoteException {

        System.out.println(service.createGame());

    }

    /**
     * handlePlayer method creates a player
     * @param service
     * @throws RemoteException
     */
    private static void handlePlayer(HelloService service) throws RemoteException {

        System.out.println(service.createPlayer());

    }

    private static String getCommand(HelloService service) throws RemoteException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Give command: ");
        String command = keyboard.nextLine();

        return service.processCommand(command);
    }
}
