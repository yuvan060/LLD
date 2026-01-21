package tictactoe.Player;

import tictactoe.Board.TicTacToeBoard;
import tictactoe.Symbol.Symbol;

import java.util.Scanner;

public class HumanStrategy implements PlayerStrategy{

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void makeMove(TicTacToeBoard board, Symbol symbol) throws Exception {
       //scan input from the user
       int x = scanner.nextInt();
       int y = scanner.nextInt();

        int[] move = new int[]{x,y};

        if(!board.isValidMove(move)) {
            throw new Exception("Illegal Position move");
        }

        board.markCell(move, symbol);
    }
}
