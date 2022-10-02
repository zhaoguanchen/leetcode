package leetcode.solution.tree;

import leetcode.structure.TreeNode;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.constructTree(array);
        FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree find = new FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree();
        TreeNode ans = find.getTargetCopy(root, root, root);
        System.out.println(ans);

    }

     /**
      * @Description: inorder traverse
      * @Author: Guanchen Zhao
      * @Date: 2022/5/16  
      */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // arrived leaf
        if (original == null) {
            return null;
        }

        // found the target Node
        if (original == target) {
            return cloned;
        }

        TreeNode left = getTargetCopy(original.left, cloned.left, target);

        // found in left subtree
        if (left != null) {
            return left;
        }
        // find in right subtree
        return getTargetCopy(original.right, cloned.right, target);

    }

}
