package leetcode.solution.tree;

import leetcode.structure.TreeNode;

/**
 * 979. Distribute Coins in Binary Tree
 */
public class DistributeCoinsInBinaryTree {

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.constructTree(array);
        DistributeCoinsInBinaryTreeSolution solution = new DistributeCoinsInBinaryTreeSolution();
        int ans = solution.distributeCoins(root);
        System.out.println(ans);

    }


}


class DistributeCoinsInBinaryTreeSolution {

    private int ans;

    public int distributeCoins(TreeNode root) {
        this.ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        ans += Math.abs(left) + Math.abs(right);

        return left + right + root.val - 1;

    }
}