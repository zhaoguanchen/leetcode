package leetcode.solution.Tree.BST;

import leetcode.structure.TreeNode;

/**
 * 669. Trim a Binary Search Tree
 */
public class TrimABinarySearchTree {

    public static void main(String[] args) {
        Integer[] nums = {3, 0, 4, null, 2, null, null, 1};
        TreeNode treeNode = TreeNode.constructTree(nums);
        int low = 1;
        int high = 3;
        TrimABinarySearchTree tree = new TrimABinarySearchTree();
        TreeNode ans = tree.trimBST(treeNode, low, high);
        System.out.println(TreeNode.print(ans));
    }

    private int low;

    private int high;

    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;

        return helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 右侧及本身比high要大，全部丢弃
        if (root.val > high) {
            return helper(root.left);
        }

        // 左侧及本身比low小，全部丢弃
        if (root.val < low) {
            return helper(root.right);
        }

        // root本身的值在区间范围内，保留，递归处理左右子节点
        root.left = helper(root.left);
        root.right = helper(root.right);

        return root;
    }
}
