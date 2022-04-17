package leetcode.solution.Tree.BST;

import leetcode.structure.TreeNode;

/**
 * 897. Increasing Order Search Tree
 */
public class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        Integer[] pArray = {5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9};
        TreeNode p = TreeNode.constructTree(pArray);
        IncreasingOrderSearchTree tree = new IncreasingOrderSearchTree();
        TreeNode ans = tree.increasingBST(p);
        System.out.println(TreeNode.print(ans));

    }

    TreeNode p;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode vHead = new TreeNode(0);
        p = vHead;
        inorder(root);
        return vHead.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        root.left = null;
        p.right = root;
        p = p.right;

        inorder(root.right);
    }
}
