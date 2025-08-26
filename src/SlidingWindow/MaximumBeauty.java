package SlidingWindow;

import java.util.Arrays;

//2779. Maximum Beauty of an Array After Applying Operation

public class MaximumBeauty {
    public static void main(String[] args) {
        int[] nums = {4,6,1,2};
        int k = 2;
        System.out.println(maximumBeauty(nums,k));
    }

    static public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums); //sorted because easy min value is always at start so just need to chk nums[r] - nums[l] > 2 * k
        int res = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > 2 * k) {
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    static public int maximumBeauty2(int[] nums, int k) {
        Arrays.sort(nums);
        int l, r;
        for (l = 0, r = 0; r < nums.length; r++) {

            //It will always skip once
            if (nums[r] - nums[l] > 2 * k) {
                l+=1;
            }
        }
        return r - l;
    }
}
/*
nums[l] can be inc to nums[l]+k
nums[r] can be dec to nums[r]-k
For all numbers in the subarray to overlap within a valid range, the adjusted values must satisfy
    nums[l]+k ≥ nums[r]−k
Simplify
    nums[r]−nums[l] ≤ 2k

*/
