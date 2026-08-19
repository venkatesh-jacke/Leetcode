package HashSet;

import java.util.HashSet;


//2996. Smallest Missing Integer Greater Than Sequential Prefix Sum

public class MissingInteger {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 5};
        System.out.println(missingInteger(nums));
    }

    static public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Sequential means the current number
            // must be exactly 1 greater than the previous number.
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                // First break -> sequential prefix ends.
                break;
            }
        }
        while (!set.contains(sum)) {
            sum++;
        }
        return sum;
    }
}
