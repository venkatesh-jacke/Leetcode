package Leetcode_75;

import Trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//199. Binary Tree Right Side View

public class RightSideView {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, null, null, null, 5};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(rightSideView(root));
    }

    static public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // At each level, the last node we process is the
                // rightmost node of that level, which is visible
                // from the right side.
                if (i == levelSize - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (root.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
