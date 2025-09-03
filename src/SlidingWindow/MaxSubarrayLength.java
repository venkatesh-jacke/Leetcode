package SlidingWindow;

import java.util.HashMap;

//2958. Length of Longest Subarray With at Most K Frequency

public class MaxSubarrayLength {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        System.out.println(maxSubarrayLength(arr, k));
    }

    static public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            //'r' is accessed in each iteration so check nums[r] for its freq
            while (map.get(nums[r]) > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
