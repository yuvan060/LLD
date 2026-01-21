package tictactoe.Player;

import tictactoe.Board.TicTacToeBoard;
import tictactoe.Symbol.Symbol;

public interface PlayerStrategy {
    void makeMove(TicTacToeBoard board, Symbol symbol) throws Exception;
}
