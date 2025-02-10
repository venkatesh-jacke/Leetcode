package Stack;

//3174. Clear Digits

import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        String s = "cb34";
        System.out.println(clearDigits(s));
    }

    static public String clearDigits(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
