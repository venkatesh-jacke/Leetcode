package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;


//2974. Minimum Number Game
public class NumberGame {
    public static void main(String[] args) {
        int[] arr={5,4,2,3};
        System.out.println(numberGame(arr));
    }

     //Swapping adjacent indices after sorting the array
    static public int[] numberGame(int[] nums) {
         Arrays.sort(nums);
         for (int i = 0; i < nums.length - 1; i += 2) {
             int temp = nums[i];
             nums[i] = nums[i + 1];
             nums[i + 1] = temp;
         }
         return nums;
     }


    //Priority Queue  Time O(NlogN) Space O(n)
    static public int[] numberGame2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i:nums) pq.add(i);
        for (int i = 0; i < nums.length - 1; i += 2) {
            nums[i+1]=pq.poll();
            nums[i]=pq.poll();
        }
        return nums;
    }
}
