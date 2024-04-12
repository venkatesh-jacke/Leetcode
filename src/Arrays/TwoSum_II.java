package Arrays;

import java.util.Arrays;

public class TwoSum_II {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    static public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            }
            if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}
