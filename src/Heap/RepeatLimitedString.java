package Heap;

import java.util.*;
import java.util.PriorityQueue;

//2182. Construct String With Repeat Limit

public class RepeatLimitedString {
    public static void main(String[] args) {
        String s="cczazcc";
        int repeatLimit=3;
        System.out.println(repeatLimitedString(s,repeatLimit));
    }
    static public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Character.compare(b, a));
        for (char c : freq.keySet()) {
            maxHeap.offer(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char top = maxHeap.poll();
            int count = freq.get(top);
            int use = Math.min(count, repeatLimit);
            for (int i = 0; i < use; i++) {
                sb.append(top);
            }
            freq.put(top, count - use);
            if (freq.get(top) > 0 && !maxHeap.isEmpty()) {
                char next = maxHeap.poll();
                sb.append(next);
                freq.put(next, freq.get(next) - 1);
                if (freq.get(next) > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(top);
            }
        }
        return sb.toString();
    }
}
