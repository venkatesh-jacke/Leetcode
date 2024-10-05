package Leetcode_75;

import java.util.*;


//2215. Find the Difference of Two Arrays
public class FindDifference {
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int[] a2 = {2, 4, 6};
        System.out.println(findDifference(a1, a2));
    }

    static public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) set1.add(i);
        for (int i : nums2) set2.add(i);
        for(int i:set1){
            if(!set2.contains(i)){
                res.get(0).add(i);
            }
        }
        for(int i:set2){
            if(!set1.contains(i)){
                res.get(1).add(i);
            }
        }
        return res;
    }
}
