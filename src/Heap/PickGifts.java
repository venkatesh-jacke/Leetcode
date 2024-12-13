package Heap;

import java.util.PriorityQueue;

public class PickGifts {
    public static void main(String[] args) {
        //int[] gifts = {25, 64, 9, 4, 100};
        int[] gifts = {1, 1, 1, 1};
        int k = 4;
        System.out.println(pickGifts(gifts, k));
    }

    static public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i : gifts) {
            maxHeap.offer(i);
        }

        while (k-- > 0) {
            int poll = maxHeap.poll();
            int sqrt = (int) Math.floor(Math.sqrt(poll));
            if (sqrt < poll) {
                maxHeap.offer(sqrt);
            } else {
                maxHeap.offer(poll);
            }
        }
        long ans = 0;
        while (!maxHeap.isEmpty()) {
            ans += maxHeap.poll();
        }
        return ans;
    }
}
