package SlidingWindow;

//560. Subarray Sum Equals K

import java.util.HashMap;

public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    static public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int cur_sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            cur_sum += i;
            int diff = cur_sum - k;
            ans += map.getOrDefault(diff, 0);
            map.put(cur_sum, map.getOrDefault(cur_sum, 0) + 1);
        }
        return ans;
    }
}
