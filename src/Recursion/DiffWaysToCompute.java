package Recursion;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }

    static public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> res = new ArrayList<>();
        if (exp.length() == 0)
            return res;
        if (exp.length() == 1) {
            res.add(Integer.parseInt(exp));
            return res;
        }
        if (exp.length() == 2 && Character.isDigit(exp.charAt(0))) {
            res.add(Integer.parseInt(exp));
            return res;
        }
        for (int i = 0; i < exp.length(); i++) {
            char currentChar = exp.charAt(i);
            if (Character.isDigit(currentChar))
                continue;
            List<Integer> leftRes = diffWaysToCompute(exp.substring(0, i));
            List<Integer> rightRes = diffWaysToCompute(exp.substring(i + 1));
            for (int leftValue : leftRes) {
                for (int rightValue : rightRes) {
                    int computedRes = 0;
                    switch (currentChar) {
                        case '+':
                            computedRes = leftValue + rightValue;
                            break;
                        case '-':
                            computedRes = leftValue - rightValue;
                            break;
                        case '*':
                            computedRes = leftValue * rightValue;
                            break;
                    }
                    res.add(computedRes);
                }
            }
        }
        return res;
    }
}
