package TicTacToeGame.Player;

import TicTacToeGame.Data.Position;
import TicTacToeGame.ENUM.Symbol;
import TicTacToeGame.strategy.PlayerStrategy;
import java.util.logging.Logger;
import java.util.logging.Level;

public class HumanPlayer extends Player {

    private static final Logger logger = Logger.getLogger(HumanPlayer.class.getName());

    public HumanPlayer(String name, Symbol symbol, PlayerStrategy playerStrategy) {
        super(name, symbol, playerStrategy);
    }

    @Override
    public Position play() {
        logger.log(Level.INFO, "Player: " + name + " (Symbol: " + symbol + ") taking turn...");
        Position position = playerStrategy.play();
        logger.log(Level.INFO, "Player: " + name + " made a move at Row=" + position.getRow() + ", Col=" + position.getCol());
        return position;
    }
}
