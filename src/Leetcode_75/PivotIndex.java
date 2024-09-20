package Leetcode_75;

import java.util.Arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex2(nums));
    }

    static public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for (int i : nums) totalSum += i;
        int left = 0;
        for (int i = 0; i < n; i++) {
            int right = totalSum - left - nums[i];
            if (right == left) return i;
            left += nums[i];
        }
        return -1;
    }

    static public int pivotIndex2(int[] nums) {
        int n = nums.length;
        int[] left = new int[n + 1];
        int[] right = new int[n + 1];
        for (int i = 0; i < n; i++) {
            left[i + 1] = left[i] + nums[i];
        }
        System.out.println(Arrays.toString(left));
        for (int i = n - 1; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i];
        }
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < n; i++) {
            if (left[i] == right[i + 1]) return i;
        }
        return -1;
    }
}
