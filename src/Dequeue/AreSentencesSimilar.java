package Dequeue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//1813. Sentence Similarity III
public class AreSentencesSimilar {
    public static void main(String[] args) {
        String s1 = "My name is Haley";
        String s2 = "My Haley";

        System.out.println(areSentencesSimilar(s1, s2));
    }

    static public boolean areSentencesSimilar(String s1, String s2) {
        Deque<String> dq1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> dq2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));

        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peek().equals(dq2.peek())) {
            dq1.poll();
            dq2.poll();
        }
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }
        return dq1.isEmpty() || dq2.isEmpty();
    }
}
