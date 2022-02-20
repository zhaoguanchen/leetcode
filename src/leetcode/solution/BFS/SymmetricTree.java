package leetcode.solution.BFS;

import leetcode.Structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = TreeNode.constructTree(array);
        System.out.println(isSymmetric(root));
        System.out.println(isSameIterator(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    private static boolean isSame(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return isSame(leftNode.left, rightNode.right) && isSame(leftNode.right, rightNode.left);
    }


    private static boolean isSameIterator(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
