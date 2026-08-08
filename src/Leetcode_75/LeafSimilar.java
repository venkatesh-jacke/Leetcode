package Leetcode_75;

//872. Leaf-Similar Trees

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
    public static void main(String[] args) {
        Integer[] arr1= {3,5,1,6,2,9,8,null,null,7,4};
        Integer[] arr2= {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};
        TreeNode root1 = TreeNode.buildTree(arr1);
        TreeNode root2 = TreeNode.buildTree(arr2);
        System.out.println(leafSimilar(root1,root2));
    }
    static public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1= new ArrayList<>();
        List<Integer> leafValues2= new ArrayList<>();
        dfs(root1,leafValues1);
        dfs(root2,leafValues2);
        return leafValues1.equals(leafValues2);

    }
    static public void dfs(TreeNode root, List<Integer> leafValues){
        if(root==null) return;
        if(root.left==null && root.right==null) leafValues.add(root.val);
        dfs(root.left,leafValues);
        dfs(root.right,leafValues);
    }
}
