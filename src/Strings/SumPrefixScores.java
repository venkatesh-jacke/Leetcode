package Strings;

import java.util.Arrays;
import java.util.HashMap;

public class SumPrefixScores {
    public static void main(String[] args) {
        String words[] = {"abc", "ab", "bc", "b"};
        System.out.println(Arrays.toString(sumPrefixScores(words)));
    }

    static public int[] sumPrefixScores(String[] words) {
        int[] res = new int[words.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i + 1);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int idx = 0;
        for (String s : words) {
            int val = 0;
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i + 1);
                val += map.get(key);
            }
            res[idx++] = val;
        }
        System.out.println(map);
        return res;
    }
}
