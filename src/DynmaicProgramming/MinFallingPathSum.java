package DynmaicProgramming;


import java.util.Arrays;

//Minimum Falling Path Sum II
public class MinFallingPathSum {

    static int memo[][];

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minFallingPathSum_Rec(grid));
    }


    //Recursion  Time O(n^3)
    static public int minFallingPathSum_Rec(int[][] grid) {
        memo = new int[grid.length][grid.length];
        int len = grid.length;
        for (int[] i : memo)
            Arrays.fill(i, -1);
        int ans = Integer.MAX_VALUE;
        //k means all the cells in a row (column wise)
        for (int k = 0; k < len; k++) {
            ans = Math.min(ans, grid[0][k] + solve(1, k,grid));
        }
        return ans;

    }
    static int solve(int i, int notJ,int[][] grid) {
        int len=grid.length;
        if (i == len) return 0;
        if (memo[i][notJ] != -1) return memo[i][notJ];
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < len; j++) {
            if (j == notJ) continue;
            ans = Math.min(ans, grid[i][j] + solve(i + 1, j,grid));
        }
        return memo[i][notJ] = ans;
    }

}
