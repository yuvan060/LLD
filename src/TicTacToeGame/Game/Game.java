package TicTacToeGame.Game;

import TicTacToeGame.Board.Board;
import TicTacToeGame.Data.Position;
import TicTacToeGame.ENUM.GameState;
import TicTacToeGame.Player.Player;
import TicTacToeGame.strategy.WinningStrategy;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Game {
    Board board;
    List<Player> players;
    int currentPlayer;
    GameState gameState;
    WinningStrategy winningStrategy;
    int moves;

    private static final Logger logger = Logger.getLogger(Game.class.getName());

    public Game(Board board, List<Player> players, int currentPlayer, WinningStrategy winningStrategy) {
        this.board = board;
        this.players = players;
        this.currentPlayer = currentPlayer;
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategy = winningStrategy;
        this.moves = 0;

        logger.log(Level.INFO, "Game initialized with " + players.size() + " players");
        for(int i = 0; i < players.size(); i++) {
            logger.log(Level.INFO, "Player " + i + ": " + players.get(i).getName() + " (Symbol: " + players.get(i).getSymbol() + ")");
        }
        logger.log(Level.INFO, "Starting player index: " + currentPlayer);
    }

    public void Play() {
        logger.log(Level.INFO, "Game started!");

        while (gameState == GameState.IN_PROGRESS) {
            Player current = players.get(currentPlayer);
            logger.log(Level.INFO, "Turn " + (moves + 1) + " - Current Player: " + current.getName());

            Position pos = current.play();

            if(board.isValidMove(pos)) {
               board.fillCell(pos, current.getSymbol());
               moves++;
               logger.log(Level.INFO, "Move accepted. Total moves: " + moves);
               printBoard();

               if(winningStrategy.isWon(board.board, current.getSymbol())){
                   gameState = GameState.WON;
                   logger.log(Level.INFO, "GAME WON! Winner: " + current.getName() + " (Symbol: " + current.getSymbol() + ")");
               }else {
                   nextPlayer();
                   logger.log(Level.INFO, "Move processed. Next player: " + players.get(currentPlayer).getName());
               }

               if(moves == board.board.length * board.board[0].length) {
                   gameState = GameState.DRAW;
                   logger.log(Level.INFO, "GAME ENDED IN DRAW - Board is full");
               }
            } else {
                logger.log(Level.WARNING, "Invalid move rejected. Player must try again.");
            }
        }

        logger.log(Level.INFO, "Game finished with state: " + gameState);
    }

    private void printBoard() {
        System.out.println("\n========== Board State ==========");
        for(int i = 0; i < board.board.length; i++) {
            for(int j = 0; j < board.board[0].length; j++) {
                System.out.print(" " + board.board[i][j].name().charAt(0) + " ");
                if(j < board.board[0].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < board.board.length - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println("=================================\n");
    }

    private void nextPlayer() {
        currentPlayer = (currentPlayer+1)%players.size();
    }

    public GameState getCurrentBoardStatus() {
        return gameState;
    }

    public Player getWinner() throws Exception{
        if(gameState == GameState.IN_PROGRESS) {
            logger.log(Level.WARNING, "Cannot get winner - Game is still in progress");
            throw new Exception("Game is still in Progress");
        }

        if(gameState == GameState.DRAW) {
            logger.log(Level.INFO, "Game ended in draw");
            throw new Exception("Game Ended in draw");
        }

        return players.get(currentPlayer);
    }
}
