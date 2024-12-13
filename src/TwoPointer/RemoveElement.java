package TwoPointer;

import java.util.Arrays;

//27. Remove Element
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(arr, val));
        System.out.println(Arrays.toString(arr));
    }

    static public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; //write it in front
                k++;
            }
        }
        return k;
    }
    static public int removeElement2(int[] nums, int val){
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]==val){
                nums[i]=nums[n-1];// swap with last element
                n--; //decrement only the last
            }
            else{
                i++;
            }
        }
        return n;
    }
}
