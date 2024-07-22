package Trees;


import java.util.*;

//145. Binary Tree Postorder Traversal
public class PostOrderTraversal {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(postorderTraversal(root));
    }

    static public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root, prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right != null && cur.right != prev) {
                cur = cur.right;
            } else {
                res.add(cur.val);
                prev = stack.pop();
                cur=null;
            }
        }
        return res;
    }
}
