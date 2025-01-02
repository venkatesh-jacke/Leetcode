package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//3264. Final Array State After K Multiplication Operations I
public class GetFinalState {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;
        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }

    static public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(i);
        }
        while (k-- > 0) {
            int minIdx = minHeap.poll();
            nums[minIdx] = nums[minIdx] * multiplier;
            minHeap.offer(minIdx);
        }
        return nums;
    }
}
