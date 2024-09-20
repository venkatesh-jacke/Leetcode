package Strings;

import java.util.ArrayList;
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
}
