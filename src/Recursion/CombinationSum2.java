package Recursion;

//https://leetcode.com/problems/combination-sum-ii/

import java.util.*;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(arr, target));


    }

    static public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        rec(arr, target, 0, new ArrayList<>(), res);
        return res;
    }

    static public void rec(int[] arr, int target, int idx, List<Integer> temp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] <= target) {
                temp.add(arr[i]);
                rec(arr, target - arr[i], i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
