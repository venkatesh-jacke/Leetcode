package Strings;


//3517. Smallest Palindromic Rearrangement I

import java.util.Arrays;
import java.util.TreeMap;

public class SmallestPalindrome {
    public static void main(String[] args) {
        String  s = "daccad";
        System.out.println(smallestPalindrome(s));
    }
    static public String smallestPalindrome(String s) {
        int len = s.length();
        int partition = len / 2;
        char[] ca = s.toCharArray();
        Arrays.sort(ca, 0, partition);
        for (int i = 0; i < partition; i++) {
            ca[len - 1 - i] = ca[i];
        }
        return new String(ca);
    }
}
