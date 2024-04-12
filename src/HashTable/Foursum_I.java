package HashTable;

import javafx.util.Pair;

import java.util.*;

public class Foursum_I {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296));
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));

    }





    static public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for (int j = i + 1; j < n; j++) {
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int start=j+1;
                int end= n-1;
                while(end<n && start<end){
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        start++;
                        end--;
                        while ( start < end && nums[start] == nums[start -1]) start++;
                        while (start < end && nums[end] == nums[end + 1]) end--;
                    }
                    else if(sum<target){
                        start++;
                    }
                    else{
                        end--;
                    }

                }
            }
        }

        return res;
    }



}
