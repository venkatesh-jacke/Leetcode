package Stack;

import java.util.Stack;

public class MinInsertions {
    public static void main(String[] args) {
        String s = ")))))))";
        System.out.println(minInsertions(s));
    }

    static  public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertion = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {

                if (i + 1 < s.length() && s.charAt(i + 1) == ')')
                    i++;
                else
                    insertion++;
                if (stack.isEmpty())
                    insertion++;
                else
                    stack.pop();
            }
        }
        insertion += 2 * stack.size();
        return insertion;
    }

    static  public int minInsertions_count(String s) {
        int open = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // Consume the next ')'
                } else {
                    insertions++; // Need to insert a ')'
                }

                if (open > 0) {
                    open--;
                } else {
                    insertions++; // Need to insert a '('
                }
            }
        }

        insertions += 2 * open; // Add 2 ')' for each remaining '('
        return insertions;
    }
}
