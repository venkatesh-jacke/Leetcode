package Leetcode_75;

import java.util.*;


//1657. Determine if Two Strings Are Close
public class CoseStrings {
    public static void main(String[] args) {
       String word1 = "cabbba", word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }

    static public boolean closeStrings(String w1, String w2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char i : w1.toCharArray()) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (char i : w2.toCharArray()) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        List<Integer> values1=new ArrayList<>(map1.values());
        List<Integer> values2=new ArrayList<>(map2.values());

        Collections.sort(values1);
        Collections.sort(values2);

        return values1.equals(values2);
    }
}
