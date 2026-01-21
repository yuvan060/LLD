package tictactoe.BoardGame;

import tictactoe.Cell.Cell;
import tictactoe.Symbol.Symbol;

public interface WinningStrategy {
    boolean isWinningLine(Cell[][] board, Symbol symbol);
}
