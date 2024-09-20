package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


//1508. Range Sum of Sorted Subarray Sums
public class RangeSum {
    static List<Long> subArraySum;
    static long modulo = 1000000007;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right));
    }


    static public int rangeSum(int[] arr, int n, int left, int right) {
        subArraySum = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = (sum + arr[j]) % modulo;
                subArraySum.add(sum);
            }
        }
        long ans = 0;
        Collections.sort(subArraySum);
        for (int i = left - 1; i < right; i++) {
            ans = (ans + subArraySum.get(i)) % modulo;
        }
        return (int) ans;
    }

    static public int rangeSum2(int[] arr, int n, int left, int right) {
        int modulo = 1000000007, ans = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{arr[i], i});
        }
        for (int i = 1; i <= right; i++) {
            int[] poll = minHeap.poll();
            if (i >= left)
                ans = (ans + poll[0]) % modulo;
            if (poll[1] < n - 1) {
                poll[0] = poll[0] + arr[++poll[1]];
                minHeap.offer(poll);
            }
        }
        return ans;
    }
}
