package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

//2461. Maximum Sum of Distinct Subarrays With Length K

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maximumSubarraySum(arr, k));
    }

    static  public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        long sum = 0, maxSum = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);

            // shrink window if too big or duplicates present
            while ((r - l + 1) > k || freq.get(nums[r]) > 1) {
                sum -= nums[l];
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if (freq.get(nums[l]) == 0) freq.remove(nums[l]);
                l++;
            }
            //Check valid window
            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

}
