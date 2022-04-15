package leetcode.solution.Tree;

import leetcode.structure.TreeNode;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {
        Integer[] pArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12, 13};
        TreeNode root = TreeNode.constructTree(pArray);
        LowestCommonAncestorOfBinaryTree l = new LowestCommonAncestorOfBinaryTree();
        TreeNode p = root.left.left;
        TreeNode q = root.left.right;
        TreeNode f = l.lowestCommonAncestor(root, p, q);
        System.out.println(f.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        // 找到当前节点为p或q，则返回
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (null != left && null != right) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }

    }


}
