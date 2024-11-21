package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;


//862. Shortest Subarray with Sum at Least K
public class ShortestSubarray {
    public static void main(String[] args) {
        int[] arr = {2, -1, 2, 1, -4, 3, 4, 1};
        int k = 5;
        System.out.println(shortestSubarray(arr, k));
    }

    static public int shortestSubarray(int[] arr, int k) {
        int n = arr.length;
        long res = n + 1;
        long cur_sum = 0;
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        //long[0]-cur_sum long[1]-endingIndex

        for (int r = 0; r < n; r++) {
            cur_sum += arr[r];
            // Check if the subarray from the beginning to the current index satisfies the condition
            if (cur_sum >= k) {
                res = Math.min(res, r + 1); //since 0 index its r+1
            }

            // Check if we can remove elements to get a valid subarray.
            while (!minHeap.isEmpty() && cur_sum - minHeap.peek()[0] >= k) {
                res = Math.min(res, r - minHeap.poll()[1]);
            }
            // Add the current prefix sum and index to the heap.
            minHeap.offer(new long[]{cur_sum, r});
        }
        return res == n + 1 ? -1 : (int) res;
    }
}
