package BitManipulation;

//3097. Shortest Subarray With OR at Least K II
public class MinimumSubarrayLength {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 2;
        System.out.println(minimumSubarrayLength(arr, k));
    }

    /**
     * Finds the minimum length of a contiguous subarray with an OR sum >= k.
     * @param nums the array of integers.
     * @param k the threshold value for the OR sum of the subarray.
     * @return the minimum length of such a subarray, or -1 if no such subarray exists.
     */
    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] bits = new int[32]; // Array to store the bit count at each position for the current window
        int l = 0, r = 0; // Window pointers for sliding window approach
        int res = Integer.MAX_VALUE; // Initialize result with max value to find minimum length

        while (r < n) {
            // Add the number at index r to the bit count
            updateBitsCount(bits, nums[r], 1);

            // Shrink the window from the left if the OR of the current window >= k
            while (l <= r && bitsToInt(bits) >= k) {
                // Update the result with the minimum length found
                res = Math.min(res, r - l + 1);
                // Remove the number at index l from the bit count as we move the left pointer forward
                updateBitsCount(bits, nums[l], -1);
                l++; // Move left pointer
            }

            r++; // Move right pointer
        }

        // If no valid subarray is found, return -1
        return res != Integer.MAX_VALUE ? res : -1;
    }

    /**
     * Updates the bit count array for a given integer.
     * If flag is 1, bits are added to the count; if flag is -1, bits are subtracted.
     * @param bits the bit count array.
     * @param n the integer whose bits are to be added/removed.
     * @param flag 1 to add bits, -1 to remove bits.
     */
    public static void updateBitsCount(int[] bits, int n, int flag) {
        for (int i = 0; i < 32; i++) {
            // Check if the i-th bit in n is set
            if ((n & (1 << i)) != 0) {
                // Update bit count: add or subtract based on the flag
                bits[i] += flag;
            }
        }
    }

    /**
     * Converts the bit count array to an integer representing the OR of all numbers in the window.
     * Each bit position is set if the count is non-zero.
     * @param bits the bit count array.
     * @return the integer representation of the OR of the numbers in the current window.
     */
    public static int bitsToInt(int[] bits) {
        int n = 0;
        for (int i = 0; i < 32; i++) {
            // If bit count at position i is non-zero, set the i-th bit in n
            if (bits[i] != 0) {
                n += (1 << i);
            }
        }
        return n;
    }
}
