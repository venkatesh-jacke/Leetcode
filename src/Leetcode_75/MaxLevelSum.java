package Leetcode_75;

//161. Maximum Level Sum of a Binary Tree

import Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public static void main(String[] args) {
        Integer[] arr = {1, 7, 0, 7, -8, null, null};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(maxLevelSum(root));
    }

    static public int maxLevelSum(TreeNode root) {
        int level = 1;
        int ans = level;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            // queue.size() tells us how many nodes belong to the CURRENT level.
            int size = queue.size();
            int sum = 0;
            // Process all nodes belonging to this level.
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // Add every node's value to get the  total sum of this level.
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
            // Move to the next level.
            level++;
        }
        return ans;
    }
}
