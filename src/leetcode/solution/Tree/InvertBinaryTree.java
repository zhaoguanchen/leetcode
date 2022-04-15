package leetcode.solution.Tree;

import leetcode.structure.TreeNode;

/**
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        Integer[] pArray = {1, 2, 3, 4, 5};
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(invertTree(p));

    }

    public static TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    private static void helper(TreeNode root) {
        // 到达叶子节点，返回
        if (root == null) {
            return;
        }

        // 交换左右节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归子节点
        helper(root.left);
        helper(root.right);

    }
}
