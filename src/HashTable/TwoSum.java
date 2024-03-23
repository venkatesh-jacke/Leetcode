package HashTable;


import java.util.Arrays;
import java.util.HashMap;


//1. Two Sum
public class TwoSum {
    public static void main(String[] args) {
        int[] arr=new int[]{2,7,11,15};
        int target=9;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }

    //Time O(n)
    //Space O(n) HashTable
    static  public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int rem= target-nums[i];
            if(map.containsKey(rem)){
                return new int[]{i,map.get(rem)};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};

    }
}
