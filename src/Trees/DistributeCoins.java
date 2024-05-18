package Trees;


//979. Distribute Coins in Binary Tree
public class DistributeCoins {
    static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        distributeCoins(root);
        System.out.println(ans);
    }

    static public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftCoins = dfs(root.left);
        int rightCoins = dfs(root.right);
        ans += Math.abs(leftCoins) + Math.abs(rightCoins);
        return (root.val - 1) + leftCoins + rightCoins;

    }
}


//https://leetcode.com/problems/distribute-coins-in-binary-tree/solutions/5172546/explanation-as-easy-as-you-think/?envType=daily-question&envId=2024-05-18