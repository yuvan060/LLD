package TicTacToeGame.Board;

import TicTacToeGame.Data.Position;
import TicTacToeGame.ENUM.Symbol;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Board {
    private static final Logger logger = Logger.getLogger(Board.class.getName());
    public Symbol[][] board;

    public Board(int row, int col) {
        board = new Symbol[row][col];
        initialiseBoard(board, row, col);
        logger.log(Level.INFO, "Board initialized with dimensions: " + row + "x" + col);
    }

    private void initialiseBoard(Symbol[][] board, int row, int col) {
        for(int i=0; i<row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = Symbol.EMPTY;
            }
        }
        logger.log(Level.INFO, "Board cells initialized to EMPTY");
    }

    public boolean isValidMove(Position position) {
        logger.log(Level.INFO, "Validating move at position: Row=" + position.getRow() + ", Col=" + position.getCol());

        if(position.getRow() < 0 || position.getCol() < 0 || position.getRow() >= board.length || position.getCol() >= board[0].length) {
            logger.log(Level.WARNING, "Invalid move: Position out of bounds");
            return false;
        }

        boolean isEmpty = board[position.getRow()][position.getCol()] == Symbol.EMPTY;
        if(!isEmpty) {
            logger.log(Level.WARNING, "Invalid move: Cell already occupied with " + board[position.getRow()][position.getCol()]);
        } else {
            logger.log(Level.INFO, "Valid move confirmed at Row=" + position.getRow() + ", Col=" + position.getCol());
        }
        return isEmpty;
    }

    public void fillCell(Position position, Symbol symbol) {
        board[position.getRow()][position.getCol()] = symbol;
        logger.log(Level.INFO, "Cell filled at Row=" + position.getRow() + ", Col=" + position.getCol() + " with symbol: " + symbol);
    }

}
