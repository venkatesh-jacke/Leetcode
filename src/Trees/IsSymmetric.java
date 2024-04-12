package Trees;

public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    static public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        return isMirror(root.left, root.right);


    }

    static public boolean isMirror(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A != null && B != null) return A.val==B.val && isMirror(A.left, B.right) && isMirror(A.right,B.left);
        return false;
    }
}
