package tictactoe.BoardGame;

import tictactoe.Player.Player;

public interface BoardGame {
    boolean isValidMove(int[] move);
    void play() throws Exception;
    Player getWinner();
}
