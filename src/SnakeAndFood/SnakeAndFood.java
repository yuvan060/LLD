package SnakeAndFood;

public class SnakeAndFood {
    /*
    We have to design a snake and food game where,
    there is N x M grids will be there, & initially a snake with 0 length
    the user have to navigate the snake in four directions, while the snake is moving
    it moves one unit in a direction, then whole snake moves -> which means
    add one new head to the current direction then remove the tail, it will make the snake movement stimulation.
    if the head reaches any cell that currently has food in it, then increase the current size + 1 in its moving direction.

    the food will be in random position once it catches the food. we do have two types of food, normal food & bonus food.

    game over strategy - when snake head hit the wall or hit its own body, we can end the game.

    snake - body(deque<Pair>), Map<i_j, Pair> toCheck its body position, sizeOfSnake, ; isValidMove(),move(Pair position);
    board or Grid - N X M cells, List<Foods> foodPositions; generateNextFood(), isWall()
    Food - Normal Food & BonusFood - row, col, points
    Game is an entity - Player, Snake, Board, currentScore, gameState; start
    player - name, HighestScore, movementStrategy; move

    HumanPlayerStrategy - makeMove()
    SnakeMovementStrategy - move()
    GameState - IN_PROGRESS, END

     */
}
