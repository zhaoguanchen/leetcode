package leetcode.solution.DFS;

import leetcode.Structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. Same Tree
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class PathSum {

    public static void main(String[] args) {
        Integer[] pArray = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        int target = 22;
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(hasPathSumBFS(p, target));
        System.out.println(hasPathSumDFS(p, target));
    }


    /**
     * BFS
     *
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();

        nodeQueue.add(root);
        sumQueue.add(0);
        while (!nodeQueue.isEmpty() && !sumQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            Integer sumOfFather = sumQueue.poll();
            Integer currentSum = sumOfFather + currentNode.val;
            // 到达叶子节点
            if (currentNode.right == null && currentNode.left == null) {
                if (currentSum == targetSum) {
                    return true;
                }
            } else {
                if (currentNode.left != null) {
                    nodeQueue.add(currentNode.left);
                    sumQueue.add(currentSum);
                }
                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right);
                    sumQueue.add(currentSum);
                }
            }
        }
        return false;
    }

    /**
     * DFS
     *
     * @param root
     * @param targetSum
     * @return
     */
    private static int target;

    public static boolean hasPathSumDFS(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        target = targetSum;
        return helper(root, 0);
    }

    private static boolean helper(TreeNode root, Integer sumOfFather) {
        if (root == null) {
            return false;
        }
        int currentSum = sumOfFather + root.val;

        if (root.left == null && root.right == null) {
            return currentSum == target;
        }

        return helper(root.left, currentSum) || helper(root.right, currentSum);
    }
}
