package Arrays;

import java.util.Arrays;

public class FindErrorNums {
    public static void main(String[] args) {
        int[] arr = {8, 7, 3, 5, 3, 6, 1, 4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    static public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int res[] = new int[2];
        int i = 0;
        while (i < n) {

            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(i=0;i<n;i++){
            if(nums[i]!=i+1){
                res[0]=nums[i];
                res[1]=i+1;
            }
        }
        return res;
    }
}
