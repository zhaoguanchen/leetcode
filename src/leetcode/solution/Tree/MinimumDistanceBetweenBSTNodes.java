package leetcode.solution.Tree;

import leetcode.Structure.TreeNode;

/**
 * 783. Minimum Distance Between BST Nodes
 * <p>
 * Given the root of a Binary Search Tree (BST),
 * return the minimum difference between the values of any two different nodes in the tree.
 */
public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
        Integer[] pArray = {1, 4, 2, 3, 5, 6, 7};
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(minDiffInBST(p));

    }

    private static Integer prev, ans;

    public static int minDiffInBST(TreeNode root) {
        prev = null;
        ans = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    public static void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (prev != null) {
            ans = Math.min(ans, Math.abs(node.val - prev));
        }
        prev = node.val;
        dfs(node.right);
    }
}
