package Trees.Bfs;

import Trees.TreeNode;

import java.util.*;

//2415. Reverse Odd Levels of Binary Tree
public class ReverseOddLevels {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 5, 8, 13, 21, 34};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(TreeNode.printTree(reverseOddLevels(root)));
    }

    static    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return null;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                currentLevelNodes.add(node);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);

            }
            if (level % 2 == 1) {
                int l = 0, r = currentLevelNodes.size() - 1;
                while (l < r) {
                    int temp = currentLevelNodes.get(l).val;
                    currentLevelNodes.get(l).val = currentLevelNodes.get(r).val;
                    currentLevelNodes.get(r).val = temp;
                    l++;
                    r--;
                }
            }
            level++;
        }
        return root;
    }

}
