package Greedy;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(candy(ratings));
    }

    static  public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
            cnt += candies[i - 1];
        }
        return cnt + candies[n - 1];
    }
}
