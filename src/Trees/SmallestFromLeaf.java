package Trees;

//988. Smallest String Starting From Leaf
public class SmallestFromLeaf {
   static String res="";
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Smallest string starting from leaf: " + smallestFromLeaf(root));
    }
    static public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }
   static public void dfs(TreeNode root, String current) {
        if (root == null)
            return;
        current = (char) (root.val + 'a') + current;
        if (root.left == null && root.right == null) {
            if (res.isEmpty() || res.compareTo(current) > 0) {
                res = current;
            }
        }
            dfs(root.left, current);
            dfs(root.right, current);
    }
}
