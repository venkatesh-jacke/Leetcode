package Heap;

import java.util.PriorityQueue;

public class MaxKElements {
    public static void main(String[] args) {

    }
    static  public long maxKelements(int[] nums, int k) {
        long res = 0;
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for (long i : nums) {
            maxHeap.add(i);
        }
        while (k-- > 0) {
            long poll = maxHeap.poll();
            res += poll;
            maxHeap.add((long) Math.ceil(poll / 3));
        }
        return res;
    }
}
