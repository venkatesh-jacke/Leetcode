package Strings;

import java.util.Arrays;


//2559. Count Vowel Strings in Ranges
public class VowelStrings {
    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    static public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] prefix = new int[words.length];
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            count += ("aeiou".indexOf(words[i].charAt(0)) != -1 && "aeiou".indexOf(words[i].charAt(words[i].length() - 1)) != -1) ? 1 : 0;
            prefix[i] = count;
        }
        System.out.println(Arrays.toString(prefix));
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = l == 0 ? prefix[r] : prefix[r] - prefix[l - 1];

        }
        return ans;
    }

}
