package Leetcode_75;


//643. Maximum Average Subarray I
public class FindMaxAverage {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums,k));
    }

    static public double findMaxAverage(int[] nums, int k) {
        double currentWindowSum = 0.0;
        for (int i = 0; i < k; i++) {
            currentWindowSum += nums[i];
        }
        double maxWindowSum = currentWindowSum;
        for (int i = k; i < nums.length; i++) {
            currentWindowSum += nums[i];
            currentWindowSum -= nums[i - k];
            maxWindowSum = Math.max(maxWindowSum, currentWindowSum);

        }
        return maxWindowSum / k;
    }
}
