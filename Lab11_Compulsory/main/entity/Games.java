package main.entity;

import main.entity.Players;

import java.util.List;

/**
 * Games class has auto-generated setters and getters
 */
public class Games {
    private int gameID;
    private List<Players> players;

    public Games(int gameID, List<Players> players) {
        this.gameID = gameID;
        this.players = players;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }


}
