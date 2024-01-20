package Arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//2824. Count Pairs Whose Sum is Less than Target
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int arr[] = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent2(arr)));
    }


    //Time Complexity O(n^2)
    //Space Complexity O(1)
    static int[] smallerNumbersThanCurrent(int[] nums) {
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) count++;
            }
            res[i] = count;
        }
        return res;
    }

    //Time Complexity O(N)
    //Space Complexity O(1)
    static int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] a= new int[101];
        for(int i=0;i< nums.length;i++){
            a[nums[i]]++;
        }
        for(int j=1;j<101;j++){
            a[j]+=a[j-1];
        }

        for(int k=0;k<nums.length;k++){
            int position=nums[k];
            if(position==0) nums[k]=0;
            nums[k]=a[position-1];
        }

        return nums;
    }
}
