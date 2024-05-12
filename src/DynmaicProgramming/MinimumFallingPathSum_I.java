package DynmaicProgramming;


//931. Minimum Falling Path Sum
public class MinimumFallingPathSum_I {
    public static void main(String[] args) {
        int[][] arr = {
                {100, -42, -46, -41},
                {31, 97, 10, -10},
                {-58, -51, 82, 89},
                {51, 81, 69, -51}
        };
        System.out.println(minFallingPathSum(arr));
    }

    static public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[0][i] = arr[0][i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minVal = Integer.MAX_VALUE;
                minVal = Math.min(minVal, dp[i - 1][j]);
                if (j - 1 >= 0)
                    minVal = Math.min(minVal, dp[i - 1][j - 1]);
                if (j + 1 < n)
                    minVal = Math.min(minVal, dp[i - 1][j + 1]);

                dp[i][j] = minVal + arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }


}