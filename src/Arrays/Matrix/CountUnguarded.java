package Arrays.Matrix;

import java.util.Arrays;


//2257. Count Unguarded Cells in the Grid
public class CountUnguarded {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(countUnguarded(m, n, guards, walls));
    }

    static public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int count = m*n;
        for (int wall[] : walls) {
            grid[wall[0]][wall[1]] = 1;
            count--;
        }
        for (int guard[] : guards) {
            grid[guard[0]][guard[1]] = 1;
            count--;
        }
        for (int guard[] : guards) {
            for (int i = 0; i < dir.length; i++) {
                int x = guard[0], y = guard[1];
                while (isValid(grid, x + dir[i][0], y + dir[i][1])) {
                    x += dir[i][0];
                    y += dir[i][1];
                    if (grid[x][y] == 1 || grid[x][y] == -1) break;
                    if (grid[x][y] == 0) {
                        grid[x][y] = 2;
                        count--;
                    }
                }
            }
        }

        return count;
    }

    static public boolean isValid(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
