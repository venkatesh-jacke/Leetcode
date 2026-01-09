package Trees;


//865. Smallest Subtree with all the Deepest Nodes
public class SubtreeWithAllDeepest {
    public static void main(String[] args) {
        TreeNode result = subtreeWithAllDeepest(TreeNode.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4}));
        System.out.println(TreeNode.printTree(result));
    }
   static public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    static public Result dfs(TreeNode root) {
        if (root == null)
            return new Result(null, 0);
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else if (left.depth < right.depth) {
            return new Result(right.node, right.depth + 1);
        } else {
            return new Result(root, left.depth + 1);
        }
    }

   static class Result {
        int depth;
        TreeNode node;

        Result(TreeNode node, int depth) {
            this.depth = depth;
            this.node = node;
        }
    }
}
