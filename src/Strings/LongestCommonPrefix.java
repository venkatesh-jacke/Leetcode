package Strings;

import java.util.Arrays;
import java.util.Comparator;


//14. Longest Common Prefix
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String strs[] = {"abab","aba","abc"};
        System.out.println(longestCommonPrefix(strs));
    }

    static public String longestCommonPrefix(String[] strs)  {
        int i = 0;
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        while (i < minLen) {
            for (String str : strs) {
                if (str.charAt(i) != strs[0].charAt(i))
                    return str.substring(0, i);
            }
            i++;
        }
        return strs[0].substring(0, i);
    }

}
