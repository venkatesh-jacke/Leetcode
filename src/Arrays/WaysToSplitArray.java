package Arrays;


//2270. Number of Ways to Split Array

public class WaysToSplitArray {
    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{9, 9, 9}));
    }

    static public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        int ans = 0;
        for (int num : nums) {
            totalSum += num;
        }
        long leftSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;
            if (leftSum >= rightSum)
                ans++;
        }
        return ans;
    }

    static public int waysToSplitArray2(int[] nums) {
        long rightSum = 0;
        int ans = 0;
        for (int num : nums) {
            rightSum += num;
        }
        long leftSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum)
                ans++;
        }
        return ans;
    }

}
