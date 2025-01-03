import java.util.*;
import java.util.HashMap;

class Main {


    public static void main(String[] args) {

        System.out.println(waysToSplitArray(new int[]{9,9,9}));
    }

    static public int waysToSplitArray(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int leftSum = 0;
            for (int j = i; j <= i; j++) {
                leftSum += nums[j];
            }
            int rightSum = 0;
            for (int k = i + 1; k < nums.length; k++) {
                rightSum += nums[k];
            }
            if (leftSum > rightSum) ans++;
        }
        return ans;
    }


}
