package Heap;


import java.util.Collections;
import java.util.PriorityQueue;

//1046. Last Stone Weight
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));
    }


    //Time is O(NlogN)
    //Space is O(logN) height of binary tree
    static public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) pq.add(i);
        while (pq.size() > 1)
            pq.add(pq.poll() - pq.poll());
        return pq.poll();
    }
}
