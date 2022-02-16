package leetcode.solution.Tree;

import leetcode.Structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepth {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeNode.constructTree(array);
        System.out.println(maxDepth(root));
        System.out.println(maxDepthIterator(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }

    }

    public static int maxDepthIterator(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();

        nodeQueue.add(root);
        depthQueue.add(1);

        int max = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            Integer currentDepth = depthQueue.poll();
            if (currentDepth == null) {
                continue;
            }

            max = Math.max(currentDepth, max);

            if (currentNode.left != null) {
                nodeQueue.add(currentNode.left);
                depthQueue.add(currentDepth + 1);
            }

            if (currentNode.right != null) {
                nodeQueue.add(currentNode.right);
                depthQueue.add(currentDepth + 1);
            }
        }

        return max;
    }


}
