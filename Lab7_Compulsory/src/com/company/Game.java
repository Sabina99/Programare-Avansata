package com.company;
import java.util.concurrent.TimeUnit;

/**
 * Game class begins the game and creates a thread for each player
 */

public class Game {
    Player player1;
    Player player2;
    Board board;
    int sizek;

    public Game(Player player1, Player player2, Board board, int sizek) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.sizek = sizek;
    }

    /**
     * go method creates the threads, begins and stops the game and shows how many points each player has
     */
    public void go() {
        new Thread(player1).start();
        new Thread(player2).start();
        while (!board.isEmpty()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        player1.stopGame();
        player2.stopGame();

        System.out.println(player1.name + " has " + player1.determinateLargestArithmeticProgression(sizek) +" points.");
        System.out.println(player2.name + " has " +player2.determinateLargestArithmeticProgression(sizek) + " points.");

    }


}