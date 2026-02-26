package SnakeAndFood.Snake;


import SnakeAndFood.Board.Board;
import SnakeAndFood.Player.Player;
import TicTacToeGame.ENUM.GameState;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Game {
    private static final Logger logger = Logger.getLogger(Game.class.getName());
    Player player;
    Snake snake;
    Board board;
    int currentScore;
    GameState gameState;

    public Game(Player player, Snake snake, Board board) {
        this.player = player;
        this.snake = snake;
        this.board = board;
        this.gameState = GameState.IN_PROGRESS;
        this.currentScore = 0;
    }

    public void play() {
        while(gameState == GameState.IN_PROGRESS) {
            logger.log(Level.INFO, "Player " + player.getName() + " is making a move...");
            int[] direction = player.move();
            logger.log(Level.INFO, "Player " + player.getName() + " moved in direction: [" + direction[0] + ", " + direction[1] + "]");

            int[] head = snake.getCurrentHead();

            if(board.willHitWall(direction[0]+head[0], direction[1] + head[1])
                    || snake.willHitBody(direction[0]+head[0], direction[1] + head[1])
            ) {
                logger.log(Level.INFO, "Game Over! Snake hit wall or its own body. Changing state to WON");
                gameState = GameState.WON;
            }

            boolean ateFood = false;

            if(board.hasFood() && board.willEatFood(direction[0]+head[0], direction[1] + head[1])) {
                currentScore++;
                logger.log(Level.INFO, "Snake ate food! Current Score: " + currentScore);
                board.nextFood();
                ateFood = true;
            } else {
                logger.log(Level.INFO, "Snake did not eat food");
            }

            snake.moveNextCell(direction, ateFood);

            if(!board.hasFood()) {
                logger.log(Level.INFO, "All food eaten! Changing state to WON");
                gameState = GameState.WON;
            }

            logger.log(Level.INFO, "Board state after move:");
            printBoard();
        }
        logger.log(Level.INFO, "Game ended. Final Score: " + currentScore);
        player.highestScore = Math.max(player.highestScore, currentScore);
    }

    private void printBoard() {
        System.out.println("========== BOARD ==========");
        boolean[][] boardState = new boolean[board.getN()][board.getM()];

        // Mark snake body
        for(int[] part : snake.snake) {
            boardState[part[0]][part[1]] = true;
        }

        // Print board
        for(int i = 0; i < board.getN(); i++) {
            for(int j = 0; j < board.getM(); j++) {
                if(boardState[i][j]) {
                    System.out.print("S ");  // Snake
                } else if(board.hasFood()) {
                    SnakeAndFood.food.Food food = board.getFoodItems().get(board.foodIndex);
                    if(i == food.getRow() && j == food.getCol()) {
                        System.out.print("F ");  // Food
                    } else {
                        System.out.print(". ");
                    }
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("===========================");
    }
}
