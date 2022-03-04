package leetcode.solution.Tree.BST;

import leetcode.Structure.TreeNode;

/**
 * 98. Validate Binary Search Tree
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        Integer[] inorder = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode treeNode = TreeNode.constructTree(inorder);
        System.out.println(isValidBST(treeNode));
    }



    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 中序遍历
     * 中序遍历即为二叉搜索树的从小到大排序
     *
     * @param root
     */
    private static boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return helper(root.left, min, root) && helper(root.right, root, max);

    }
}
