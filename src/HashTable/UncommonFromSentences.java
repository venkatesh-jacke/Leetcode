package HashTable;

import java.util.*;

public class UncommonFromSentences {
    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));

    }

    static public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        //System.out.println(map);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value == 1) {
                list.add(key);
            }
        }
        //System.out.println(list);
        String[] res = new String[list.size()];
        int i = 0;
        for (String s : list) {
            res[i++] = s;
        }
        return list.toArray(new String[list.size()]);
    }

}
