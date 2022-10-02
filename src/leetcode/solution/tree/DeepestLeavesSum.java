package leetcode.solution.tree;

import leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. Deepest Leaves Sum
 */
public class DeepestLeavesSum {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8};
        TreeNode root = TreeNode.constructTree(array);

        DeepestLeavesSumBFSSolution bfsSolution = new DeepestLeavesSumBFSSolution();
        int ans = bfsSolution.deepestLeavesSum(root);
        System.out.println(ans);

        DeepestLeavesSumDFSSolution dfsSolution = new DeepestLeavesSumDFSSolution();
        int ans1 = dfsSolution.deepestLeavesSum(root);
        System.out.println(ans1);

    }
}

class DeepestLeavesSumBFSSolution {
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            ans = sum;
        }
        return ans;
    }
}

class DeepestLeavesSumDFSSolution {

    int maxDepth = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }


    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                sum = root.val;
                maxDepth = depth;
            } else if (depth == maxDepth) {
                sum += root.val;
            }
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);

    }
}