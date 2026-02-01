package Arrays;

import java.util.Arrays;

//3010. Divide an Array Into Subarrays With Minimum Cost I
public class MinimumCost {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 3, 1, 1};
        System.out.println(minimumCost(nums));
    }

    static public int minimumCost(int[] nums) {
        int ans = nums[0];
        Arrays.sort(nums, 1, nums.length);
        ans += nums[1] + nums[2];
        return ans;
    }
}
