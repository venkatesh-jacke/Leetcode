package Graph.Dfs;

//1340. Jump Game V

import java.util.Arrays;

public class MaxJumps {

    // Length of array
    static int n;

    // Memoization array
    // dp[i] = maximum jumps starting from index i
    static int[] dp;
    public static void main(String[] args) {
        int[] arr={6,4,14,6,8,13,9,7,10,6,12};
        int d = 2;
        System.out.println(maxJumps(arr,d));
    }
    static  public int maxJumps(int[] arr, int d) {

        // Store array length
        n = arr.length;

        // Initialize dp array
        dp = new int[n];

        // Final answer
        int res = 1;

        // Try starting DFS from every index
        for (int i = 0; i < n; i++) {

            // Compute maximum jumps from index i
            res = Math.max(res, dfs(arr, i, d));
        }
        System.out.println(Arrays.toString(dp));

        return res;
    }
   static public int dfs(int[] arr, int pos, int d)  {
        if (dp[pos] != 0)
            return dp[pos];

        // Minimum jump count is 1
        // (standing at current index itself)
        int max = 1;
        // Start from pos-1 and move left
        for (int i = pos - 1;
            // Stay within distance d
             i >= Math.max(0, pos - d)
                     // Can only jump to smaller height
                     && arr[pos] > arr[i];
             i--) {
            // Try jumping to index i
            max = Math.max(max, 1 + dfs(arr, i, d));
        }
        // Start from pos+1 and move right
        for (int i = pos + 1;
            // Stay within distance d
             i <= Math.min(n - 1, pos + d)
                     // Can only jump to smaller height
                     && arr[pos] > arr[i];

             i++) {

            // Try jumping to index i
            max = Math.max(max, 1 + dfs(arr, i, d));
        }

        // Store answer in dp and return
        return dp[pos] = max;
    }

}
