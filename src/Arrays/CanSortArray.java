package Arrays;


import java.util.Arrays;

//3011. Find if Array Can Be Sorted
public class CanSortArray {
    public static void main(String[] args) {
        int[] nums = {8, 4, 2, 30, 15};
        System.out.println(canSortArray(nums));
    }

    static public boolean canSortArray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] <= arr[j + 1]) {
                    continue;
                } else if (Integer.bitCount(arr[j]) == Integer.bitCount(arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean canSortArray2(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        int n = arr.length;
        int setBit = Integer.bitCount(nums[0]);
        int prev_max = Integer.MIN_VALUE;
        int cur_min = nums[0];
        int cur_max = nums[0];
        for (int i = 1; i < n; i++) {
            if (Integer.bitCount(nums[i]) == setBit) {
                cur_max = Math.max(cur_max, nums[i]);
                cur_min = Math.min(cur_min, nums[i]);
            } else {
                if (cur_min < prev_max) {
                    return false;
                }
                prev_max = cur_max;
                cur_min = nums[i];
                cur_max = nums[i];
                setBit = Integer.bitCount(nums[i]);
            }
        }
        return !(cur_min < prev_max);
    }
}
