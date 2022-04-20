package leetcode.solution.tree;

import leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MinimumDepth {

    public static void main(String[] args) {
        Integer[] array = {2, null, 3, null, 4, null, 5, null, 6};
        TreeNode root = TreeNode.constructTree(array);
        System.out.println(minDepth(root));
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        return minDepth + 1;
    }


    public static int minDepthIterator(TreeNode root) {
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
