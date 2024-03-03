package Stack;

import java.util.ArrayList;
import java.util.Stack;


//1021. Remove Outermost Parentheses
public class RemoveOuterParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
        System.out.println(removeOuterParentheses2(s));
    }


    //Time Complexity O(n)
    //Space Complexity O(m) m is length of result string
    static public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ) {
                if(!stack.isEmpty()) sb.append(s.charAt(i));
                stack.push(s.charAt(i));
            }
            else{
                stack.pop();
                if(!stack.isEmpty()) sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }


    static public String removeOuterParentheses2(String s) {
        String res="";
        int open=0;
        for(char c:s.toCharArray()){
            //value is used and than incremented --postIncrement
            if(c=='('&& open++ > 0) res+=c; //chk if it's not the outermost parenthesis which means empty
            if(c==')'&& open-- > 1) res+=c; //add all elements until open becomes 0
        }
        return res;
    }
}
/*
Intuition:-

If the stack size is greater than zero after pushing or popping,
it means that the parenthesis is not an outer parenthesis, and it is added to the result string.
If the stack size is zero, it means that the parenthesis is an outer parenthesis and it is not added to the result string.

*/
