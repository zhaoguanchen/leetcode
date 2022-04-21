package leetcode.solution.backtrack;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. Unique Binary Search Trees II
 */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        int n = 3;
        UniqueBinarySearchTreesII searchTreesII = new UniqueBinarySearchTreesII();
        List<TreeNode> ans = searchTreesII.generateTrees(n);
        for (TreeNode treeNode : ans) {
            System.out.println(TreeNode.print(treeNode));
        }
        // [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
    }

    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }


    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();

        // no value available, it should be null
        if (start > end) {
            ans.add(null);
            return ans;
        }

        for (int i = start; i <= end; i++) {
            // get left child node
            List<TreeNode> leftList = helper(start, i - 1);
            // get right child node
            List<TreeNode> rightList = helper(i + 1, end);

            // combine all possible left node and right node
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    // we need to construct root node every time
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }

        }

        return ans;

    }
}
