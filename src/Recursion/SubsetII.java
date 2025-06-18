package Recursion;

import java.util.*;

//https://leetcode.com/problems/subsets-ii/

public class SubsetII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(subsetsWithDup(arr));
    }

    static public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        rec(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void rec(int[] arr, int idx, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = idx; i < arr.length; i++) {
            if (i != idx && arr[i] == arr[i - 1]) continue;    // If the current element is a duplicate, ignore.
            temp.add(arr[i]);
            rec(arr, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
