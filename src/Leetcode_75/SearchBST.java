package Leetcode_75;

//700. Search in a Binary Search Tree

import Trees.TreeNode;

public class SearchBST {
    public static void main(String[] args) {
        java.lang.Integer[] arr = {4, 2, 7, 1, 3};
        int val = 2;
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(TreeNode.printTree(searchBST(root, val)));
    }

    static public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        // Found the value. Return the actual node.
        if (root.val == val) return root;
        // BST property:
        // Smaller values are always in the left subtree.
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        // Larger values are always in the right subtree.
        return searchBST(root.right, val);
    }
}
