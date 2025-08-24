package SlidingWindow;

//1493. Longest Subarray of 1's After Deleting One Element

public class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};
        System.out.println(longestSubarray(nums));
    }

    static public int longestSubarray(int[] arr) {
        int n = arr.length, zeroes = 0, ans = 0, left = 0;
        for (int right = 0; right < n; right++) {
            if (arr[right] == 0) zeroes += 1;
            while (zeroes > 1) {
                if (arr[left] == 0) zeroes -= 1;
                left += 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans - 1;
    }
}
