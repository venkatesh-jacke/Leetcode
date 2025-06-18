package Recursion;

import java.util.*;

//39. Combination Sum
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(arr, target));
    }

    static public List<List<Integer>> combinationSum(int[] arr, int target) {

        List<List<Integer>> res = new ArrayList<>();
        findCombination(arr, target, 0, new ArrayList<>(), res);
        return res;
    }

    static public void rec(int[] arr, int target, int idx, List<Integer> temp, List<List<Integer>> res) {
        if (idx == arr.length) {
            if (target == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (arr[idx] <= target) {
            temp.add(arr[idx]);
            rec(arr, target - arr[idx], idx, temp, res);
            temp.remove(temp.size() - 1);
        }
        rec(arr, target, idx + 1, temp, res);
    }
    static public void findCombination(int[] arr, int target, int idx, List<Integer> temp, List<List<Integer>> res) {
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(arr[i]<=target){
                temp.add(arr[i]);
                findCombination(arr,target-arr[i],i,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }
}
