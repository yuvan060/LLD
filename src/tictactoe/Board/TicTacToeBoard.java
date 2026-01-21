package tictactoe.Board;

import tictactoe.BoardGame.BoardGame;
import tictactoe.BoardGame.WinningStrategy;
import tictactoe.Cell.Cell;
import tictactoe.Context.GameContext;
import tictactoe.Player.Player;
import tictactoe.Symbol.Symbol;

import java.util.List;

import static tictactoe.Context.GameContext.*;
import static tictactoe.Symbol.Symbol.EMPTY;

public class TicTacToeBoard implements BoardGame {

    Cell[][] board;
    List<Player> players;
    Integer currentPlayer;
    GameContext context;
    WinningStrategy winningStrategy;
    Player winner;

    public TicTacToeBoard(int row, int col, List<Player> players, WinningStrategy winningStrategy) {
        board = intializeBoard(row, col);
        this.players = players;
        this.context = IN_PROGRESS;
        currentPlayer = 0;
        this.winningStrategy = winningStrategy;
    }

    private Cell[][] intializeBoard(int row, int col) {
        Cell[][] board = new Cell[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                board[i][j] = new Cell();
            }
        }
        return board;
    }

    private boolean isWinningLine(Symbol symbol) {
        return winningStrategy.isWinningLine(board, symbol);
    }

    private boolean isBoardFull() {
        for(Cell[] row : board) {
            for(Cell cell : row) {
                if(cell.getSymbol() == EMPTY) return false;
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer+1) % players.size();
    }

    @Override
    public Player getWinner() {
        //handle DRAW or IN_PROGRESS STATE
        return winner;
    }

    @Override
    public boolean isValidMove(int[] move) {
        return move[0] >= 0 && move[0] < board.length && move[1] >= 0 && move[1] < board[0].length;
    }

    public void markCell(int[] move, Symbol symbol) throws Exception {
        if(board[move[0]][move[1]].getSymbol() != Symbol.EMPTY) {
            throw new Exception("Cell already occupied!");
        }
        board[move[0]][move[1]].setSymbol(symbol);
    }

    @Override
    public void play() throws Exception {
        System.out.println("Starting the game");
        while (context == IN_PROGRESS) {
            players.get(currentPlayer).makeMove(this);
            if(isWinningLine(players.get(currentPlayer).symbol)) {
                context = WON;
                winner = players.get(currentPlayer);
            } else if(isBoardFull()) {
                context = DRAW;
            }
            switchPlayer();
        }
    }

}
