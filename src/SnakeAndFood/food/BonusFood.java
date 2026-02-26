package SnakeAndFood.food;

public class BonusFood extends Food{
    int points;
    public BonusFood(int row, int col) {
        super(row, col);
        this.points = 5;
    }

    public int getPoints() {
        return points;
    }
}
