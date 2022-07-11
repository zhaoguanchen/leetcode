package leetcode.solution.tree;

import leetcode.structure.TreeNode;

/**
 * 404. Sum of Left Leaves
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode r = TreeNode.constructTree(array);
        SumOfLeftLeaves solution = new SumOfLeftLeaves();
        int ans = solution.sumOfLeftLeaves(r);
        System.out.println(ans);
        // 24
    }


    private int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        this.sum = 0;
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        dfs(root.left);

        dfs(root.right);

    }
}
