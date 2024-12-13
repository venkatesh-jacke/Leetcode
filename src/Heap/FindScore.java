package Heap;

import java.util.PriorityQueue;


//2593. Find Score of an Array After Marking All Elements
public class FindScore {

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 3, 2};

        System.out.println(findScore(nums));


    }

    static public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{i, nums[i]});
        }
        boolean[] marked = new boolean[n];
        long ans = 0;
        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            if (!marked[poll[0]]) {
                ans += poll[1];
                marked[poll[0]] = true;
                if (poll[0] - 1 >= 0){
                    marked[poll[0] - 1] = true;

                }
                if (poll[0] + 1 < n) {
                    marked[poll[0] + 1] = true;
                }
            }
        }
        return ans;
    }
}