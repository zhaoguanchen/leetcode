package leetcode.solution.tree;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 617. Merge Two Binary Trees
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, null, 5, null, 4};
        TreeNode r1 = TreeNode.constructTree(array1);
        Integer[] array2 = {1, 2, 3, null, 5, null, 4};
        TreeNode r2 = TreeNode.constructTree(array2);

        MergeTwoBinaryTrees view = new MergeTwoBinaryTrees();
        TreeNode ans = view.mergeTrees(r1, r2);
        System.out.println(TreeNode.print(ans));
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);


        return root1;
    }

}
