package Stack;

//1415. The k-th Lexicographical String of All Happy Strings of Length n

import java.util.Stack;

public class GetHappyString {

    public static void main(String[] args) {
        int n = 3;
        int k = 9;
        System.out.println(getHappyString(n, k));
    }

    static public String getHappyString(int n, int k) {
        Stack<String> stack = new Stack<>();
        stack.push("");
        int count = 0;
        while (!stack.isEmpty()) {
            String cur = stack.pop();
            if (cur.length() == n) {
                count++;
                if (count == k) {
                    return cur;
                }
                continue;
            }
            for (char ch : new char[]{'c','b','a'}) {
                if (cur.length() == 0 || cur.charAt(cur.length() - 1) != ch) {
                    stack.push(cur + ch);
                }
            }
        }
        return "";
    }


}
