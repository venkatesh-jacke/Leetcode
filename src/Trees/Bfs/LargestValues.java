package Trees.Bfs;


import Trees.TreeNode;

import java.util.*;

//515. Find Largest Value in Each Tree Row
public class LargestValues {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 5, 3, null, 9};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(largestValues(root));
    }

    static public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return res;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
