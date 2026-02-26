package SnakeAndFood.food;

public abstract class Food {
    int row;
    int col;

    public Food(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
