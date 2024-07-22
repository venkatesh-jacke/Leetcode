package Trees;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CreateDirections {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.println(getDirections(root, 3, 6));
    }

    static public String getDirections(TreeNode root, int startValue, int destValue) {
        Map<Integer, TreeNode> parentMap = new HashMap<>();

        TreeNode startNode = getStartNode(root, startValue);
        generateParentMap(root, parentMap);
        System.out.println(startNode.val);
        System.out.println(parentMap);
        return "";
    }

    static public TreeNode getStartNode(TreeNode root, int startValue) {
        if (root == null) {
            return null;
        }
        if (root.val == startValue) {
            return root;
        }
        TreeNode left = getStartNode(root.left, startValue);
        TreeNode right = getStartNode(root.right, startValue);
        return left != null ? left : right;
    }

    static public void generateParentMap(TreeNode root, Map<Integer, TreeNode> parentMap) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            generateParentMap(root.left, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            generateParentMap(root.right, parentMap);
        }
    }

}
