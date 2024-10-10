package SlidingWindow;


import java.util.Arrays;

//962. Maximum Width Ramp
public class MaxWidthRamp {

    public static void main(String[] args) {
        int[] nums = {9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidthRamp(nums));
    }
    static public int maxWidthRamp(int[] nums) {
        int n = nums.length,res=0;
        int[] maxRight= new int[n];
        maxRight[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            maxRight[i]=Math.max(nums[i],maxRight[i+1]);
        }
        System.out.println(Arrays.toString(maxRight));
        for (int l = 0, r = 0; r < n; r++) {
            while (nums[l] > maxRight[r])
                l+=1;
            res = Math.max(res, r - l);
        }
        return res;
    }
}
