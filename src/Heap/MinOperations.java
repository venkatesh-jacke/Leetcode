package Heap;

import java.util.PriorityQueue;

//3066. Minimum Operations to Exceed Threshold Value II
public class MinOperations {
    public static void main(String[] args) {
        int[] arr = {1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999};
        int k = 1000000000;
        System.out.println(minOperations(arr, k));
    }

    static public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (long i : nums) {
            minHeap.offer(i);
        }
        int count = 0;
        while (!minHeap.isEmpty() && minHeap.size() > 1 && minHeap.peek() < k) {
            long x = minHeap.poll();
            long y = minHeap.poll();
            minHeap.offer((x * 2) + y);
            count++;
        }
        return count;
    }
}
