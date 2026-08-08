package Leetcode_75;

import Trees.TreeNode;

//1448. Count Good Nodes in Binary Tree

public class GoodNodes {
    public static void main(String[] args) {
        Integer[] arr = {3, 1, 4, 3, null, 1, 5};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(goodNodes(root));
    }

    static public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    static public int dfs(TreeNode root, int maxSoFar) {
        if (root == null) return 0;
        int good = 0;
        if (root.val >= maxSoFar) good = 1;
        maxSoFar = Math.max(maxSoFar, root.val);
        return good + dfs(root.left, maxSoFar) + dfs(root.right, maxSoFar);
    }
}
