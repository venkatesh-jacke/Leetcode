package HashTable;

import java.util.HashMap;

public class subarraySum {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        int k=3;
        System.out.println(subarraySum(nums,k));
    }
    static int subarraySum(int[] nums, int k) {
        int ans=0;
        int cur_sum=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        for(int i:nums){
            cur_sum+=i;
            int diff=cur_sum-k;
            ans+=map.getOrDefault(diff,0);
            map.put(cur_sum,map.getOrDefault(diff,0)+1);
        }
        return ans;
    }
}
