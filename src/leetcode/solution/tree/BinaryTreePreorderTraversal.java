package leetcode.solution.tree;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * <p>
 * mid - left - right
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        Integer[] pArray = {1, 4, 2, 3};
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(preorderTraversal(p));
        System.out.println(preorderIterator(p));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);

        return result;
    }

    private static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }

    public static List<Integer> preorderIterator(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current == null) {
                break;
            }

            res.add(current.val);

            if (current.right != null) {
                stack.add(current.right);
            }
            if (current.left != null) {
                stack.add(current.left);
            }

        }
        return res;

    }
}
