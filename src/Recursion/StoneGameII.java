package Recursion;

//1140. Stone Game II
public class StoneGameII {
    static int n;
    static int[] suffix;

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 4, 4};
        System.out.println(stoneGameII(arr));
    }

    static public int stoneGameII(int[] piles) {
        n = piles.length;
        suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        return solve(0, 1);
    }

    static public int solve(int index, int M) {
        //No piles left
        if (index >= n) return 0;
        // Can take every remaining pile.
        if (2 * M >= n - index) return suffix[index]; // (n-index) is remaining piles
        int best = 0;
        //Try with every X
        for (int X = 1; X <= 2 * M; X++) {
            best = Math.max(best, suffix[index] - solve(index + X, Math.max(M, X)));
        }
        return best;
    }
}
