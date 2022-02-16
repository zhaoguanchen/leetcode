package leetcode.solution.Tree;

import leetcode.Structure.TreeNode;

/**
 * 572. Subtree of Another Tree
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * <p>
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 */
public class SubtreeTree {

    public static void main(String[] args) {
        //root = [3,4,5,1,2], subRoot = [4,1,2]
        Integer[] array1 = {3, 4, 5, 1, 2};
        TreeNode root = TreeNode.constructTree(array1);
        Integer[] array2 = {4, 1, 2};
        TreeNode subRoot = TreeNode.constructTree(array2);
        System.out.println(isSubtree(root, subRoot));

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static Boolean isSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }

        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }
}
