package leetcode.solution.tree.traversal;

import leetcode.structure.TreeNode;

import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal
 */
public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        Integer[] pArray = {1, 4, 2, 3};
        TreeNode p = TreeNode.constructTree(pArray);
        System.out.println(postorderTraversal(p));
        System.out.println(postorderIterator(p));

    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }

    public static List<Integer> postorderIterator(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.addFirst(node.val);

            if (node.left != null) {
                stack.add(node.left);
            }

            if (node.right != null) {
                stack.add(node.right);
            }
        }

        return ans;


    }


}
