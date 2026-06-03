package Heap;

//1696. Jump Game VI

import java.util.PriorityQueue;

public class MaxResult {
    public static void main(String[] args) {
        int[] arr = new int[]{1, -1, -2, 4, -7, 3};
        int k = 2;
        System.out.println(maxResult(arr,k));
    }

    static public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        //index,value
        //[index, bestScoreTillThatIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>(((a, b) -> b[1] - a[1]));
        pq.offer(new int[]{0, max});
        for (int i = 1; i < n; i++) {
            //Remove indices outside jump range  if (i - oldIndex > k) then that index cannot reach current i
            while (i - pq.peek()[0] > k) {
                pq.poll();
            }
            //Best previous reachable position
            int[] top = pq.peek();
            // nums[i] + maximum reachable previous score
            max = nums[i] + top[1];
            // Store current index and its best score
            pq.offer(new int[]{i, max});
        }

        return max;
    }
}
