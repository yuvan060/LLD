package tictactoe.Player;

import tictactoe.Board.TicTacToeBoard;
import tictactoe.Context.GameContext;
import tictactoe.Symbol.Symbol;
import tictactoe.TicTacToe;

import java.util.Random;

public class Player {

    String name;
    public Symbol symbol;
    PlayerStrategy playerStrategy;

    public Player(String name, Symbol symbol, PlayerStrategy playerStrategy) {
        this.name = name;
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public void makeMove(TicTacToeBoard board) throws Exception {
        playerStrategy.makeMove(board, symbol);
    }
}
