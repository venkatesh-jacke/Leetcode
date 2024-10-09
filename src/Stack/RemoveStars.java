package Stack;

import java.util.Stack;

public class RemoveStars {
    public static void main(String[] args) {
        String str="leet**cod*e";
        System.out.println(removeStars(str));
    }
    static public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop()+str;
        }
        return str;
    }
}
