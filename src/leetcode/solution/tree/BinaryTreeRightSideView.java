package leetcode.solution.tree;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, null, 5, null, 4};
        TreeNode r = TreeNode.constructTree(array);
        BinaryTreeRightSideView view = new BinaryTreeRightSideView();
        List<Integer> ans = view.rightSideView(r);
        System.out.println(ans);
    }


    private List<Integer> ans;

    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        helper(root, 0);
        return ans;
    }


    private void helper(TreeNode root, Integer level) {
        // base case
        if (root == null) {
            return;
        }

        // new level appears, it should be the path
        if (level == ans.size()) {
            ans.add(root.val);
        }

        // right child first
        helper(root.right, level + 1);
        helper(root.left, level + 1);

    }


}
