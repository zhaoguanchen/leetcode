package leetcode.solution.backtrack;

import leetcode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, 5};
        TreeNode treeNode = TreeNode.constructTree(nums);
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> ans = binaryTreePaths.binaryTreePaths(treeNode);
        System.out.println(ans);
    }


    private List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if (root == null) {
            return ans;
        }
        // add root node
        path.append(root.val);
        backtrack(root, path);

        return ans;
    }

    private void backtrack(TreeNode root, StringBuilder path) {
        // 根结点为null
        if (root == null) {
            return;
        }

        // 叶子节点
        if (root.left == null && root.right == null) {
            ans.add(path.toString());
            return;
        }

        // 左子节点
        if (root.left != null) {
            String next = "->" + root.left.val;
            path.append(next);
            backtrack(root.left, path);
            path.delete(path.length() - next.length(), path.length());
        }

        // 右子节点
        if (root.right != null) {
            String next = "->" + root.right.val;
            path.append(next);
            backtrack(root.right, path);
            path.delete(path.length() - next.length(), path.length());
        }
    }


}
