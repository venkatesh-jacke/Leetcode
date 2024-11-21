package Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;


//862. Shortest Subarray with Sum at Least K
public class ShortestSubArray {
    public static void main(String[] args) {
        int[] arr = {2, -1, 2, 1, -4, 3, 4, 1};
        int k = 5;
        System.out.println(shortestSubarray(arr, k));

    }
    static  public int shortestSubarray(int[] arr, int k) {
        int n = arr.length;
        long res = n + 1;
        long cur_sum = 0;
        Deque<long[]> dq= new ArrayDeque<>();
        //long[0]-cur_sum long[1]-endingIndex

        for (int r = 0; r < n; r++) {
            cur_sum += arr[r];
            if (cur_sum >= k)
                res = Math.min(res, r + 1);
            //find minimum valid window ending at r
            while(!dq.isEmpty() && cur_sum-dq.peekFirst()[0]>=k){
                res=Math.min(res,r-dq.pollFirst()[1]);
            }
            //validate the monotonic deque
            while(!dq.isEmpty()&& dq.peekLast()[0]>cur_sum){
                dq.pollLast();
            }
            dq.offer(new long[]{cur_sum,r});

        }
        return res == n + 1 ? -1 : (int) res;
    }
}
