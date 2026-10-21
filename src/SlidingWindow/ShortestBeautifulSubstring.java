package SlidingWindow;

//2904. Shortest and Lexicographically Smallest Beautiful String

public class ShortestBeautifulSubstring {
    public static void main(String[] args) {
        String s = "100011001";
        int k = 3;
        System.out.println(shortestBeautifulSubstring(s, k));
    }

    static public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int count = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            // Add current character to the window
            count += s.charAt(r) == '1' ? 1 : 0;
            // We have exactly k ones
            while (count == k) {
                String current = s.substring(l, r + 1);
                if (ans.isEmpty() || current.length() < ans.length() || (current.length() == ans.length() && current.compareTo(ans) < 0)) {
                    ans = current;
                }
                // Remove the left character
                if (s.charAt(l) == '1') {
                    count--;
                }
                l++;
            }
        }
        return ans;
    }
}
