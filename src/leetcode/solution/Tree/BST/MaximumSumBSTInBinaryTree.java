package leetcode.solution.Tree.BST;

import leetcode.Structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 450. Delete Node in a BST
 */
public class MaximumSumBSTInBinaryTree {

    public static void main(String[] args) {
        int val = 3;
        generateTrees(val).forEach(treeNode -> System.out.println(treeNode.val));
    }

    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private static List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = helper(start, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, end);

            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }


}
