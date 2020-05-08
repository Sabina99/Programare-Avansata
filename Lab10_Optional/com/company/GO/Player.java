package com.company.GO;

/**
 * Player class changes the player and says who's turn is
 */
public class Player {
    public Player() {
    }

    Integer playerNo = 1;

    public Integer checkPlayer() {
        return playerNo;
    }

    /**
     * changePlayer method changes the player
     */
    public void changePlayer() {
        if (playerNo == 1)
            playerNo = 2;
        else
            playerNo = 1;
    }
}
