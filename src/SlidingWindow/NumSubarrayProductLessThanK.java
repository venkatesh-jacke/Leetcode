package SlidingWindow;

//713. Subarray Product Less Than K

public class NumSubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] arr={};
        int k=100;
        System.out.println();
    }
    static  public int numSubarrayProductLessThanK(int[] nums, int k) {
        // If k is less than or equal to 1, no subarray product can be less than k
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
