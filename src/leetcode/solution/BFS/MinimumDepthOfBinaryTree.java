package leetcode.solution.BFS;

import leetcode.Structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Minimum Depth of Binary Tree
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};

        TreeNode root = TreeNode.constructTree(array);
        System.out.println(minDepth(root));
        System.out.println(minDepthDFS(root));

    }

    /**
     * BFS
     */
    public static int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                // 找到叶子节点，第一个叶子节点的深度即为答案。
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return depth;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    private static int minDepth = Integer.MAX_VALUE;

    public static int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return minDepth;
    }

    private static void helper(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 走到叶子节点，记录最大深度
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
            return;
        }
        // 深度加一
        depth++;
        // 子节点
        helper(root.left, depth);
        helper(root.right, depth);

    }


}