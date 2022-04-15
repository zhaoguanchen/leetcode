package leetcode.solution.BFS;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {


        Integer[] array = {1, 2, 3, null, 5, null, 4};
        TreeNode r = TreeNode.constructTree(array);
        System.out.println(rightSideView(r));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        int dept = 0;
        TreeNode cur = root;
        while (cur != null) {
            result.add(cur.val);
            cur = cur.right;
        }
        return new ArrayList<>();
    }
}
