package simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by linc on 2018/11/9.
 */
public class Exe37 {
    public void solveSudoku(char[][] board) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    points.add(new Point(i, j, 1));
            }
        }
        boolean b = find(board, points, 0);
        return;
    }

    public boolean find(char[][] board, List<Point> points, int index) {
        Point point = points.get(index);
        for (int i = 1; i <= 9; i++) {
            if (!hasUsed(point.x, point.y, board, Character.forDigit(i, 10))) {
                board[point.x][point.y] = Character.forDigit(i, 10);
                if (index == points.size() - 1) {
                    return true;
                }
                boolean b = find(board, points, index + 1);
                if (b) {
                    return true;
                }else {
                    board[point.x][point.y]='.';
                }
            }
        }
        return false;
    }

    public boolean hasUsed(int x, int y, char[][] board, char value) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == value
                    || board[i][y] == value
                    || board[i % 3 + (x / 3) * 3][i / 3 + (y / 3) * 3] == value) {
                return true;
            }
        }
        return false;
    }

    class Point {
        int x;
        int y;
        int value;

        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int x=1,y=2;

        for (int i = 0; i < 9; i++) {
            int a=i % 3 + (x / 3) * 3;
            int b=i / 3 + (y / 3) * 3;
            int c=1;
        }
        char[][] boards = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        new Exe37().solveSudoku(boards);
    }
}
