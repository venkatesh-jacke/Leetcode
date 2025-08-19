package Trees;

//104. Maximum Depth of Binary Tree

public class MaxDepth {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(maxDepth(root));
    }

    static public int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
