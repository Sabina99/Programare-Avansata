package com.example.lab11;
import java.util.List;

/**
 * Game class has auto-generated setters and getters
 */
public class Game {
    private int Id;
    private List<Players> players;

    public Game(int gameID, List<Players> players) {
        this.Id = gameID;
        this.players = players;
    }

    public int getId() {
        return Id;
    }

    public void setId(int gameID) {
        this.Id = gameID;
    }

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }


}