package leetcode.solution.Tree;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees
 */
public class FindDuplicateSubtrees {

    public static void main(String[] args) {
        Integer[] inorder = {1, 2, 3, 4, null, 2, 4, null, null, 4};
        TreeNode treeNode = TreeNode.constructTree(inorder);
        System.out.println(findDuplicateSubtrees(treeNode));

    }

    private static List<TreeNode> res;

    private static Map<String, Integer> memo;


    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        res = new ArrayList<>();
        memo = new HashMap<>();
        helper(root);
        return res;
    }

    private static String helper(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = helper(root.left);
        String right = helper(root.right);

        String current = root.val + "/" + left + "/" + right;
        Integer count = memo.getOrDefault(current, 0);
        if (count == 1) {
            res.add(root);
        }

        memo.put(current, count + 1);
        return current;
    }
}
