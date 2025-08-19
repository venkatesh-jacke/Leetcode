package TwoPointer;

//76. Minimum Window Substring

public class MinWindow {
    public static void main(String[] args) {

    }
    static public String minWindow(String s, String t) {
        int[] hash = new int[256];
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, startIdx = 0;
        while (r < s.length()) {
            hash[s.charAt(r)]--;
            while (isValid(hash)) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }
                hash[s.charAt(l)]++;
                l++;
            }
            r++;
        }
        return minLen != Integer.MAX_VALUE ? s.substring(startIdx, startIdx + minLen) : "";
    }

    static public boolean isValid(int[] hash) {
        for (int i : hash) {
            if (i > 0)
                return false;
        }
        return true;
    }
}
