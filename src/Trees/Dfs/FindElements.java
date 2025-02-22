package Trees.Dfs;

import Trees.TreeNode;

import java.util.HashSet;

//1261. Find Elements in a Contaminated Binary Tree

public class FindElements {
    static HashSet<Integer> seen;

    public FindElements(TreeNode root) {
        seen = new HashSet<>();
        root.val = 0;
        dfs(root);
    }

    static public void dfs(TreeNode root) {
        if (root == null) return;
        seen.add(root.val);
        if (root.left != null)
            root.left.val = 2 * root.val + 1;
        dfs(root.left);
        if (root.right != null)
            root.right.val = 2 * root.val + 2;
        dfs(root.right);

    }


    static public boolean find(int target) {
        return seen.contains(target);
    }
}
