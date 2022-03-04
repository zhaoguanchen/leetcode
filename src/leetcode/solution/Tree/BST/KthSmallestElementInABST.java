package leetcode.solution.Tree.BST;

import leetcode.Structure.TreeNode;

/**
 * 652. Find Duplicate Subtrees
 */
public class KthSmallestElementInABST {

    public static void main(String[] args) {
        Integer[] inorder = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode treeNode = TreeNode.constructTree(inorder);
        int k = 3;
        System.out.println(kthSmallest(treeNode, k));

    }

    /**
     * 全局变量，记录要找的排名
     */
    private static int kth;
    /**
     * 当前节点的排名
     */
    private static int current;

    /**
     * 结果值
     */
    private static int value;


    public static int kthSmallest(TreeNode root, int k) {
        kth = k;
        current = 0;
        helper(root);
        return value;
    }

    /**
     * 中序遍历
     * 中序遍历即为二叉搜索树的从小到大排序
     * @param root
     */
    private static void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        current++;
        if (current == kth) {
            value = root.val;
            return;
        }

        helper(root.right);
    }
}
