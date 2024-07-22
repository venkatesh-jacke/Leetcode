package Stack;


import javafx.util.Pair;

import java.util.*;

//726. Number of Atoms
public class CountOfAtoms {
    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2";
        System.out.println(countOfAtoms(formula));
    }

    static class ElementCount {
        String element;
        int count;

        ElementCount(String element, int count) {
            this.element = element;
            this.count = count;
        }

        @Override
        public String toString() {
            return this.element + ":" + this.count;
        }
    }

    static public String countOfAtoms(String formula) {
        int len = formula.length();
        Stack<ElementCount> stack = new Stack<>();
        TreeMap<String, Integer> map = new TreeMap();
        int i = 0;
        while (i < len) {
            char cur = formula.charAt(i++);
            if (Character.isAlphabetic(cur)) {
                String element = cur + "";
                while (i < len && Character.isLowerCase(formula.charAt(i)))
                    element += formula.charAt(i++);
                String val = "";
                while (i < len && Character.isDigit(formula.charAt(i)))
                    val += formula.charAt(i++);
                int count = (!val.equals("")) ? Integer.parseInt(val) : 1;
                stack.push(new ElementCount(element, count));

            } else if (cur == '(') {
                stack.push(new ElementCount("(", -1));
            } else if (cur == ')') {
                List<ElementCount> list = new ArrayList<>();
                while (!stack.isEmpty() && !stack.peek().element.equals("(")) {
                    list.add(stack.pop());
                }
                stack.pop();
                String val = "";
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    val += formula.charAt(i++);
                }
                int multiply = (!val.equals("")) ? Integer.parseInt(val) : 1;
                for (ElementCount elementCount : list) {
                    stack.push(new ElementCount(elementCount.element, elementCount.count * multiply));
                }

            }
        }
        System.out.println(stack);
        while (!stack.isEmpty()) {
            ElementCount ec = stack.pop();
            map.put(ec.element, map.getOrDefault(ec.element, 0) + ec.count);
        }
        System.out.println(map);
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }
        return result.toString();
    }


}
