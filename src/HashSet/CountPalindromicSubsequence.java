package HashSet;

import java.util.*;


//1930. Unique Length-3 Palindromic Subsequences
public class CountPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));
    }

    static public int countPalindromicSubsequence(String s) {
        int count = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray())
            set.add(c);

        for (char c : set) {
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            Set<Character> middleChars = new HashSet<>();
            if (first != last) {
                for (int i = first + 1; i < last; i++) {
                    middleChars.add(s.charAt(i));
                }
            }
            count += middleChars.size();

        }
        return count;
    }

    static public int countPalindromicSubsequence2(String s) {
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (first[cur] == -1) {
                first[cur] = i;
            }
            last[cur] = i;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1)
                continue;
            Set<Character> middle = new HashSet<>();
            for (int j = first[i] + 1; j < last[i]; j++) {
                middle.add(s.charAt(j));
            }
            count += middle.size();
        }
        return count;
    }
}
