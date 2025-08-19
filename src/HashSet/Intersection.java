package HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;


//349. Intersection of Two Arrays

public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    static public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) set.add(i);
        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
                set.remove(i);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();

    }
}
