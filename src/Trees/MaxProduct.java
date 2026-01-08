package Trees;

//1339. Maximum Product of Splitted Binary Tree
public class MaxProduct {

    static long totalSum = 0;
    static long maxProduct = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Integer[]{1, 2, 3, 4, 5, 6});
        System.out.println(maxProduct(root));
    }

    //Method 1
    static public int maxProduct(TreeNode root) {
        dfsTotal(root);
        dfsSubsum(root);
        return (int) (maxProduct % 1000000007);
    }

    static public void dfsTotal(TreeNode root) {
        if (root == null) return;
        totalSum += root.val;
        dfsTotal(root.left);
        dfsTotal(root.right);
    }

    static public long dfsSubsum(TreeNode root) {
        if (root == null) return 0;
        long l = dfsSubsum(root.left);
        long r = dfsSubsum(root.right);
        long subSum = l + r + root.val;
        maxProduct = Math.max(maxProduct, subSum * (totalSum - subSum));
        return subSum;
    }

    //Method 2
    static public int maxProduct1(TreeNode root) {
        totalSum = sum(root);
        sum(root);
        return (int) (maxProduct % 1000000007);
    }

    public static long sum(TreeNode root) {
        if (root == null) return 0;
        long subSum = root.val + sum(root.left) + sum(root.right);
        if (totalSum > 0) {
            maxProduct = Math.max(maxProduct, subSum * (totalSum - subSum));
        }
        return subSum;
    }
}
