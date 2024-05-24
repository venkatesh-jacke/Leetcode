package Trees;

import java.util.Stack;

public class RemoveLeafNodes {
    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left= new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left= new TreeNode(2);
        root.right.left= new TreeNode(2);
        root.right.right= new TreeNode(4);;
        System.out.println(TreeNode.printTree(root));
       System.out.println(TreeNode.printTree(removeLeafNodes(root,2)));

    }
    static public TreeNode removeLeafNodes(TreeNode root, int target) {
        Stack<TreeNode> stack= new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            if(cur.val==target && cur.left==null && cur.right==null){
                cur=null;
            }
            if(cur!=null && cur.left!=null) stack.push(cur.left);
            if(cur!=null && cur.right!=null)  stack.push(cur.right);

        }
        return root;
    }
}
