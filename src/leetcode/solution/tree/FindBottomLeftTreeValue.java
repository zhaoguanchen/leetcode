package leetcode.solution.tree;

import leetcode.structure.TreeNode;

/**
 * 513. Find Bottom Left Tree Value
 */
public class FindBottomLeftTreeValue {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, null, 5, 6, null, null, 7};
        TreeNode r = TreeNode.constructTree(array);
        FindBottomLeftTreeValue solution = new FindBottomLeftTreeValue();
        int ans = solution.findBottomLeftValue(r);
        System.out.println(ans);
        // 7
    }

    private int ans;
    private int maxLevel;

    public int findBottomLeftValue(TreeNode root) {
        this.ans = root.val;
        this.maxLevel = 0;
        dfs(root, 0);

        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > maxLevel) {
            ans = root.val;
            maxLevel = level;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
