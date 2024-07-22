package Trees;


import java.util.*;

//1530. Number of Good Leaf Nodes Pairs
public class CountPairs {

    static int pairs;

    public static void main(String[] args) {
        Integer[] arr = {7,1,4,6,null,5,3,null,null,null,null,null,2};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(countPairs(root,3));
    }

    static public int countPairs(TreeNode root, int distance) {
        pairs = 0;
        dfs_With_Map(root, distance);
        return pairs;
    }

    static public List<Integer> dfs(TreeNode root, int dis) {
        if (root == null)
            return Collections.emptyList();
        if (root.left == null && root.right == null) {
            return Collections.singletonList(1);
        }
        List<Integer> left = dfs(root.left, dis);
        List<Integer> right = dfs(root.right, dis);

        for (int i : left) {
            for (int j : right) {
                if (i + j <= dis) {
                    pairs++;
                }
            }
        }
        List<Integer> both = new ArrayList<>();
        for (int i : left) {
            if (i + 1 <= dis)
                both.add(i + 1);
        }
        for (int i : right) {
            if (i + 1 <= dis)
                both.add(i + 1);
        }
        return both;

    }
    static public Map<Integer,Integer> dfs_With_Map(TreeNode root, int dis) {
        if (root == null)
            return Collections.emptyMap();
        if (root.left == null && root.right == null) {
            return Collections.singletonMap(1,1);
        }
        Map<Integer,Integer> left = dfs_With_Map(root.left, dis);
        Map<Integer,Integer> right= dfs_With_Map(root.right, dis);

        for (Map.Entry<Integer,Integer> leftEntry: left.entrySet()) {
            for (Map.Entry<Integer,Integer> rightEntry: right.entrySet()) {
                if (leftEntry.getKey() + rightEntry.getKey() <= dis) {
                    pairs+=leftEntry.getValue()*rightEntry.getValue();
                }
            }
        }
        Map<Integer,Integer> both = new HashMap<>();
        for (Map.Entry<Integer, Integer> leftEntry : left.entrySet()) {
            both.put(leftEntry.getKey() + 1, both.getOrDefault(leftEntry.getKey() + 1, 0) + leftEntry.getValue());
        }
        for (Map.Entry<Integer, Integer> rightEntry : right.entrySet()) {
            both.put(rightEntry.getKey() + 1, both.getOrDefault(rightEntry.getKey() + 1, 0) + rightEntry.getValue());
        }
        return both;

    }
}
