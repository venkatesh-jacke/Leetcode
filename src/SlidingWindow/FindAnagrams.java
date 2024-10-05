package SlidingWindow;

import java.util.*;


//438. Find All Anagrams in a String
public class FindAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    static public List<Integer> findAnagrams(String s, String p) {
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length())
            return res;
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }
        int windowSize = p.length();
        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
            if (matches(freqS, freqP)) {
                res.add(i);
            }
            if (i >= windowSize) {
                freqS[s.charAt(i - windowSize) - 'a']--;
            }

        }
        return res;
    }

    static public boolean matches(int[] f1, int[] f2) {
        for (int i = 0; i < 26; i++) {
            if (f1[i] != f2[i])
                return false;
        }
        return true;
    }
}
