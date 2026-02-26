package SnakeAndFood;

import SnakeAndFood.Snake.Game;
import SnakeAndFood.Snake.Snake;
import SnakeAndFood.Board.Board;
import SnakeAndFood.Player.Player;
import SnakeAndFood.Player.HumanMovementStrategy;
import SnakeAndFood.food.Food;
import SnakeAndFood.food.NormalFood;
import SnakeAndFood.food.BonusFood;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class SnakeGame {
    private static final Logger logger = Logger.getLogger(SnakeGame.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "================ Starting Snake and Food Game ================");

        // Game configuration
        int boardRows = 10;
        int boardCols = 10;
        logger.log(Level.INFO, "Game Configuration - Board Size: " + boardRows + "x" + boardCols);

        // Create food items
        List<Food> foodItems = new ArrayList<>();
        foodItems.add(new NormalFood(3, 3));
        foodItems.add(new BonusFood(5, 5));
        foodItems.add(new NormalFood(7, 7));
        logger.log(Level.INFO, "Food items created: " + foodItems.size() + " items");

        // Initialize board
        Board board = new Board(boardRows, boardCols, foodItems);
        logger.log(Level.INFO, "Board initialized");

        // Initialize snake
        Snake snake = new Snake(0, 0);
        logger.log(Level.INFO, "Snake initialized at position (0, 0)");

        // Create player
        logger.log(Level.INFO, "Creating player with HumanMovementStrategy...");
        Player player = new Player("Player1", new HumanMovementStrategy());
        logger.log(Level.INFO, "Player created: " + player.getName());

        // Create game
        Game game = new Game(player, snake, board);
        logger.log(Level.INFO, "Game instance created");

        // Start the game
        logger.log(Level.INFO, "Starting game...");
        game.play();

        // Print final results
        logger.log(Level.INFO, "================ Game Summary ================");
        logger.log(Level.INFO, "Player: " + player.getName());
        logger.log(Level.INFO, "Highest Score: " + player.getHighestScore());
        logger.log(Level.INFO, "============================================");
    }
}

