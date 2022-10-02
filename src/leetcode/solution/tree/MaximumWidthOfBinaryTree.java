package leetcode.solution.tree;

import javafx.util.Pair;
import leetcode.structure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 662. Maximum Width of Binary Tree
 */
public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        Integer[] pArray = {1, 3, 2, 5, null, null, 9, 6, null, 7};
        TreeNode root = TreeNode.constructTree(pArray);
        MaximumWidthOfBinaryTreeSolution solution = new MaximumWidthOfBinaryTreeSolution();
        int ans = solution.widthOfBinaryTree(root);
        System.out.println(ans);
        // 7

        MaximumWidthOfBinaryTreeBFSSolution bfsSolution = new MaximumWidthOfBinaryTreeBFSSolution();
        ans = bfsSolution.widthOfBinaryTree(root);
        System.out.println(ans);
        // 7
    }


}

/**
 * @Description: DFS
 * @Author: Guanchen Zhao
 * @Date: 2022/5/19
 */
class MaximumWidthOfBinaryTreeSolution {

    Map<Integer, Integer> memo;

    int maxWidth;

    public int widthOfBinaryTree(TreeNode root) {
        memo = new HashMap<>();
        maxWidth = 0;
        dfs(root, 0, 0);

        System.out.println(memo);
        return maxWidth;
    }


    private void dfs(TreeNode root, int index, int level) {
        if (root == null) {
            return;
        }

        if (!memo.containsKey(level)) {
            memo.put(level, index);
        }

        int firstIndex = memo.get(level);

        maxWidth = Math.max(maxWidth, index - firstIndex + 1);

        dfs(root.left, index * 2, level + 1);
        dfs(root.right, index * 2 + 1, level + 1);
    }

}


/**
 * @Description: BFS
 * @Author: Guanchen Zhao
 * @Date: 2022/5/19
 */
class MaximumWidthOfBinaryTreeBFSSolution {


    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            Pair<TreeNode, Integer> first = queue.peek();
            int firstIndex = first.getValue();
            Pair<TreeNode, Integer> node = null;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.getKey().left != null) {
                    queue.add(new Pair<>(node.getKey().left, node.getValue() * 2));
                }
                if (node.getKey().right != null) {
                    queue.add(new Pair<>(node.getKey().right, node.getValue() * 2 + 1));
                }

            }

            int lastIndex = node.getValue();
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }


}