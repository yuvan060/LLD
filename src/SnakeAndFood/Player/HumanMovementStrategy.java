package SnakeAndFood.Player;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class HumanMovementStrategy implements MovementStrategy{
    private static final Logger logger = Logger.getLogger(HumanMovementStrategy.class.getName());

    @Override
    public int[] move() {
        Scanner scanner = new Scanner(System.in);
        logger.log(Level.INFO, "Waiting for player input...");
        System.out.println("Enter Which direction to move - UP | DOWN | RIGHT | LEFT");
        String userDirection = scanner.nextLine();
        logger.log(Level.INFO, "User input received: " + userDirection);

        switch (userDirection) {
            case "UP" -> {
                logger.log(Level.INFO, "Direction set to UP");
                return new int[]{-1, 0};
            }
            case "DOWN" -> {
                logger.log(Level.INFO, "Direction set to DOWN");
                return new int[]{1, 0};
            }
            case "LEFT" -> {
                logger.log(Level.INFO, "Direction set to LEFT");
                return new int[]{0, -1};
            }
            case "RIGHT" -> {
                logger.log(Level.INFO, "Direction set to RIGHT");
                return new int[]{0, 1};
            }
            default -> {
                logger.log(Level.WARNING, "Invalid direction input: " + userDirection + ". Defaulting to no movement");
                return new int[]{0, 0};
            }
        }
    }
}
