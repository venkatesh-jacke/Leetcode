package DynmaicProgramming;

//1140. Stone Game II
public class StoneGameII {
    static int n;
    static int[] suffix;
    static Integer[][] dp;

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 4, 4};
        System.out.println(stoneGameII(arr));
    }

    static  public int stoneGameII(int[] piles) {
        int n = piles.length;
        // suffix[i] = total stones from index i to end
        int[] suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        // dp[index][M] =
        // Maximum stones current player can collect
        // starting from 'index' with current M.
        int[][] dp = new int[n + 1][n + 1];

        // Fill from last index because current state
        // depends on future indices (index + X).
        for (int index = n - 1; index >= 0; index--) {

            // Try every possible value of M.
            for (int M = 1; M <= n; M++) {

                // Remaining piles = n - index.
                // If we can take all remaining piles,
                // that's always the best move.
                if (2 * M >= n - index) {
                    dp[index][M] = suffix[index];
                    continue;
                }

                int best = 0;

                // Try taking X piles.
                for (int X = 1; X <= 2 * M; X++) {

                    // Opponent starts from (index + X)
                    // and plays optimally.
                    //
                    // My stones =
                    // Total remaining stones
                    // - Opponent's best stones.
                    int myStones =
                            suffix[index] -
                                    dp[index + X][Math.max(M, X)];

                    best = Math.max(best, myStones);
                }

                dp[index][M] = best;
            }
        }

        // Start from index 0 with M = 1.
        return dp[0][1];
    }

}
