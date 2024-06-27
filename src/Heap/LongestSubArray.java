package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;


//1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
public class LongestSubArray {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 4, 7, 2};
        int limit = 5;
        System.out.println(longestSubarray(arr, limit));
    }

    static public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int left = 0, maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            maxHeap.add(new int[]{nums[right], right});
            minHeap.add(new int[]{nums[right], right});

            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                left = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;
                while (maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }
                while (minHeap.peek()[1] < left) {
                    minHeap.poll();
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
