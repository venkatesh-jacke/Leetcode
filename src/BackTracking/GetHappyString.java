package BackTracking;

//1415. The k-th Lexicographical String of All Happy Strings of Length n

import java.util.ArrayList;
import java.util.Collections;

public class GetHappyString {

    public static void main(String[] args) {
        int n = 1;
        int k = 3;
        System.out.println(getHappyString(n, k));
    }

    static public String getHappyString(int n, int k) {
        int[] count = new int[1];
        String[] result = new String[1];
        backtrack(n, k, count, new StringBuilder(), ' ', result);
        return (result[0] == null) ? "" : result[0];
    }

    private static void backtrack(int n, int k, int[] count, StringBuilder temp, char lastChar, String[] result) {
        if (temp.length() == n) {
            count[0]++;
            if (count[0] == k) {
                result[0] = temp.toString();
            }
            return;
        }
        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (ch != lastChar) {
                temp.append(ch);
                backtrack(n, k, count, temp, ch, result); // recursive
                temp.deleteCharAt(temp.length() - 1); //backtrack
                if (result[0] != null) return;

            }
        }
    }


}
