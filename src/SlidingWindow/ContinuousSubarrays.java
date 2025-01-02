package SlidingWindow;

import java.util.TreeMap;

public class ContinuousSubarrays {
    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 4};
        System.out.println(continuousSubarrays(nums));
    }

    static  public long continuousSubarrays(int[] nums) {
        long count = 0;
        int left = 0, right = 0, n = nums.length;
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        while (right < n) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
