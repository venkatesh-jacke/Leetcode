package Memoization;

//3418. Maximum Amount of Money Robot Can Earn

import java.util.Arrays;

public class MaximumAmount {
    public static void main(String[] args) {
        int[][] coins = new int[][]{
                {0, 1, -1},
                {1, -2, 3},
                {2, -3, 4}
        };
        System.out.println(maximumAmount(coins));
    }

    static public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] memo = new int[m][n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }
        return dfs(coins, memo, 0, 0, 2);
    }

    static public int dfs(int[][] coins, int[][][] memo, int i, int j, int k) {
        int m = coins.length;
        int n = coins[0].length;

        //boundary
        if (i >= m || j >= n) {
            return Integer.MIN_VALUE;
        }
        int val = coins[i][j];
        if (i == m - 1 && j == n - 1) {
            return k > 0 ? Math.max(0, val) : val;
        }
        if (memo[i][j][k] != Integer.MIN_VALUE) return memo[i][j][k];
        int res = Math.max(dfs(coins, memo, i + 1, j, k), // move down
                dfs(coins, memo, i, j + 1, k)) + val; // move right
        if (k > 0 && val < 0) {
            //best = max(don't neutralize,neutralize)
            res = Math.max(res, Math.max(dfs(coins, memo, i + 1, j, k - 1),
                    dfs(coins, memo, i, j + 1, k - 1)));
        }
        memo[i][j][k] = res;
        return res;
    }
}
