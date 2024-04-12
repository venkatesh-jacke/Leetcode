package Strings;

import java.util.Arrays;

public class RestoreString {
    public static void main(String[] args) {
        String str = "codeleet";
        int[] arr = new int[]{4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(restoreString(str, arr));

    }

    static public String restoreString(String s, int[] indices) {
        char[] ca = new char[s.length()];
        System.out.println(Arrays.toString(ca));
        for (int i = 0; i < indices.length; i++) {
            ca[indices[i]] = s.charAt(i);
        }
        return new String(ca);
    }
}
