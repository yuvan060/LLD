package SnakeAndFood.food;

public class NormalFood extends Food{
    int points;
    public NormalFood(int row, int col) {
        super(row, col);
        this.points = 1;
    }

    public int getPoints() {
        return points;
    }
}
