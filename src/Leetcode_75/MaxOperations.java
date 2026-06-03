package Leetcode_75;

//1679. Max Number of K-Sum Pairs

import java.util.Arrays;

public class MaxOperations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 5;
        System.out.println(maxOperations(arr, k));
    }

    static public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, count = 0, j = nums.length - 1;

        while (i < j) {
            int curSum = nums[i] + nums[j];
            if (curSum == k) {
                i++;
                j--;
                count++;
            } else if (curSum < k) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
