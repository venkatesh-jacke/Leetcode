package Contests.Weekly392;


//3105. Longest Strictly Increasing or Strictly Decreasing Subarray
public class LongestMonotonicSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 3, 2};
        System.out.println();
    }

    static public int longestMonotonicSubarray(int[] nums) {
        int incLen = 1, decLen = 1, inc = 1, dec = 1, ans = 1;


        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i + 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] > nums[i + 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            incLen = Math.max(incLen, inc);
            decLen = Math.max(decLen, dec);
            ans = Math.max(incLen, decLen);
        }
        return ans;
    }

}
