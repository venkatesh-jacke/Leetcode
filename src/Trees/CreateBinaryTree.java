package Trees;

import java.util.*;


//2196. Create Binary Tree From Descriptions
public class CreateBinaryTree {
    public static void main(String[] args) {
        int[][] descriptions = {
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 1}
        };
        System.out.println(TreeNode.printTree(createBinaryTree(descriptions)));
    }

    static public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> parents = new HashSet<>();
        Set<Integer> children = new HashSet<>();
        Map<Integer, List<int[]>> parentToChildren = new HashMap<>();
        for (int[] d : descriptions) {
            int parent = d[0], child = d[1], isLeft = d[2];
            parents.add(parent);
            parents.add(child);
            children.add(child);
            parentToChildren.computeIfAbsent(parent, v -> new ArrayList<>()).add(new int[]{child, isLeft});
        }

        parents.removeAll(children);
        TreeNode root = new TreeNode(parents.iterator().next());
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            for (int[] childInfo : parentToChildren.getOrDefault(parent.val, Collections.emptyList())) {
                int childValue = childInfo[0], isLeft = childInfo[1];
                TreeNode child = new TreeNode(childValue);
                q.offer(child);
                if (isLeft == 1) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }
        return root;

    }
}
