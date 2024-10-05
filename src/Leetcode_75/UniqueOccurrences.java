package Leetcode_75;

import java.util.*;


//1207. Unique Number of Occurrences
public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3,3};
        System.out.println(uniqueOccurrences(arr));
    }

    static  public boolean uniqueOccurrences(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}
