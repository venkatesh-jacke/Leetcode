package Stack;

//2434. Using a Robot to Print the Lexicographically Smallest String

import java.util.Stack;

public class RobotWithString {
    public static void main(String[] args) {
        String s = "cadb";
        System.out.println(robotWithString(s));
    }

    static public String robotWithString(String s) {
        int freq[] = new int[26];
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;
            char smallest = 'z' + 1;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    smallest = (char) ('a' + i);
                    break;
                }
            }
            while (!stack.isEmpty() && stack.peek() <= smallest) {
                res.append(stack.pop());
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }
    static public String robotWithString2(String s) {
        int freq[] = new int[26];
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;
            char smallest = 'a';
            while (smallest!='z' && freq[smallest-'a']==0){
                smallest++;
            }
            while (!stack.isEmpty() && stack.peek() <= smallest) {
                res.append(stack.pop());
            }
        }

        return res.toString();
    }
}
