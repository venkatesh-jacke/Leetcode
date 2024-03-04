package Stack;


import java.util.Stack;

//1614. Maximum Nesting Depth of the Parentheses
public class MaxDepth {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
        System.out.println(maxDepth2(s));
    }


    //Time Complexity O(n)
    // Space complexity O(n) size of stack
    static public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = -1;
        int c = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') {
                c++;
                stack.push(i);

            }
            if (i == ')' && stack.peek() == '(') {
                c--;
                stack.pop();
            }
            ans = Math.max(c, ans);
        }
        return ans;
    }


    //Time Complexity O(n)
    // Space complexity O(1) size of stack
    static public int maxDepth2(String s) {
        int ans = Integer.MIN_VALUE;
        int c = 0;
        for (char i : s.toCharArray()) {
            if (i == '(') c++;
            if (i == ')' ) c--;
            ans = Math.max(c, ans);
        }
        return ans;
    }
}





/*
Intuition

if '(' we push and increment the count
if ')' we pop when top=='(' and decrement the count
store the max value of count and return

*/
