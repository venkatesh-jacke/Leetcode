package Trees.Bfs;

import Trees.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

public class MinimumOperations {
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 3, 7, 6, 8, 5, null, null, null, null, 9, null, 10};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(minimumOperations(root));

    }

    static public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int totalSwaps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int[] currentLevel = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                currentLevel[i] = node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

            totalSwaps += getMinSwaps(currentLevel);
        }
        return totalSwaps;
    }

    // This is Cyclic Sort
    static public int getMinSwaps(int[] original) {
        int n = original.length;
        int swaps = 0;
        int[] target = original.clone();
        Arrays.sort(original);
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(original[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (original[i] != target[i]) {
                swaps++;
                int sortedPos = pos.get(target[i]); // take the sorted value index
                pos.put(original[i], sortedPos);
                original[sortedPos] = original[i];

            }
        }
        return swaps;
    }
}
