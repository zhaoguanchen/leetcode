package leetcode.solution.tree.bst;

import leetcode.structure.TreeNode;

/**
 * 99. Recover Binary Search Tree
 */
public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        Integer[] data = {3, 1, 4, null, null, 2};
        TreeNode treeNode = TreeNode.constructTree(data);
        RecoverBinarySearchTree r = new RecoverBinarySearchTree();
        r.recoverTree(treeNode);
        System.out.println(TreeNode.print((treeNode)));
//        2,1,4,null,null,3
    }

    public void recoverTree(TreeNode root) {

    }
}
