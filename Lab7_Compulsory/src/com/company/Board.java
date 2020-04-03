package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Board class locks and unlocks the threads and generates tokens for the given array
 */
public class Board {
    ArrayList<Token> tokens;
    boolean available = true;

    public Board(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    /**
     * getToken returns a token from the previously random generated array or returns null if the array is empty
     *
     * @return
     */
    public synchronized Token getToken() {

        if (isEmpty())
            return null;
        int randomPosition = new Random().nextInt(tokens.size());
        Token token = tokens.get(randomPosition);
        tokens.remove(token);
        return token;
    }

    /**
     * stop method locks the thread
     */
    public synchronized void stop() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.available = false;
        notifyAll();
    }

    /**
     * start method unlocks the thread
     */
    public synchronized void start() {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.available = true;
        notifyAll();
    }

    /**
     * isEmpty returns true or false depending if the array of tokens is empty
     * @return
     */
    public boolean isEmpty() {
        return tokens.isEmpty();
    }
}
