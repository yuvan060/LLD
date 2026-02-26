package TicTacToeGame.strategy;

import TicTacToeGame.ENUM.Symbol;

public interface WinningStrategy {
    public boolean isWon(Symbol[][] board, Symbol symbol);
}
