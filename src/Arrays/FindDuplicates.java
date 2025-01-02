package Arrays;

import java.util.*;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(findDuplicates(arr));
    }

    static public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        //System.out.println(Arrays.toString(nums));
        for ( i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }
        return res; // Not expected to reach here
    }
}
