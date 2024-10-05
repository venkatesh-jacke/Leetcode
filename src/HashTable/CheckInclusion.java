package HashTable;

import java.util.Arrays;


//567. Permutation in String

public class CheckInclusion {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2));
    }

   static public boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length()))))
                return true;
        }
        return false;
    }


    static public String sort(String s) {
        char[] t= s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}
