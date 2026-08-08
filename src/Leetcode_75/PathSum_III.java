package Leetcode_75;

import Trees.TreeNode;

//437. Path Sum III
public class PathSum_III {
    public static void main(String[] args) {
        Integer[] arr = {10, 5, -3, 3, 2, null, 11, 3, -2, null, 1};
        int targetSum = 8;
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(pathSum(root, targetSum));
    }

    static public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        // Paths starting from current node
        int current = countFrom(root, targetSum);
        // Try every node as a starting point
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);
        return current + left + right;
    }

    //Counts all downward paths that START exactly from 'node'.
    public static int countFrom(TreeNode node, int targetSum) {
        if (node == null) return 0;// Reached end of path.
        int count = 0;
        targetSum -= node.val;
        // Found one valid path
        if (targetSum == 0) count++;
        count += countFrom(node.left, targetSum);
        count += countFrom(node.right, targetSum);
        return count;
    }
}
