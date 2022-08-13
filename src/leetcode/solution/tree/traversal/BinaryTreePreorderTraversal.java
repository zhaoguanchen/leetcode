package leetcode.solution.tree.traversal;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
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
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return ans;


    }


}
