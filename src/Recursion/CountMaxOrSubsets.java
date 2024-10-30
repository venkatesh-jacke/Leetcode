package Recursion;


//2044. Count Number of Maximum Bitwise-OR Subsets
public class CountMaxOrSubsets {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(countMaxOrSubsets(nums));
    }

    static public int countMaxOrSubsets(int[] nums) {
        int max_or = 0;
        for (int i : nums)
            max_or |= i;
        return dfs(nums, 0, max_or, 0);

    }

    static public int dfs(int[] nums, int i, int max_or, int cur_or) {
        if (i == nums.length) {
            return cur_or == max_or ? 1 : 0;
        }
        int take = dfs(nums, i + 1, max_or, cur_or | nums[i]);
        int notTake = dfs(nums, i + 1, max_or, cur_or);
        return take + notTake;
    }
}
