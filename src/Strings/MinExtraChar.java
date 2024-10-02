package Strings;

public class MinExtraChar {
    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        System.out.println(minExtraChar(s, dictionary));
    }

    static public int minExtraChar(String s, String[] dictionary) {
        for (String str : dictionary) {
            if (s.contains(str)) {
                s = s.replace(str, "");
            }

        }
        return s.length();
    }
}
