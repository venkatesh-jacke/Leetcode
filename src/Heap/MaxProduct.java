package Heap;

import java.util.Collections;
import java.util.PriorityQueue;


//1464. Maximum Product of Two Elements in an Array
public class MaxProduct {
    public static void main(String[] args) {
        int[] arr={3,4,5,2};
        System.out.println(maxProduct(arr));
    }

    static public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums) pq.add(i);
        return (pq.poll()-1)*(pq.poll()-1);
    }

    //Time is O(NlogN) space is O(N)
   static public int maxProduct2(int[] nums) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums) pq.add(i);
        return (pq.poll()-1)*(pq.poll()-1);
    }
}
