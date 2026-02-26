package TicTacToeGame;

import TicTacToeGame.Board.Board;
import TicTacToeGame.ENUM.Symbol;
import TicTacToeGame.Game.Game;
import TicTacToeGame.Player.HumanPlayer;
import TicTacToeGame.Player.Player;
import TicTacToeGame.strategy.PlayerStrategy;
import TicTacToeGame.Player.HumanStrategy;
import TicTacToeGame.strategy.WinningStrategy;

import java.util.Arrays;

public class TicTacToeGame {
    /*
    The Game should have
    Game - has boards, players, currentPlayer, gameStatus; play(), toss(), nextPlayer(), currentStatus(), getWinner()
    Board - Symbol[][]; isValidMove(position), fillCell(position, symbol), isWinningMove(), isDrawState()
    HumanPlayer - Name, Symbol, playerStrategy are main entities.

    Enum SYMBOL - EMPTY, X, O
    ENUM State - IN_PROGRESS, WIN, DRAW
    Position - POJO class to hold row & col

    TicTacToeWinningStrategy - winningStrategy of board
    PlayerStrategy - player strategy to play the game(typically to get the input).

    TODO:
    Notification to the players about the state of the game.
     */

    public static void main(String args[]) {
        Board board = new Board(3,3);
        PlayerStrategy strategy = new HumanStrategy();
        Player yuvan = new HumanPlayer("Yuvan", Symbol.X, strategy);
        Player sankar = new HumanPlayer("Sankar", Symbol.O, strategy);

        WinningStrategy winningStrategy = new TicTacToeWinningStrategy();

        Game game = new Game(board, Arrays.asList(yuvan, sankar), 0, winningStrategy);
        game.Play();
    }
}
