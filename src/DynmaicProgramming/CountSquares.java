package DynmaicProgramming;

//1277. Count Square Submatrices with All Ones
public class CountSquares {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println(countSquares(grid));
    }

    static public int countSquares(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i][j]));
                    ans += dp[i + 1][j + 1];
                }
            }
        }
        return ans;
    }
}
