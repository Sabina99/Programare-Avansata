package com.company;

import java.util.*;

/**
 * Player class implements Runnable Interface
 *
 */

public class Player implements Runnable {
    String name;
    Board board;
    ArrayList<Token> tokens = new ArrayList<Token>();
    boolean isGameOver;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        isGameOver = false;
    }

    /**
     * run method is giving to each player some random tokens
     * it is implemented with wait and notify
     *
     */
    @Override
    public void run() {
        while (!isGameOver) {

            board.stop();
            Token token = board.getToken();
            board.start();

            if (token == null)
                continue;
            tokens.add(token);
            System.out.println(name + " received " + token);
        }
    }

    public void stopGame() {
        isGameOver = true;
    }

    /**
     * determinateLargestArithmeticProgression determines the number of points for the players
     * the number of points is calculated based on the tokens that each player received
     * the number of points is representing how may numbers have a difference between them equal with sizek
     * determinateLargestArithmeticProgression returns the number of points(maxProgression)
     *
     * @param sizek
     * @return
     */
    public int determinateLargestArithmeticProgression(int sizek) {
        int i, count = 1, nextValue, j, maxProgression = 0;
        Token token1;
        for (i = 0; i < tokens.size(); i++) {
            boolean isInProgression = true;
            token1 = tokens.get(i);
            if (token1.getNumber() != null) {
                while (isInProgression) {
                    nextValue = token1.getNumber() + sizek;
                    token1 = deteremineNeighbour(nextValue, count);
                    if (token1 == null) {
                        count = 1;
                        isInProgression = false;
                    } else {
                        count++;
                        if (count >= maxProgression)
                            maxProgression = count;
                    }
                }
            }
        }
        return maxProgression;
    }

    /**
     * determineNeighbour determines if the player has a token with a difference of sizek from the value of the token given in determinateLargestArithmeticProgression (nextValue)
     *
     * @param nextValue
     * @param count
     * @return
     */
    private Token deteremineNeighbour(int nextValue, int count) {
        int j;
        Token token2, token3= null;
        boolean ok=false;

        for (j = 0; j < tokens.size(); j++) {
            token2 = tokens.get(j);
            if (token2.getNumber() != null) {
                if (nextValue == token2.getNumber()) {
                    count++;
                    token3 = token2;
                    ok = true;
                    break;
                }
            }
        }
        return token3;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", tokens=" + tokens +
                '}';
    }
}
