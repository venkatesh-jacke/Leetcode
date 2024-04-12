package HashTable;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
    static public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String sortedString = new String(ca);
            if (!map.containsKey(sortedString)) {
                List<String> list = new ArrayList<>();
                map.put(sortedString,list);
            }
            map.get(sortedString).add(s);
        }


        return new ArrayList(map.values());
    }
}
