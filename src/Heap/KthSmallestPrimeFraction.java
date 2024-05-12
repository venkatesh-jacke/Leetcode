package Heap;


import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/k-th-smallest-prime-fraction
public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        int k = 3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr, k)));
    }

    static public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int n = arr.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> Double.compare((double) y[0] / y[1], (double) x[0] / x[1]));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println("Added "+arr[i]+"/"+arr[j]);
                maxHeap.add(new int[]{arr[i], arr[j]});
                if (maxHeap.size() > k) {
                    int[] r= maxHeap.poll();
                    System.out.println("Removed "+r[0]+"/"+r[1]);
                }
            }
        }

        return maxHeap.peek();
    }
}

/*
Added 1/2 - 0.5
Added 1/3 - 0.3
Added 1/5 - 0.2
Added 2/3 - 1.6

head is 2/3 - 1.6
Removed 2/3 - 0.6

Added 2/5 - 0.4

head is 1/2 - 0.5
Removed 1/2 - 0.2

Added 3/5 - 0.6

head is 3/5 - 0.6
Removed 3/5 - 0.6


head is 2/5 - 0.4

Return ans is [2, 5]
*/
