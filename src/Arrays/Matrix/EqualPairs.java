package Arrays.Matrix;


//2352. Equal Row and Column Pairs

import java.util.Arrays;
import java.util.HashMap;

public class EqualPairs {
    public static void main(String[] args) {
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(equalPairs(grid));
    }

    static public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean isEqual = true;
                for (int i = 0; i < n; i++) {
                    if (grid[r][i] != grid[i][c]) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual)
                    count++;
            }
        }
        return count;
    }
    public int equalPairs1(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> rows = new HashMap<>();
        // Store all rows
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            rows.put(key, rows.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        // Build each column and look it up
        for (int c = 0; c < n; c++) {
            int[] col = new int[n];
            for (int r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }
            count += rows.getOrDefault(Arrays.toString(col), 0);
        }
        return count;
    }

}
