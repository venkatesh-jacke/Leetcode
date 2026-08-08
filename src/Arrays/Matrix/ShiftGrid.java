package Arrays.Matrix;

import java.util.ArrayList;
import java.util.List;


//1260. Shift 2D Grid

public class ShiftGrid {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        System.out.println(shiftGrid(grid,k));
    }

    static public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int total = m * n;
        k %= total;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            ans.add(row);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // index in 1D array (before rotation)
                int oldIndex = i * n + j;
                // index in 1D array (after rotation)
                int newIndex = (oldIndex + k) % total;

                // changing from 1D back to 2D
                int newRow = newIndex / n;
                int newCol = newIndex % n;

                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return ans;
    }
}
