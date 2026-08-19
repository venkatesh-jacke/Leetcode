package SlidingWindow;

//3090. Maximum Length Substring With Two Occurrences

public class MaximumLengthSubstring {
    public static void main(String[] args) {
        String s = "bcbbbcba";
        System.out.println(maximumLengthSubstring(s));
    }

    static public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int res = 0;
        for (int left = 0, right = 0; right < n; right++) {
            int ch = s.charAt(right) - 'a';
            freq[ch]++;
            while (freq[ch] > 2) {
                int leftChar = s.charAt(left) - 'a';
                freq[leftChar]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
