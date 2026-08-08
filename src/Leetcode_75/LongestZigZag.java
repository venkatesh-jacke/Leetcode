package Leetcode_75;

import Trees.TreeNode;


//1372. Longest ZigZag Path in a Binary Tree

public class LongestZigZag {
    static int ans = 0;

    public static void main(String[] args) {
        Integer[] arr = {1,null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(longestZigZag(root));
    }

    static public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return ans;
    }

    static public void dfs(TreeNode node, boolean isFromLeft, int len) {
        if (node == null) return;
        ans = Math.max(ans, len);
        if (isFromLeft) {
            // Continue ZigZag by moving right
            dfs(node.right, false, len + 1);
            // Going LEFT again breaks the current ZigZag.
            // However, a new ZigZag can start from this LEFT edge,
            // so restart the length from 1.
            dfs(node.left, true, 1);
        } else {
            // Continue ZigZag by moving right
            dfs(node.left, true, len + 1);
            // Going RIGHT again breaks the current ZigZag.
            // Start a new ZigZag beginning with this RIGHT edge.
            dfs(node.right, false, 1);
        }
    }
}
