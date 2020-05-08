package com.company.RMI;

import com.company.GO.Game;
import com.company.GO.Player;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server class receives information from the client and creates the game, the player and adds moves in the tabel
 */
public class Server extends UnicastRemoteObject implements HelloService {

    private Integer row, column;
    Player player = new Player();
    Game game = new Game();

    public Server() throws RemoteException {
        super();
    }

    public void giveRow(Integer input) throws RemoteException {
        row = input;
    }

    public void giveColumn(Integer input) throws RemoteException {
        column = input;
    }

    /**
     * getResult method sends the information to the class Game to see if the move is available
     * returns a string that says if the submitted move is available
     * @return
     * @throws RemoteException
     */
    public String getResult() throws RemoteException {

        String move;
        move = game.addMove(row, column, player);
        if (move.equals("ok"))
            return "Move submitted";
        else
            if (move.equals("not ok"))
                return "nok";
            else
                return move;
    }

    public Integer getPlayer()  throws RemoteException{
        return player.checkPlayer();
    }

    public String processCommand(String command) throws RemoteException {

        return String.format("%s", command);
    }

    public String createGame() throws RemoteException {

        return "Game created successfully!";
    }

    public String createPlayer() throws RemoteException {

        return "Player created successfully!";
    }

}
