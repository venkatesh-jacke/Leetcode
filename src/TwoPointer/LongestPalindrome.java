package TwoPointer;

//5. Longest Palindromic Substring

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));

    }

    static public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int len1 = expandFromCenter(s, i, i); //For odd length
            int len2 = expandFromCenter(s, i, i + 1);//For even length
            int len = Math.max(len1, len2); //calculate maxLen of odd and even
            if (len > maxLen) {
                maxLen = len;
                start = i - ((len - 1) / 2);
            }
        }
        return s.substring(start, start + maxLen);
    }

    static public int expandFromCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1; // why -1 ? bcz while loop terminates on next false case we only need true window case soo adjust to it
    }
}
