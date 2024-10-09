package Strings;

import java.util.Stack;


//921. Minimum Add to Make Parentheses Valid
public class MinAddToMakeValid {
    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));
    }

    static public int minAddToMakeValid(String s) {
        int open = 0, min = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else {
                if (open > 0) open--;
                else min++;
            }
        }
        return open + min;
    }
}
