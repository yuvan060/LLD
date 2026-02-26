package SnakeAndFood.Player;

public class Player {
    String name;
    public int highestScore;
    MovementStrategy movementStrategy;

    public Player(String name, MovementStrategy movementStrategy) {
        this.name = name;
        this.highestScore = 0;
        this.movementStrategy = movementStrategy;
    }

    public int[] move() {
        return movementStrategy.move();
    }

    public String getName() {
        return name;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }
}
