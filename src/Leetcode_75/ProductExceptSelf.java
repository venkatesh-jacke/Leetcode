package Leetcode_75;


//238. Product of Array Except Self
public class ProductExceptSelf {

    public static void main(String[] args) {

    }

    static public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];

        int prefix = 1, suffix = 1;
        for (int i = 0; i < N; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }
        for (int i = N - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }
        return res;
    }
}
