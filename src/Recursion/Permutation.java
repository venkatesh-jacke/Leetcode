package Recursion;

//https://leetcode.com/problems/permutations/description/

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }

    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, new ArrayList<>(), res);
        return res;
    }

    public static void backTrack(int[] arr, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == arr.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (temp.contains(arr[i])) continue;
            temp.add(arr[i]);
            backTrack(arr, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}