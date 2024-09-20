package Memoization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//241. Different Ways to Add Parentheses
public class DiffWaysToCompute {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }

    static public List<Integer> diffWaysToCompute(String exp) {
        int n = exp.length();

        List<Integer>[][] cache = new ArrayList[exp.length()][exp.length()];

        List<Integer> result = computeResults(exp, cache, 0, n - 1);
        for (List<Integer>[] list : cache)
            System.out.println(Arrays.toString(list));
        return result;
    }

    static private List<Integer> computeResults(String expression, List<Integer>[][] cache, int start, int end) {
        if (cache[start][end] != null) {
            return cache[start][end];
        }
        List<Integer> result = new ArrayList<>();
        if (start == end) {
            result.add(expression.charAt(start) - '0');
            return result;
        }
        if (end - start == 1 && Character.isDigit(expression.charAt(start))) {
            int tens = expression.charAt(start) - '0';
            int ones = expression.charAt(end) - '0';
            result.add(10 * tens + ones);
        }
        for (int i = start; i <= end; i++) {
            char currentChar = expression.charAt(i);
            if (Character.isDigit(currentChar)) continue;
            List<Integer> leftResult = computeResults(expression, cache, start, i - 1);
            List<Integer> rightResult = computeResults(expression, cache, i + 1, end);
            for (int leftValue : leftResult) {
                for (int rightValue : rightResult) {
                    switch (currentChar) {
                        case '+':
                            result.add(leftValue + rightValue);
                            break;
                        case '-':
                            result.add(leftValue - rightValue);
                            break;
                        case '*':
                            result.add(leftValue * rightValue);
                            break;
                    }
                }
            }
        }
        cache[start][end] = result;
        return result;
    }
}
