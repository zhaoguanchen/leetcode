package leetcode.solution.tree.traversal;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * <p>
 * left - mid - right
 */
public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        Integer[] pArray = {1, 4, 2, 3, 5, 6, 7};
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(inorderTraversal(p));
        System.out.println(inorderIterator(p));

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }


    private static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }


    public static List<Integer> inorderIterator(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;

    }
}
