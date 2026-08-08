package Leetcode_75;

import java.util.*;


//1207. Unique Number of Occurrences
public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3,3};
        System.out.println(closeStrings("a","aa"));
    }

    static  public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }
        // Both strings must contain the same set of characters.
        // If a character exists in one string but not the other,it is impossible to transform one string into the other.
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0) != (freq2[i] == 0))
                return false;
        }
        // We can swap frequencies between existing characters. Therefore, only the multiset of frequencies matters.
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}
