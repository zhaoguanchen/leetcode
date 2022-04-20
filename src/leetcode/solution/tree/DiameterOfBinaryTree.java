package leetcode.solution.tree;

import leetcode.structure.TreeNode;

/**
 * 543. Diameter of Binary Tree
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        Integer[] pArray = {1, 2, 3, 4, 5};
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(diameterOfBinaryTree(p));

    }

    private static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int current = left + right;
        // 记录最长直径
        max = Math.max(max, current);
        // 返回当前节点左子和右子中较长的路径长度，提供给上一节点
        return Math.max(left, right) + 1;

    }
}
