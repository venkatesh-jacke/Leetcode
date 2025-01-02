package Stack;

import java.util.*;

public class IsValidParantheses {
    public static void main(String[] args) {
        String str = "()";
        System.out.println(isValidParantheses(str));
    }

    static public boolean isValidParantheses(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && map.get(c) == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(c);

        }
        return stack.isEmpty();
    }
}
