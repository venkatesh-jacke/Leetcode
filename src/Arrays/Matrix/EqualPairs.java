package Arrays.Matrix;


//2352. Equal Row and Column Pairs

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
}
