package Recursion;

import java.util.Arrays;

public class StrangePrinter {
    static int[][] dp;

    public static void main(String[] args) {
        String s = "aaabbb";
        System.out.println(strangePrinter(s));
    }


    static public int strangePrinter(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int[] d : dp)
            Arrays.fill(d, -1);
        return solve(0, n - 1, s);
    }

    static public int solve(int i, int j, String s) {
        if (i == j)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        int minTurns = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            minTurns = Math.min(minTurns, solve(i, k, s) + solve(k + 1, j, s));
        }
        return dp[i][j] = s.charAt(i) == s.charAt(j) ? minTurns - 1 : minTurns;
    }
}
