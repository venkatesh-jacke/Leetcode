package Trees;


import java.util.*;

//1110. Delete Nodes And Return Forest
public class DelNodes {

    static   List<TreeNode> forest;
    public static void main(String[] args) {

    }

    static  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        deleteNodes(root, set, true);

        return forest;
    }


    //RECURSION
     static public TreeNode deleteNodes(TreeNode root, HashSet<Integer> set, boolean isRoot) {
         if (root == null) {
             return null;
         }

         boolean toDelete = set.contains(root.val);

         if (isRoot && !toDelete) {
             forest.add(root);
         }

         root.left = deleteNodes(root.left, set, toDelete);
         root.right = deleteNodes(root.right, set, toDelete);

         return toDelete ? null : root;
     }

    //Recursively call deleteNodes on the left child and right child.
    // Pass the toDelete variable as the isRoot parameter to these calls to indicate
    // that the children of a deleted node are new roots.

     //BFS
   static public List<TreeNode> delNodes_bfs(TreeNode root, int[] to_delete) {
        List<TreeNode> forest= new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();
        for(int i:to_delete) set.add(i);
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur.left!=null){
                q.add(cur.left);
                if(set.contains(cur.left.val)){
                    cur.left=null;
                }
            }
            if(cur.right!=null){
                q.add(cur.right);
                if(set.contains(cur.right.val)){
                    cur.right=null;
                }
            }
            if(set.contains(cur.val)){
                if(cur.left!=null){
                    forest.add(cur.left);
                }
                if(cur.right!=null){
                    forest.add(cur.right);
                }
            }
        }

        if(!set.contains(root.val)){
            forest.add(root);
        }
        return forest;
    }
}
