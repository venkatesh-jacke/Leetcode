package SlidingWindow;

//930. Binary Subarrays With Sum

public class NumSubarraysWithSum {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 11, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(arr, goal));
    }

    static public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    static public int atMost(int[] nums, int goal) {
        int cur = 0, total = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            cur += nums[r];
            while (l <= r && cur > goal) {
                cur -= nums[l];
                l++;
            }
            total += r - l + 1;
        }
        return total;
    }
}
