package Arrays;

import java.util.List;

public class LongestSubArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,2,2};

        System.out.println(longestSubarray(nums));
    }

    static public int longestSubarray(int[] nums) {
        int maxVal=Integer.MIN_VALUE;
        for(int i:nums) maxVal= Math.max(maxVal,i);
        int res=0,len=0;
        for(int i:nums){
            if(i==maxVal) {
                len++;
                res=Math.max(res,len);
            }
            else {
                len=0;
            }
        }
        return res;

    }

}
