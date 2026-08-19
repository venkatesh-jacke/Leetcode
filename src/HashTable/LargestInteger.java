package HashTable;

//3471. Find the Largest Almost Missing Integer
public class LargestInteger {
    public static void main(String[] args) {
        int[] nums = {3, 9, 7, 2, 1, 7};
        int k = 4;
        System.out.println(largestInteger(nums, k));
    }

    static public int largestInteger(int[] nums, int k) {

        int n = nums.length;
        int[] count = new int[51];

        // If k == n, the whole array is one subarray.
        // So every element appears; simply return the maximum.
        if (n == k) {
            int max = -1;
            for (int i : nums) {
                max = Math.max(max, i);
            }
            return max;
        }

        // Count how many times each number appears.
        for (int i : nums) {
            count[i]++;
        }

        // If k == 1, each subarray has one element.
        // Therefore, we need the largest number appearing exactly once.
        if (k == 1) {
            for (int i = 50; i >= 0; i--) {
                if (count[i] == 1) {
                    return i;
                }
            }
            return -1;
        }

        /*
         * For 1 < k < n:
         *
         * An element can be present in exactly ONE subarray
         * only if it is at either end of the array AND appears once.
         *
         * So check only nums[0] and nums[n-1].
         */
        int res = -1;

        if (count[nums[0]] == 1) {
            res = Math.max(res, nums[0]);
        }

        if (count[nums[n - 1]] == 1) {
            res = Math.max(res, nums[n - 1]);
        }

        return res;
    }
}