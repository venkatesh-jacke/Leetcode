package HashTable;

import java.util.*;

public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));

    }

    static public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                list.add(i);
                map.put(i, map.getOrDefault(i, 0) - 1);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
