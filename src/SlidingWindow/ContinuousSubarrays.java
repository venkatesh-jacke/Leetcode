package SlidingWindow;

import java.util.TreeMap;

//2762. Continuous Subarrays

public class ContinuousSubarrays {
    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 4};
        System.out.println(continuousSubarrays(nums));
    }

    static public long continuousSubarrays(int[] nums) {
        long count = 0;
        int left = 0, right = 0, n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
            }
            count += (right - left + 1);
            right++;
        }

        return count;
    }
}
