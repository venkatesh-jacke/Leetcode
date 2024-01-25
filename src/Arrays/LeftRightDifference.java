package Arrays;


import java.util.Arrays;

//2574. Left and Right Sum Differences
public class LeftRightDifference {
    public static void main(String[] args) {
        int arr[] = {10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRightDifference(arr)));
    }


    //Time Complexity is O(n)
    //Space Complexity is O(1)
    static public int[] leftRightDifference(int[] nums) {
        int arr[] = new int[nums.length];

        int i = 0;

        while (i < nums.length) {
            int leftSum = 0;
            int rightSum = 0;
            int j = i;
            int k = i;
            while (j >0) {
                leftSum += nums[--j];
            }
            while (k < nums.length-1) {
                rightSum += nums[++k];
            }
            arr[i] = Math.abs(leftSum - rightSum);
            i++;
        }
        return arr;
    }
}
