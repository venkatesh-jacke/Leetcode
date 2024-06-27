package Leetcode_75;


//1493. Longest Subarray of 1's After Deleting One Element
public class LongestSubArray {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(longestSubarray(arr));
    }

    static public int longestSubarray(int[] arr) {
        int n = arr.length, zeroes = 0, ans = 0, left = 0;
        for (int right = 0; right < n; right++) {
            if (arr[right] == 0) zeroes += 1;
            while (zeroes > 1) {
                if (arr[left] == 0) zeroes -= 1;
                left += 1;
            }
            ans = Math.max(ans, (right - left + 1));
        }
        return ans - 1;// -1 because we are deleting one element in a subArray so window size - 1
    }
}
