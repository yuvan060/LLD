package SnakeAndFood.Snake;

import java.util.*;

public class Snake {
    Deque<int[]> snake;
    Set<String> bodyPath;

    public Snake(int row, int col) {
        snake = new LinkedList<>();
        bodyPath = new HashSet<>();
        initializeSnake(row, col);
    }

    private void initializeSnake(int row, int col) {
        snake.add(new int[] {row, col});
        bodyPath.add(row+"-"+col);
    }

    public boolean willHitBody(int row, int col) {
        return bodyPath.contains(row+"-"+col);
    }

    public int[] getCurrentHead() {
        return snake.getFirst();
    }

    public void moveNextCell(int[] direction, boolean ateFood) {
        int[] head = snake.getFirst();
        int r = head[0] + direction[0];
        int c = head[1] + direction[1];
        bodyPath.add(r+"-"+c);
        snake.offerFirst(new int[]{r,c});
        if(!ateFood) {
            int[] tail = snake.getLast();
            bodyPath.remove(tail[0]+"-"+tail[1]);
            snake.pollLast();
        }
    }
}
