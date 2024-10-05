package HashTable;

import java.util.*;

public class FindAnagrams {
    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";
        System.out.println(findAnagrams(s, p));
    }

    static public List<Integer> findAnagrams(String s, String p) {
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int windowSize = p.length();
        for (int i = 0; i < windowSize; i++) {
            freqP[s.charAt(i) - 'a']++;
            freqS[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s.length() - windowSize; i++) {
            if (matches(freqS, freqP)) {
                res.add(i);
            }
            if ((i + windowSize) < s.length()) {
                freqS[s.charAt(i + windowSize) - 'a']++;
                freqS[s.charAt(i) - 'a']--;
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
