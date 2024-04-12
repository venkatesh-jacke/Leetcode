package Strings;

public class BalancedStringSplit {
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }


    //TC O(n)
    //SC O(1)
    static public int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;
        int c = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') l++;
            if (ch == 'R') r++;
            if (l == r) c++;
        }
        return c;
    }
}
