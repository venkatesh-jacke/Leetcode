package BitManipulation;

import java.util.Arrays;


//1829. Maximum XOR for Each Query
public class GetMaximumXor {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 3};
        int maximumBit = 2;
        System.out.println(Arrays.toString(getMaximumXor(arr, maximumBit)));
    }

    static public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xor = 0;
        int[] res = new int[n];
        for (int i : nums) {
            xor ^= i;
        }
        int mask = (1 << maximumBit) - 1;
        for (int i = 0; i < n; i++) {
            res[i] = xor ^ mask;
            xor = xor ^ nums[n - i - 1];
        }
        return res;
    }
}
