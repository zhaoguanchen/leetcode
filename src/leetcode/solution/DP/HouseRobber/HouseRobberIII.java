package leetcode.solution.DP.HouseRobber;

import leetcode.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III
 */
public class HouseRobberIII {

    public static void main(String[] args) {
        Integer[] array = {3, 2, 3, null, 3, null, 1};
        TreeNode root = TreeNode.constructTree(array);
        HouseRobberIII houseRobberIII = new HouseRobberIII();
        int ans = houseRobberIII.rob(root);
        System.out.println(ans);
        // 7
    }

    Map<TreeNode, Integer> memo;

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return helper(root);
    }


    private int helper(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int doRoot = root.val
                + (root.left == null ? 0 : helper(root.left.left) + helper(root.left.right))
                + (root.right == null ? 0 : helper(root.right.left) + helper(root.right.right));

        int notDoRoot = helper(root.left) + helper(root.right);

        int ans = Math.max(doRoot, notDoRoot);

        memo.put(root, ans);

        return ans;
    }
}