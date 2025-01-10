package Strings;


import java.util.*;

//916. Word Subsets
public class WordSubsets {
    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        System.out.println(wordSubsets(words1, words2));
    }

    static public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[] maxFreqWords2 = new int[26];
        for (String s : words2) {
            int[] freq = countFreq(s);
            for (int i = 0; i < 26; i++) {
                maxFreqWords2[i] = Math.max(maxFreqWords2[i], freq[i]);
            }
        }

        for (String s : words1) {
            int[] freq = countFreq(s);
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreqWords2[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) res.add(s);
        }

        return res;
    }

    static public int[] countFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }


}
