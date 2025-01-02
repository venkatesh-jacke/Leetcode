package Memoization;

import java.util.Arrays;

//494. Target Sum
public class FindTargetSumWays {
    static int count = 0, total;
    static int[][] memo;

    public static void main(String[] args) {

        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    static public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        memo = new int[nums.length][2 * total + 1];
        for (int[] a : memo) {
            Arrays.fill(a, Integer.MIN_VALUE);
        }
        return helper(nums, target, 0, 0);
    }

    static int helper(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }

        }
        if (memo[i][sum+total] != Integer.MIN_VALUE) {
            return memo[i][sum+total];
        }
        int add = helper(nums, target, i + 1, sum + nums[i]);
        int sub = helper(nums, target, i + 1, sum - nums[i]);
        return memo[i][sum + total] = add + sub;
    }


}