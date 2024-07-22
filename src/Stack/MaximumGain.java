package Stack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//1717. Maximum Score From Removing Substrings
public class MaximumGain {



    public static void main(String[] args) {

    }

    static public int maximumGain(String s, int x, int y) {
        String high = (x > y) ? "ab" : "ba";
        int total = 0;
        String low = (high.equals("ab")) ? "ba" : "ab";
        String afterHigh = removeElements(s, high);
        int highScore = (s.length() - afterHigh.length()) / 2;
        total += Math.max(x, y) * (highScore);
        String afterLow = removeElements(afterHigh, low);
        int lowScore = (afterHigh.length() - afterLow.length()) / 2;
        total += Math.min(x, y) * (lowScore);
        return total;
    }

   static private String removeElements(String s, String target) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == target.charAt(1) && !stack.isEmpty() && stack.peek() == target.charAt(0)) {
                stack.pop();

            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
