package HashTable;

import java.util.HashMap;
import java.util.HashSet;

public class FourSum_II {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }


    //Time is O(n^2)
    //Space is O(n)
    static public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4)  {
        HashMap<Integer,Integer> map = new HashMap();
        int c=0;
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i+j,map.getOrDefault(i+j,0)+1);
            }
        }
        System.out.println(map);
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                int search = -sum;
                if(map.containsKey(search)){
                    c+=map.get(search);

                }
            }
        }
        return c;
    }
}

