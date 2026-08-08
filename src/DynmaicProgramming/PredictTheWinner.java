package DynmaicProgramming;

//486. Predict the Winner

public class PredictTheWinner {

    public static void main(String[] args) {
        int[] arr = {1, 5, 233, 7};
        System.out.println(predictTheWinner(arr));
    }

    static public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        // dp[left][right] =
        // Maximum score difference (Current Player - Other Player)
        // for subarray nums[left...right]
        int[][] dp = new int[n][n];

        // Build answers from smaller subarrays to larger subarrays.
        for (int len = 1; len <= n; len++) {

            // Try every subarray of current length.
            for (int left = 0; left + len - 1 < n; left++) {

                int right = left + len - 1;

                // Base Case:
                // Only one number -> current player picks it.
                if (left == right) {
                    dp[left][right] = nums[left];
                    continue;
                }

                // Choice 1: Pick left number.
                // Opponent will play on (left+1 ... right),
                // so subtract opponent's best advantage.
                int takeLeft = nums[left] - dp[left + 1][right];

                // Choice 2: Pick right number.
                int takeRight = nums[right] - dp[left][right - 1];

                // Current player always chooses the better option.
                dp[left][right] = Math.max(takeLeft, takeRight);
            }
        }
        return dp[0][n-1]>=0;
    }
}

// ---------------------- Interval DP Template ----------------------
//
// State:
// dp[left][right] = Answer for subarray nums[left...right]
//
// Since dp[left][right] depends on:
//      dp[left + 1][right]
//      dp[left][right - 1]
//
// Both dependencies are SMALLER subarrays.
//
// Therefore, we CANNOT fill row-wise or column-wise.
// We must fill the table by increasing subarray length,
// which means filling DIAGONALLY.
//
// Example (n = 4)
//
//        0      1      2      3
//      ----------------------------
// 0 |   ✔  -->  ✔  -->  ✔  -->  ✔
// 1 |         ✔  -->  ✔  -->  ✔
// 2 |               ✔  -->  ✔
// 3 |                     ✔
//
// Diagonal 1 : Length = 1 (Base Cases)
// Diagonal 2 : Length = 2
// Diagonal 3 : Length = 3
// Diagonal 4 : Length = 4
//
// Each diagonal only depends on the previous diagonal(s),
// so required values are already computed.
//

//for each subarray length from 1 to n
//
//    for every possible starting index (left)
//
//right = left + length - 1
//
//        if only one element
//fill base case
//        else
//compute answer using
//dp[left + 1][right]
//dp[left][right - 1]
//
//        return dp[0][n-1]