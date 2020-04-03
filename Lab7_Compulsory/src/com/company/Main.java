package com.company;
import java.util.ArrayList;
import java.util.Random;

/**
 * class Main generates all the available tokens ina random way, with a chance of 15% to generate nothing
 * Main also creates the board, players (in a number of two), and the game
 *
 * m is the maximum value of the tokens
 * sizek is given to calculate the arithmetic progression
 * tokens number is the number of the tokens
 *
 */
public class Main {
    private static int m = 40;
    private static int tokensNumber = 40;
    private static int sizek = 5;

    /**
     * generateRandomTokens generates a given number of tokens (tokensNumber), randomly, with a chance of 15% to generate a blank token
     *
     * @return
     */
    private static ArrayList<Token> generateRandomTokens(){
        ArrayList<Token> tokens = new ArrayList<Token>();
        for (int i = 1; i <= tokensNumber; i++){
            Token token = null;
            double blank = Math.random();
            if (blank < 0.15)
                token = new Token();
            else {
                int number = new Random().nextInt(m) + 1;
                token = new Token(number);
            }
            tokens.add(token);
        }
        System.out.println("The available tokens are: " + tokens);
        return tokens;
    }

    /**
     * main creates the board, players and game
     * @param args
     */
    public static void main(String[] args) {

        Board board = new Board(generateRandomTokens());
        Player player1, player2;
        player1 = new Player("Player one", board);
        player2 = new Player("Player two", board);

        Game game = new Game(player1, player2, board, sizek);
        game.go();
    }
}
