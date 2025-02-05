package HashTable;


//1790. Check if One String Swap Can Make Strings Equal

import java.util.Arrays;

public class AreAlmostEqual {
    public static void main(String[] args) {
        String s1 = "bf";
        String s2 = "dd";
        System.out.println(areAlmostEqual(s1, s2));
    }

    static public boolean areAlmostEqual(String s1, String s2) {
        if (s1 == s2 || s1.length() != s2.length())
            return true;
        int diff = 0;
        char[] f1 = new char[26];
        char[] f2 = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                diff++;
                if (diff > 2)
                    return false;
            }
            f1[c1 - 'a']++;
            f2[c2 - 'a']++;
        }
        return Arrays.equals(f1, f2);

    }
}
