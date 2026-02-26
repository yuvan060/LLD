package SnakeAndFood.Board;

import SnakeAndFood.food.Food;

import java.util.List;

public class Board {
    int N;
    int M;
    List<Food> foodItems;
    public int foodIndex;

    public Board(int n, int m, List<Food> foodItems) {
        N = n;
        M = m;
        this.foodItems = foodItems;
        this.foodIndex = 0;
    }

    public boolean willHitWall(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= M;
    }

    public boolean willEatFood(int row, int col) {
        Food food = foodItems.get(this.foodIndex);
        return row == food.getRow() && col == food.getCol();
    }

    public boolean hasFood() {
        return foodIndex < foodItems.size();
    }

    public void nextFood() {
        this.foodIndex++;
    }

    public int getM() {
        return M;
    }

    public int getN() {
        return N;
    }

    public List<Food> getFoodItems() {
        return foodItems;
    }
}
