package Recursion;


//494. Target Sum
public class FindTargetSumWays  {
    static int count = 0;

    public static void main(String[] args) {

        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    static public int findTargetSumWays(int[] nums, int target) {
        helper(nums, target,0, 0);
        return count;
    }

    static void helper(int[] nums, int target, int i, int sum) {
        if (i == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        helper(nums, target, i + 1, sum + nums[i]);
        helper(nums, target, i + 1, sum - nums[i]);
    }


}