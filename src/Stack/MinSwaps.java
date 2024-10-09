package Stack;

import java.util.Stack;


//1963. Minimum Number of Swaps to Make the String Balanced
public class MinSwaps {
    public static void main(String[] args) {
        String s = "][][";
        System.out.println(minSwaps(s));
    }

    static public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int unbalanced = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    unbalanced++;
                }
            }
        }
        return (unbalanced + 1) / 2;
    }
}
