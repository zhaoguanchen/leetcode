package leetcode.solution.Tree.BST;

import leetcode.structure.TreeNode;

/**
 * 700. Search in a Binary Search Tree
 */
public class SearchBinarySearchTree {

    public static void main(String[] args) {
        Integer[] inorder = {4, 2, 7, 1, 3};
        TreeNode treeNode = TreeNode.constructTree(inorder);
        System.out.println(searchBST(treeNode, 2).val);
    }

    private static int value;

    public static TreeNode searchBST(TreeNode root, int val) {
        value = val;
        return helper(root);
    }


    private static TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.val > value) {
            return helper(root.left);
        } else if (root.val < value) {
            return helper(root.right);
        }

        return root;
    }
}
