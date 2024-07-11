package Strings;

import java.util.Stack;


//1190. Reverse Substrings Between Each Pair of Parentheses
public class ReverseParentheses {
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
        System.out.println(reverseParentheses1(s));
    }


    //Time O(n^2)  Space is 0(n)
    static public String reverseParentheses1(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (Character c : s.toCharArray()) {

            if (c == ')') {
                StringBuilder temp = new StringBuilder();
                while (st.peek() != '(')
                    temp.append(st.pop());
                st.pop();
                for (char t : temp.toString().toCharArray()) {
                    st.push(t);
                }

            } else {
                st.push(c);
            }
        }
        while (!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }

    //Wormhole Teleportation technique
    //Time O(n)  Space is 0(n)
    static public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                st.push(i);
            if (s.charAt(i) == ')') {
                int j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        for (int i = 0, dir = 1; i < n; i += dir) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                dir = -dir;
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
