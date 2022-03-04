package leetcode.solution.Tree.BST;

import leetcode.Structure.TreeNode;

/**
 * 450. Delete Node in a BST
 */
public class DeleteNodeInABST {

    public static void main(String[] args) {
        Integer[] inorder = {4, 2, 7, 1, 3};
        TreeNode treeNode = TreeNode.constructTree(inorder);
        int val = 1;
        System.out.println(TreeNode.print(deleteNode(treeNode, val)));
    }


    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root = delete(root);
        }

        return root;

    }

    private static TreeNode delete(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        TreeNode min = getMin(root.right);

        root.right = deleteNode(root.right, min.val);

        min.left = root.left;
        min.right = root.right;
        root = min;

        return root;
    }


    private static TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


}
