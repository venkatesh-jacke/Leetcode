package Arrays;

import java.util.Arrays;


//2974. Minimum Number Game
public class NumberGame {
    public static void main(String[] args) {
        int arr[] = {5, 4, 2, 3};
        System.out.println(Arrays.toString(numberGame(arr)));
    }


    //Time Complexity is O(NlogN)
    //Space Complexity is O(1)
    static public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i+=2){
            int temp=nums[i];
            nums[i]=nums[i+1];
            nums[i+1]=temp;

        }

        return nums;
    }
}
