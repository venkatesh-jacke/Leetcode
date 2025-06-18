package Recursion;

//322. Coin Change

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{9, 6, 5, 1};
        int target = 19;
        System.out.println(minCoins(coins, target));
    }

    public static int minCoins(int coins[], int sum) {
        int ans = rec(0, coins, sum);
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static int rec(int i, int[] coins, int sum) {
        if (sum == 0) return 0; //default case
        if (sum < 0 || i == coins.length) return Integer.MAX_VALUE; //cannot have denomination
        int take = rec(i, coins, sum - coins[i]); // include the coins[i]
        if (take != Integer.MAX_VALUE) {
            take++;
        }

        int notTake = rec(i + 1, coins, sum);// don't include and go to next one;
        return Math.min(take, notTake);
    }

    public static int minCoins2(int[] coins, int sum) {
        if (sum == 0) return 0;
        if (sum < 0) return -1; //cannot make
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) { // try all coins
            int count = minCoins2(coins, sum - coin);
            if (count == -1) continue; //go to next coin
            minCount = Math.min(minCount, count + 1); // +1 to include current coin

        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
}
