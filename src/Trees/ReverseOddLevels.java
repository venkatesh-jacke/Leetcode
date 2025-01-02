package Trees;


//2415. Reverse Odd Levels of Binary Tree
public class ReverseOddLevels {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 5, 8, 13, 21, 34};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(TreeNode.printTree(reverseOddLevels(root)));
    }

    static   public TreeNode reverseOddLevels(TreeNode root) {
        traverseDfs(root.left, root.right, 1);
        return root;
    }

   static public void traverseDfs(TreeNode leftChild, TreeNode rightChild, int level) {
        if (leftChild == null || rightChild == null)
            return;
        if (level % 2 != 0) {
            int temp = leftChild.val;
            leftChild.val = rightChild.val;
            rightChild.val = temp;
        }
        traverseDfs(leftChild.left, rightChild.right, level + 1);
        traverseDfs(leftChild.right, rightChild.left, level + 1);

    }
}
