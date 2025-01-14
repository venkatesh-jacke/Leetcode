package HashTable;

import java.util.*;

public class MinimumLength {
    public static void main(String[] args) {
        String s = "aaaaaa";
        System.out.println(minimumLength(s));
    }

    static public int minimumLength(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int deleteCount = 0;
        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                deleteCount += freq - 2; // If frequency is odd, delete all except one
            } else {
                deleteCount += freq - 1;    // If frequency is even, delete all except two
            }
        }
        return n - deleteCount;  // Step 3: Return the minimum length after deletions
    }


}
