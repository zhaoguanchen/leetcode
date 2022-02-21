package leetcode.solution.BFS;

import leetcode.Structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  104. Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};

        TreeNode root = TreeNode.constructTree(array);
        System.out.println(maxDepth(root));
        System.out.println(maxDepthDFS(root));

    }

    /**
     * BFS
     */
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
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
    private static int maxDepth = 0;

    public static int maxDepthDFS(TreeNode root) {
        helper(root, 0);
        return maxDepth;
    }

    private static void helper(TreeNode root, int depth) {
        // 走到叶子节点，记录最大深度
        if (root == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        // 深度加一
        depth++;
        // 子节点
        helper(root.left, depth);
        helper(root.right, depth);
    }




}