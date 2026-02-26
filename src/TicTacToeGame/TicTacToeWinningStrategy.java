package TicTacToeGame;

import TicTacToeGame.ENUM.GameState;
import TicTacToeGame.ENUM.Symbol;
import TicTacToeGame.strategy.WinningStrategy;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TicTacToeWinningStrategy implements WinningStrategy {

    private static final Logger logger = Logger.getLogger(TicTacToeWinningStrategy.class.getName());

    @Override
    public boolean isWon(Symbol[][] board, Symbol symbol) {
        logger.log(Level.INFO, "Checking win condition for symbol: " + symbol);

        for(int j=0; j<board.length; j++) {
            Symbol[] row = board[j];
            boolean rowCheck = true;
            for (int i = 0; i < board[0].length; i++) {
                if(row[i] != symbol) {
                    rowCheck = false;
                }
            }
            if(rowCheck) {
                return true;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            boolean colCheck = true;
            for(int j=0; j<board.length; j++) {
                if(board[j][i] != symbol) {
                    colCheck = false;
                }
            }
            if(colCheck) return true;
        }

        //same for diagonal check
        boolean diagonalCheck = true;
        for(int i=0, j=0; i<board.length && j<board[0].length; i++,j++) {
            if(symbol != board[i][j]) {
                diagonalCheck = false;
            }
        }

        for(int i=0, j=board[0].length-1; i<board.length && j>=0; i++,j--) {
            if(symbol != board[i][j]) {
                diagonalCheck = false;
            }
        }

//        logger.log(Level.INFO, "Win found for symbol: " + symbol);
        return diagonalCheck;
    }
}


