package Leetcode_75;

import Trees.TreeNode;

//450. Delete Node in a BST

public class DeleteNode {
    public static void main(String[] args) {
        Integer[] arr = {5, 3, 6, 2, 4, null, 7};
        int key = 3;
        TreeNode root = TreeNode.buildTree(arr);
        System.out.println(TreeNode.printTree(deleteNode(root, key)));
    }

    static public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        // key is smaller -> search in the left subtree.
        if (key < root.val) {
            root.left= deleteNode(root.left, key);
        }
        // key is larger -> search in the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // root.val == key -> we found the node to delete.
        else {
            // Case 1 & 2:
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            } else {
                // Case 3:
                // Node has TWO children.
                // Find the smallest value in the right subtree.
                // This is the inorder successor.
                TreeNode successor = findMin(root.right);
                root.val= successor.val;
                root.right=deleteNode(root.right,successor.val);
            }
        }
        return root;
    }

    static TreeNode findMin(TreeNode root) {
        // The smallest value in a BST is the
        // leftmost node.
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}

/*
 * Recursion returns the NEW root of the modified subtree.
 *
 * So after deleting from a child subtree, we must reconnect
 * the returned subtree back to the current node.
 *
 * Example:
 *     root.left = deleteNode(root.left, key);
 *     root.right = deleteNode(root.right, key);
 */

/*
 * First use the BST property to find the node.
 *
 * Once found, there are 3 cases:
 *
 * 1. No child  -> return null.
 * 2. One child -> return that child.
 * 3. Two children:
 *      - Find the smallest node in the right subtree
 *        (inorder successor).
 *      - Copy its value into the current node.
 *      - Delete the duplicate successor from the right subtree.
 *
 * The successor is used because it is the next larger
 * value and keeps the BST property valid.
 */

/*
 *              Found node
 *                  |
 *        +---------+---------+
 *        |         |         |
 *     No child   One child  Two children
 *        |         |         |
 *      null    return child  Find successor
 *                            |
 *                      Copy successor
 *                            |
 *                     Delete successor
 */
