package Arrays;

import java.util.Arrays;

//1929 Concatenation of Array
public class ConcatenationOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println(Arrays.toString(getConcatenation(arr)));

    }

    static int[] getConcatenation(int[] nums) {
        int arr[]=new int[2*nums.length];
        int n=nums.length;
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            arr[n+i]=nums[i];
        }
        return arr;
    }

}

//Time complexity  O(n)  Traverse all elements in an array
//Space complexity O(n)  2 * size of original array
