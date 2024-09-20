package Arrays;

public class MinSwaps {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 0};
        System.out.println(minSwaps(arr));

    }

    static public int minSwaps(int[] nums) {
        int n = nums.length;
        int total_ones = 0, window_ones = 0, max_window_ones = 0;
        int left = 0;

        for (int i : nums)
            if (i == 1)
                total_ones += 1;
        for (int right = 0; right < (2 * n); right++) {
            if (nums[right % n] == 1) {
                window_ones += 1;
            }
            if ((right - left + 1) > total_ones) {
                window_ones -= nums[left % n];
                left += 1;
            }
            max_window_ones = Math.max(max_window_ones, window_ones);
        }
        return total_ones - max_window_ones;
    }
}
