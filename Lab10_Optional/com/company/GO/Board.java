package com.company.GO;

import java.util.Arrays;

/**
 * Board class checks if the move sent by the user is available and checks the updated board to be checked if the game ended
 */
public class Board {

    private int board[][] =  { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    Board () {
    }

    /**
     * checkBoard method checks if the move sent by the user is available and sends the updated board to be checked if the game ended
     * @param row
     * @param column
     * @param player
     * @return
     */
    public String checkBoard(Integer row, Integer column, Player player) {
        if (board[row-1][column-1] == 0) {
            String getWinner = updateBoard(row-1, column-1, player);
            if (getWinner.equals("no-winner")) {
                player.changePlayer();
                return "ok";
            }
            else {
                player.changePlayer();
                return getWinner;
            }
        }
        else {

            return "not ok";
        }

    }

    /**
     * updateBoard updates the board and sends the board to be checked if no one has won
     * @param row
     * @param column
     * @param player
     * @return
     */
    private String updateBoard(Integer row, Integer column, Player player) {
        board[row][column] = player.playerNo;

        return checkWinner(player);
    }

    /**
     * getBoard method shows the table equivalent to the board in terminal
     */
    public void getBoard() {
        for (int[] row : board)
            System.out.println(Arrays.toString(row));
        System.out.println("\n\n");
    }

    /**
     * checkWinner method checks the board and returns "no-winner" if no player won and returns the player that won if a player won
     * @param player
     * @return
     */
    private String checkWinner(Player player){
        int i, j;
        for (i=0; i<15; i++)
            for (j=0; j<15; j++) {
                if (i <= 10)
                   if (board[i][j] == player.playerNo && board[i + 1][j] == player.playerNo && board[i + 2][j] == player.playerNo && board[i + 3][j] == player.playerNo && board[i + 4][j] == player.playerNo){

                        return String.format("The winner is player %d", player.checkPlayer());
                    }
                if (j <= 10)
                    if (board[i][j] == player.playerNo && board[i][j + 1] == player.playerNo && board[i][j + 2] == player.playerNo && board[i][j + 3] == player.playerNo && board[i][j + 4] == player.playerNo) {

                        return String.format("The winner is player %d", player.playerNo);
                    }

                if (j <= 10 && i<=10)
                    if (board[i][j] == player.playerNo && board[i + 1][j + 1] == player.playerNo && board[i + 2][j + 2] == player.playerNo && board[i + 3][j + 3] == player.playerNo && board[i + 4][j + 4] == player.playerNo) {

                        return String.format("The winner is player %d", player.playerNo);
                    }
            }
        return "no-winner";
    }
}
