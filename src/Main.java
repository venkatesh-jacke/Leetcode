import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {0, 1, 1, 0, 1};


        System.out.println("Minimum operations for nums1: " + minOperations(nums1));

    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        boolean flip = false;

        for (int i = 0; i < n; i++) {
            // Check the current value considering the flip state
            if ((nums[i] == 0 && !flip) || (nums[i] == 1 && flip)) {
                // Perform flip from this index to the end
                operations++;
                flip = !flip;

                // Print the array state before and after flip
                System.out.println("After flip at index "+i+":");
                System.out.println(Arrays.toString(flipFromIndex(Arrays.copyOfRange(nums, 0, nums.length), i)));

            }
        }

        return operations;
    }

    // Helper method to flip the array from index i to the end
    private static int[] flipFromIndex(int[] arr, int i) {
        int[] nums = arr.clone();
        for (int j = i; j < nums.length; j++) {
            nums[j] = nums[j] == 0 ? 1 : 0;
        }
        return nums;
    }

    // Helper method to convert array to string for printing

}
