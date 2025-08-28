package SlidingWindow;

// 2516. Take K of Each Character From Left and Right
public class TakeCharacters {

    public static void main(String[] args) {
        String str = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(str, k));
    }

    static public int takeCharacters(String s, int k) {
        int n = s.length();

        // Step 1: Count total frequency of 'a', 'b', 'c'
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Step 2: If any character occurs < k times, it's impossible
        for (int freq : count) {
            if (freq < k) return -1;
        }

        // Step 3: Sliding window to find the longest substring we can remove
        // while still leaving at least k of each character
        int minMinute = n; // initialize answer as max possible (take whole string)

        int left = 0;
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']--;
            // Step 4: If any char count outside window drops below k
            while (left <= right && (count[0] < k || count[1] < k || count[2] < k)) {
                count[s.charAt(left) - 'a']++; // put back the left char
                left++;
            }

            minMinute = Math.min(minMinute, n - (right - left + 1));
        }

        return minMinute;
    }
}
/*
(right - left + 1)  longest substring that can remove with having k chars
n - (right - left + 1) will give us the min length with k chars
 */
