package Arrays;

import java.util.Arrays;

// 1920 Build Array from Permutation
public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int arr[] = {0, 2, 1, 5, 3, 4};
        System.out.println(Arrays.toString(buildArray(arr)));
    }

    static int[] buildArray(int[] nums) {
        int n=nums.length;
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[nums[i]];
        }
        return arr;
    }
}


//Time complexity  O(n)  Traverse all elements in an array
//Space complexity O(n)  2 * size of original array