package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//144. Binary Tree Preorder Traversal
public class PreorderTraversal {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(preorderTraversal(root));
    }

    static  public List<Integer> preorderTraversal(TreeNode root){
        Stack<TreeNode> stack= new Stack<>();
        List<Integer> res= new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                res.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop().right;
        }
        return res;
    }
}


