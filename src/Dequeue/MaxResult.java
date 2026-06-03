package Dequeue;

//1696. Jump Game VI

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxResult {
    public static void main(String[] args) {
        int[] arr = new int[]{1, -1, -2, 4, -7, 3};
        int k = 2;
        System.out.println(maxResult(arr, k));
    }

    static public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0);
        for (int i = 1; i < n; i++) {
            //Remove indices outside window
            if (dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            // Front has maximum dp value
            dp[i] = nums[i] + dp[dq.peekFirst()];
            // Maintain decreasing dp order
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }
            // Add current index
            dq.offerLast(i);
        }
        // Maximum score to reach last index
        return dp[n - 1];
    }
}
