package Trees;

import java.util.ArrayList;
import java.util.List;

//113. Path Sum II
public class PathSum_II {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        int targetSum = 22;
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(pathSum(root, targetSum));
    }

    static public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, res, new ArrayList<>());
        return res;
    }

    static public void dfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return; // No node -> no valid path.
        targetSum -= root.val; // Consume current node's value
        path.add(root.val); // Remember current path.
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList<>(path));
            }
        }
        // check in left and right subtree
        dfs(root.left, targetSum, res, path);
        dfs(root.right, targetSum, res, path);
        // Undo current node before returning.
        path.remove(path.size() - 1);

    }
}
