package Leetcode_75;

import java.util.Stack;

//394. Decode String
public class decodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }

    static public String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            // If the character is a digit, build the complete number
            // Example: "12[a]" -> number becomes 12
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            // Opening bracket indicates the start of a new encoded substring
            else if (c == '[') {
                countStack.push(num); // Save the repeat count
                stringStack.push(current); // Save the string built so far
                current= new StringBuilder(); // Start with a fresh string for the new bracket level
                num = 0; // Reset number for the next encoded string
            } else if (c == ']') {
                int repeat = countStack.pop();
                // Retrieve the string that existed before '['
                StringBuilder previous = stringStack.pop();
                while (repeat-- > 0) {
                    previous.append(current);
                }
                current = previous;
            }
            // Normal alphabetic character
            else {
                current.append(c);
            }
        }
        return current.toString();
    }
}

