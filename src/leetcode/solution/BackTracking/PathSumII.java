package leetcode.solution.BackTracking;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II
 */
public class PathSumII {

    public static void main(String[] args) {
        Integer[] tree = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode treeNode = TreeNode.constructTree(tree);
        int sum = 22;
        PathSumII palindromePartitioning = new PathSumII();
        List<List<Integer>> ans = palindromePartitioning.pathSum(treeNode, sum);
        System.out.println(ans);
        // [[5,4,11,2],[5,8,4,5]]
    }

    private List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> path = new LinkedList<>();
        path.add(root.val);
        targetSum -= root.val;
        backtrack(root, targetSum, path);
        return ans;
    }

    private void backtrack(TreeNode root, int targetSum, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                ans.add(new ArrayList<>(path));
            }

            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            targetSum -= root.left.val;
            backtrack(root.left, targetSum, path);
            targetSum += root.left.val;
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            targetSum -= root.right.val;
            backtrack(root.right, targetSum, path);
            targetSum += root.right.val;
            path.remove(path.size() - 1);
        }

    }
}