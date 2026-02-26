package TicTacToeGame.Player;

import TicTacToeGame.Data.Position;
import TicTacToeGame.strategy.PlayerStrategy;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class HumanStrategy implements PlayerStrategy {

    private static final Logger logger = Logger.getLogger(HumanStrategy.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public Position play(){
       logger.log(Level.INFO, "Waiting for player input (row and column)...");
       int x = scanner.nextInt();
       int y = scanner.nextInt();
       logger.log(Level.INFO, "Player input received: Row=" + x + ", Column=" + y);
       return new Position(x, y);
    }
}
