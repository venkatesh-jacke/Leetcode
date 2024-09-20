package BitManipulation;

import java.util.Arrays;

public class CountConsistentStrings {
    public static void main(String[] args) {
        String allowed = "abc";
        String words[] = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println(countConsistentStrings(allowed, words));
    }

    static public int countConsistentStrings(String allowed, String[] words) {
        int bitMask = 0;
        int count = words.length;
        for (char i : allowed.toCharArray()) {
            int bit = 1 << (i - 'a');
            bitMask = bitMask | bit;
        }
        for (String word : words) {
            for (char c : word.toCharArray()) {
                int bit = 1 << (c - 'a');
                if ((bitMask & bit) == 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
