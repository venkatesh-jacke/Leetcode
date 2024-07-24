import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

        static public int[] frequencySort(int[] nums) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int[] res = new int[nums.length];
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            System.out.println(map);
            List<Integer> keys = new ArrayList<>(map.keySet());
            keys.sort((a, b) -> map.get(a) == map.get(b) ? Integer.compare(b, a) : Integer.compare(map.get(a), map.get(b)));
            System.out.println(keys);
            int i = 0;
            for (int k : keys) {
                for (int j = 0; j < map.get(k); j++) {
                    res[i++] = k;
                }
            }
            return res;
        }
}