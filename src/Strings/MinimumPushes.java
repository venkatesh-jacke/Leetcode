package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumPushes {
    public static void main(String[] args) {
        String word = "aabbccddeeffgghhiiiiii";
        System.out.println(minimumPushes(word));
    }

    static public int minimumPushes(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b - a);
        System.out.println(list);
        int idx = 0;
        for (int i : list) {
            res += i * (1 + idx / 8);
            idx += 1;
        }
        return res;
    }
    public int minimumPushes2(String word) {
        int total = 0;
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        for (int i = 25; i >= 0; i--) {
            int pushes = (25 - i) / 8 + 1; //25-i says how in which position
            total += freq[i] * pushes;
        }
        return total;
    }
}
