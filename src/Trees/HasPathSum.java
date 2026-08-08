package Trees;

//112. Path Sum
public class HasPathSum {
    public static void main(String[] args) {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        int targetSum = 22;
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(hasPathSum(root, targetSum));
    }

    static public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false; // No node -> no valid path.
        targetSum -= root.val; //consume the val
        if (root.left == null && root.right == null) return targetSum == 0; //if heaf node and target is 0
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum); // check in left and right subtree

    }
}
