package Trees.Dfs;

import Trees.TreeNode;
import javafx.util.Pair;

import java.util.*;

//515. Find Largest Value in Each Tree Row
public class LargestValues {
   static List<Integer> res;

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 5, 3, null, 9};
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(largestValues(root));
    }

   static public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }

    static public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

    static public List<Integer> largestValues_stack(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        Stack<Pair<TreeNode,Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root,0));
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> pair= stack.pop();
            TreeNode node= pair.getKey();
            int depth =pair.getValue();

            if(depth==res.size()){
                res.add(node.val);
            }
            else{
                res.set(depth, Math.max(res.get(depth), node.val));
            }
            if(node.left!=null){
                stack.push(new Pair<>(node.left,depth+1));
            }
            if(node.right!=null){
                stack.push(new Pair<>(node.right,depth+1));
            }
        }
        return res;
    }
}