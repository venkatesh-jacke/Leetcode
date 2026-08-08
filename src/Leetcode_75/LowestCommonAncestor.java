package Leetcode_75;

import Trees.TreeNode;

//236. Lowest Common Ancestor of a Binary Tree

public class LowestCommonAncestor {
    public static void main(String[] args) {
        Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        int p = 5, q = 1;
        TreeNode root = TreeNode.buildTree(arr);
    }

    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        // If the current node is one of the targets,
        // report it to the parent.
        if (root == p || root == q)
            return root;
        // Ask both subtrees:
        // "Did you find p, q, or the LCA?"
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // One target came from the left subtree and the other
        // came from the right subtree.
        // Therefore, the current node is their Lowest Common Ancestor.
        if (left != null && right != null) {
            return root;
        }
        // Otherwise, propagate whichever subtree found something.
        // (Either p, q, or an already found LCA.)
        return left != null ? left : right;
    }
}
