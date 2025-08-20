package SlidingWindow;

//424. Longest Repeating Character Replacement

public class CharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    static public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int maxLen = 0, maxFreq = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);
            hash[cur - 'A']++;
            maxFreq = Math.max(maxFreq, hash[cur - 'A']);
            // changes = (r - l + 1) - maxFreq;
            if ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                for (int f : hash) {
                    maxFreq = Math.max(maxFreq, f);
                } // for loop not needed
                l++;
            }
            maxLen = Math.max(maxLen, (r - l + 1));
        }
        return maxLen;
    }
}
