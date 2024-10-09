package Stack;


import java.util.Stack;

//2696. Minimum String Length After Removing Substrings
public class MinLength {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(minLength(s));
    }


    //Time Complexity is O(n)
    static public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }
            if (cur == 'B' && stack.peek() == 'A') {
                stack.pop();
            } else if (cur == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }
        return stack.size();
    }
}
