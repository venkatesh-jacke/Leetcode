package Greedy;

//2091. Removing Minimum and Maximum From Array

public class MinimumDeletions {
    public static void main(String[] args) {
        int[] nums = {2, 10, 7, 5, 4, 1, 8, 6};
        System.out.println();
    }

    static public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        // Make minIndex the leftmost target
        // and maxIndex the rightmost target.
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }
        int fromLeft = maxIndex + 1;
        int fromRight = n - minIndex;
        int fromBoth = (minIndex + 1) + (n - maxIndex);
        return Math.min(fromBoth, Math.min(fromLeft, fromRight));

    }
}
