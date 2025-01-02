package Arrays;


//287. Find the Duplicate Number
public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr));
    }

    static public int findDuplicate(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            // If the current number is not in its correct position
            if (nums[i] != i + 1) {
                int correctIndex = nums[i] - 1; // Find the correct position for the number
                // If the number at the correct position is not the same, swap the numbers
                if (nums[correctIndex] != nums[i]) {
                    int temp = nums[correctIndex];
                    nums[correctIndex] = nums[i];
                    nums[i] = temp;
                }
                // If the number is already at the correct position and is the same, return the duplicate
                else {
                    // Move to the next number if it's already in the correct position
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return n;
    }

    // Index Sort
    // n + 1 numbers in n.
    public static int findDuplicate_index_sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; ) {
            int n = nums[i];
            // If the number is already in its correct position (n == i + 1), just move to the next index.
            if (n == i + 1) {
                i++;
            } else if (n == nums[n - 1]) {
                return n;
            } else {
                nums[i] = nums[n - 1];
                nums[n - 1] = n;
            }
        }

        return 0;
    }
}