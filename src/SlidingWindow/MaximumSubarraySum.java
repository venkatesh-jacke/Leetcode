package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(maximumSubarraySum(arr, k));
    }

    static public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long cur_sum = 0;
        int n = nums.length;
        int start = 0, end = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (end < n) {
            int currNum = nums[end];
            int lastOccurrence = map.getOrDefault(currNum, -1);
            // if current window already has number or if window is too big, adjust window
            while (start <= lastOccurrence || (end - start + 1) > k) {
                cur_sum -= nums[start];
                start++;
            }
            map.put(currNum, end);
            cur_sum += nums[end];
            //check exact window size
            if (end - start + 1 == k) {
                ans = Math.max(ans, cur_sum);
            }
            end++;
        }
        return ans;
    }
    static public long maximumSubarraySum2(int[] nums, int k) {
        long ans = 0;
        long cur_sum = 0;
        int n = nums.length;
        int left = 0;
        HashSet<Integer> set= new HashSet<>();
        for(int right=0;right<n;right++){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                cur_sum-=nums[left];
                left++;
            }
            set.add(nums[right]);
            cur_sum+=nums[right];
            if(right-left+1==k){
                ans=Math.max(ans,cur_sum);
                set.remove(nums[left]);
                cur_sum-=nums[left];
                left++;
            }
        }

        return ans;
    }
}
