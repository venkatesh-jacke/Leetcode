package Greedy;

import java.util.Arrays;

//1833. Maximum Ice Cream Bars
public class MaxIceCream {
    public static void main(String[] args) {
        int[] costs = new int[]{1, 3, 2, 4, 1};
        int coins = 7;
        System.out.println(maxIceCream(costs,coins));
    }

    static public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int i : costs) {
            if (i < coins) {
                coins -= i;
                count++;
            }
        }
        return count;
    }
}
