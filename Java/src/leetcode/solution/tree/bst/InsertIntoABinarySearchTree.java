package leetcode.solution.tree.bst;

import leetcode.structure.TreeNode;

/**
 * 98. Validate Binary Search Tree
 */
public class InsertIntoABinarySearchTree {

    public static void main(String[] args) {
        Integer[] inorder = {4, 2, 7, 1, 3};
        TreeNode treeNode = TreeNode.constructTree(inorder);
        int val = 5;
        System.out.println(TreeNode.print(insertIntoBST(treeNode, val)));
    }


    private static int value;

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        value = val;
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        helper(root);
        return root;
    }

    /**
     * 中序遍历
     * 中序遍历即为二叉搜索树的从小到大排序
     *
     * @param root
     */
    private static void helper(TreeNode root) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }


        if (root.val > value) {
            if (root.left != null) {
                helper(root.left);
            } else {
                root.left = new TreeNode(value);
            }

        } else if (root.val < value) {
            if (root.right != null) {
                helper(root.right);
            } else {
                root.right = new TreeNode(value);
            }
        }

    }
}
