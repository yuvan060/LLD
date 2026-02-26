package TicTacToeGame.Player;

import TicTacToeGame.Data.Position;
import TicTacToeGame.ENUM.Symbol;
import TicTacToeGame.strategy.PlayerStrategy;

public abstract class Player {
    final String name;
    final Symbol symbol;
    PlayerStrategy playerStrategy;

    public Player(String name, Symbol symbol, PlayerStrategy playerStrategy) {
        this.name = name;
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public abstract Position play();

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}
