package Leetcode_75;

import java.util.Stack;

//334. Increasing Triplet Subsequence
public class IncreasingTriplet {
    public static void main(String[] args) {
        int[] arr = {6,7,1,2};
        System.out.println(increasingTriplet(arr));
    }

    static public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i:nums){
            if(i<=first){
                first = i;
            }
            else if(i<=second){
                second = i;
            }
            // first < second < i
            else{
                return true;
            }
        }
        return false;
    }
}
