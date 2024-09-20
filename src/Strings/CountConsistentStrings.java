package Strings;

import java.util.Arrays;

public class CountConsistentStrings {
    public static void main(String[] args) {
        String allowed = "abc";
        String words[] = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println(countConsistentStrings(allowed, words));
    }

    static public int countConsistentStrings(String allowed, String[] words) {
        int[] allowedMap = new int[26];
        int count = 0;
        for (char i : allowed.toCharArray()) {
            allowedMap[i - 'a']++;
        }
        System.out.println(Arrays.toString(allowedMap));
        for (String word : words) {
            boolean flag = true;
            for (char c : word.toCharArray()) {
                if (allowedMap[c - 'a'] == 0) {
                    flag = false;
                }
            }
            count = flag ? count + 1 : count;

        }
        return count;
    }
}
