package Trees;

import java.util.Stack;

public class RecoverFromPreorder {
    public static void main(String[] args) {
        String traversal = "1-2--3---4-5--6---7";
        System.out.println(TreeNode.printTree(recoverFromPreorder(traversal)));

    }

    static public TreeNode recoverFromPreorder(String s) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        int idx = 0;
        int n = s.length();
        while (idx < n) {
            int depth = 0, val = 0;

            //calculate depth
            while (idx < n && s.charAt(idx) == '-') {
                depth++;
                idx++;
            }
            //calculate value
            while (idx < n && Character.isDigit(s.charAt(idx))) {
                val = val * 10 + (s.charAt(idx) - '0');
                idx++;
            }
            TreeNode node = new TreeNode(val);

            //reach to the correct depth where stack size is the depth level
            while (stack.size() > depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            } else {
                root = node; //First node is root
            }
            stack.push(node);
        }
        return root;
    }
}
