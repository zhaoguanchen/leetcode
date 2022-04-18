package leetcode.solution.Tree.BST;

import leetcode.structure.TreeNode;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementInABST {

    public static void main(String[] args) {
        Integer[] inorder = {3, 1, 4, null, 2};
        TreeNode treeNode = TreeNode.constructTree(inorder);
        int k = 3;
        KthSmallestElementInABST test = new KthSmallestElementInABST();
        int ans = test.kthSmallest(treeNode, k);
        System.out.println(ans);

    }

    /**
     * global variable, same as k
     * 全局变量，记录要找的排名
     */
    private int kth;

    /**
     * the order of current node
     * 当前节点的排名
     */
    private int current;

    /**
     * the value of final result
     * 结果值
     */
    private int value;


    public int kthSmallest(TreeNode root, int k) {
        kth = k;
        current = 0;
        helper(root);
        return value;
    }

    /**
     * Inorder Traversal
     * 中序遍历
     * <p>
     * means sort from smallest to largest in the Binary Search Tree
     * 中序遍历即为二叉搜索树的从小到大排序
     *
     * @param root
     */
    private void helper(TreeNode root) {
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
