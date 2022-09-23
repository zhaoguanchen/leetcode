package leetcode.solution.backtrack;

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

    /**
     * global variable - result list
     */
    List<List<Integer>> ans;

    /**
     * global variable - targetSum
     */
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        target = targetSum;
        LinkedList<Integer> path = new LinkedList<>();
        // root value will always be chosen
        path.add(root.val);
        int sum = root.val;
        backtrack(root, sum, path);

        return ans;
    }


    private void backtrack(TreeNode root, int sum, LinkedList<Integer> path) {
        // arrive the leaf node
        if (root.left == null && root.right == null) {
            if (sum == target) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        // search left child
        if (root.left != null) {
            path.add(root.left.val);
            sum += root.left.val;
            backtrack(root.left, sum, path);
            path.removeLast();
            sum -= root.left.val;
        }

        // search right child
        if (root.right != null) {
            path.add(root.right.val);
            sum += root.right.val;
            backtrack(root.right, sum, path);
            path.removeLast();
            sum -= root.right.val;
        }
    }
}