package Arrays;


import java.util.Arrays;

//1480. Running Sum of 1d Array
public class RunningSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(arr)));
    }


    //Time Complexity O(n)
    //Space Complexity O(1)
    public static int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;

    }
}
