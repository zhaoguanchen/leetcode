package leetcode.solution.tree;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 */
public class FindLeavesOfBinaryTree {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        TreeNode root = TreeNode.constructTree(array);
        FindLeavesOfBinaryTree solution = new FindLeavesOfBinaryTree();
        System.out.println(solution.findLeaves(root));


    }

    List<List<Integer>> ans;

    public List<List<Integer>> findLeaves(TreeNode root) {
        this.ans = new ArrayList<>();
        dfs(root);

        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int h = Math.max(dfs(root.left), dfs(root.right)) + 1;

        if (ans.size() < h) {
            ans.add(new ArrayList<>());
        }

        ans.get(h - 1).add(root.val);

        return h;

    }


}
