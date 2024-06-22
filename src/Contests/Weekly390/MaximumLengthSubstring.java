package Contests.Weekly390;

import java.util.HashMap;

public class MaximumLengthSubstring {
    public static void main(String[] args) {
        String s = "bcbbbcba";
        System.out.println(maximumLengthSubstring(s));
    }

    static public int maximumLengthSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLen = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();

        while (right < n) {
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
            while (charCount.get(rightChar) > 2) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }


        return maxLen;
    }
}
