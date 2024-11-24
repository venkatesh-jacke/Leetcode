package TwoPointer;


//26. Remove Duplicates from Sorted Array
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
    }

   static public int removeDuplicates(int[] nums) {
        int i = 0;
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i]) { // Check if the current element is unique
                i++; // Increment `i` to the next position for a unique value
                nums[i] = nums[j]; // Update the position with the current unique value
            }
        }
        return i + 1;
    }

}
