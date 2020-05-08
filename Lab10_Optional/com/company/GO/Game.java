package com.company.GO;

/**
 * Game class creates the board and sends the information received from the server and sends it to the board to be checked
 */
public class Game {

    Board board = new Board();

    public Game() {
    }

    /**
     * addMove method sends the information received from the server and sends it to the board to be checked
     * it returns a string that says if the move is ok
     * @param row
     * @param column
     * @param player
     * @return
     */
    public String addMove(Integer row, Integer column, Player player){
        String aux = board.checkBoard(row, column, player);
        board.getBoard();
        return aux;
    }
}
