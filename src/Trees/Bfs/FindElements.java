package Trees.Bfs;

import Trees.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//1261. Find Elements in a Contaminated Binary Tree

public class FindElements {
    static HashSet<Integer> seen;

    public FindElements(TreeNode root) {
        seen = new HashSet<>();
        root.val = 0;
        bfs(root);
    }

    static public void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        root.val = 0;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            seen.add(cur.val);
            if (cur.left != null) {
                cur.left.val = cur.val * 2 + 1;
                q.add(cur.left);
            }
            if (cur.right != null) {
                cur.right.val = cur.val * 2 + 2;
                q.add(cur.right);
            }
        }

    }


    static public boolean find(int target) {
        return seen.contains(target);
    }
}
