package BitManipulation;

//2044. Count Number of Maximum Bitwise-OR Subsets
public class CountMaxOrSubsets {

    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        System.out.println(countMaxOrSubsets(nums));
    }

    static public int countMaxOrSubsets(int[] nums) {
        int max_or = 0, res = 0;
        for (int i : nums)
            max_or |= i;
        int totalSubsets = 1 << nums.length;
        for (int mask = 0; mask < totalSubsets; mask++) {
            int cur_or = 0;
            for (int i = 0; i < nums.length; i++) {
                if (((mask >> i) & 1) == 1) {
                    cur_or |= nums[i];
                }
            }
            if (cur_or == max_or) {
                res++;
            }
        }
        return res;
    }


}
