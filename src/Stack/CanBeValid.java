package Stack;

import java.util.Stack;

//2116. Check if a Parentheses String Can Be Valid
public class CanBeValid {
    public static void main(String[] args) {
        String s = "()()";
        String locked = "0000";
        System.out.println(canBeValid(s, locked));
    }

    static public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false;
        Stack<Integer> open = new Stack<>();
        Stack<Integer> unLocked = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                unLocked.push(i);
            } else if (s.charAt(i) == '(') {
                open.push(i);
            } else {
                if (!open.isEmpty()) {
                    open.pop(); // Pair with an opening parenthesis
                } else if (!unLocked.isEmpty()) {
                    unLocked.pop();  //use unLocked position
                } else {
                    return false; // No opening parenthesis available
                }
            }
        }

        // Second pass: Resolve remaining unmatched opening parentheses
        while (!open.isEmpty() && !unLocked.isEmpty()) {
            if (open.peek() < unLocked.peek()) {
                open.pop();
                unLocked.pop();
            } else {
                return false; // Invalid if unLocked position is before the opening parenthesis
            }
        }
        return open.isEmpty();
    }

    static public boolean canBeValid2(String s, String locked) {
        int open = 0;
        int n = s.length();
        if(n%2==1) return false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                open++;
            } else {
                open--;
            }
            if (open < 0) {
                return false;
            }
        }
        int close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                close++;
            } else {
                close--;
            }
            if (close < 0) {
                return false;
            }
        }
        return true;
    }
}
