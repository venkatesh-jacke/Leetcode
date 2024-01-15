package Arrays;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        System.out.println(Arrays.toString(shuffle_2(nums, n)));
    }


    //Time Complexity O(2n)
    //space Complexity O(2n)
    static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];
        for (int i = 0, j = 0; i < 2 * n; i += 2, j++) {
            arr[i] = nums[j];
            arr[i + 1] = nums[j + n];
        }
        return arr;
    }



    //Time Complexity O(n)
    //space Complexity O(1)
    static int[] shuffle_2(int[] nums, int n) {
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] << 10;  //left shift by 10 bits to store the y value with x
            nums[i] = nums[i] | nums[i + n]; //store x,y together we use OR bitwise operator
        }

        int j = 2 * n - 1; //maintain a index from reverse to store the values

        for (int i = n - 1; i >= 0; i--) {
            int y = nums[i] & 1023;  // retrieve the y value from xy by & operator with 1023 since binary of 1023 is 1111111111
            int x = nums[i] >> 10;  // retrieve the x value from xy by right shifting by 10 bits
            nums[j] = y;// place the y value
            nums[j - 1] = x;  //place the x value
            j -= 2; //decrement to two because we will be storing y and x in a single iteration
        }
        return nums;
    }
}
