package leetcode.solution.tree.traversal;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Integer[] pArray = {3, 9, 20, null, null, 15, 7};
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(levelOrder(p));
        System.out.println(levelOrderIterator(p));

    }

    private static final List<List<Integer>> resForRecursion = new ArrayList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return resForRecursion;
    }

    private static void helper(TreeNode root, Integer level) {
        if (root == null) {
            return;
        }
        if (resForRecursion.size() == level) {
            resForRecursion.add(new ArrayList<>());
        }
        List<Integer> cur = resForRecursion.get(level);

        cur.add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);

    }

    public static List<List<Integer>> levelOrderIterator(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int total = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < total; i++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    break;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                subList.add(current.val);
            }

            res.add(subList);

        }
        return res;

    }
}
