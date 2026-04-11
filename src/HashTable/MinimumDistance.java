package HashTable;

//3741. Minimum Distance Between Three Equal Elements II

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumDistance {
    public static void main(String[] args) {
        int[] nums = {5,3,5,5,5};
        System.out.println(minimumDistance(nums));
    }

    static public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;
            for (int i = 0; i <= list.size() - 3; i++) {
                int distance = list.get(i + 2) - list.get(i);
                ans = Math.min(ans, distance);
            }
        }
        System.out.println(map);
        return ans == Integer.MAX_VALUE ? -1 : ans * 2;
    }
}
