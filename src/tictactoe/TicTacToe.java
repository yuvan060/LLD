package tictactoe;

public class TicTacToe {
    /*
    TicTacToe game had 3x3 boards,
    2 players can play the game,
    each player will be assigned a symbol,
     a player can place his symbol in empty cell
     if any diagonal of board or row or col have same symbols then the player owns that symbol is announced as winner
     if all the cells are filled & no winner, we have to announce the game as draw

     if a symbol is placed, we cannot override the cell
     once winner is announced, then we cannot enter value to any cell
     invalid cell position will throw an error

     BoardGame - Board, HumanPlayer 1&2, HumanPlayer Winner, GameContext context
               - play(), getWinner(),
     Board - contains 3x3 cells
           - placeSymbol(), isValidCell()
     Cell - Symbol as attribute
     Symbol as ENUM - EMPTY, X, O
     HumanPlayer - name, Symbol, PlayerStrategy
            - makeMove()
     GameContext - currentState
                  - nextState()
     PlayerStrategy -
                    - makeMove()
     */
}
