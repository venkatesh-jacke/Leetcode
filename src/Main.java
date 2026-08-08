import org.w3c.dom.css.CSSStyleRule;

import java.util.*;
import java.util.HashMap;


class Main {

    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        // suffix[i] = total stones from i to end
        suffix = new int[n];
        suffix[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] + piles[i];

        return solve(0, 1);
    }

    // Maximum stones current player can collect
    private int solve(int index, int M) {

        // No piles left.
        if (index >= n)
            return 0;

        // Can take every remaining pile.
        if (2 * M >= n - index)
            return suffix[index];

        int best = 0;

        // Try every possible X.
        for (int X = 1; X <= 2 * M; X++) {

            best = Math.max(best, suffix[index] - solve(index + X, Math.max(M, X)));
        }

        return best;
    }
}