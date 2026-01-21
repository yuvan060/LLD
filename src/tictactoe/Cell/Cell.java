package tictactoe.Cell;

import tictactoe.Player.Player;
import tictactoe.Symbol.Symbol;

public class Cell {
    Symbol symbol;
    public Cell() {
        this.symbol = Symbol.EMPTY;
    }
    public void setSymbol(Symbol symbol) throws Exception {
        this.symbol = symbol;
    }
    public Symbol getSymbol() {
        return symbol;
    }
}
