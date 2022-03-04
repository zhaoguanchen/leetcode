package leetcode.solution.Tree.BST;

import leetcode.Structure.TreeNode;

/**
 * 652. Find Duplicate Subtrees
 */
public class ConvertBSTToGreaterTree {

    public static void main(String[] args) {
        Integer[] inorder = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode treeNode = TreeNode.constructTree(inorder);
        System.out.println(TreeNode.print(convertBST(treeNode)));
    }

    /**
     * 全局变量，记录和
     */
    private static int sum = 0;


    public static TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    /**
     * 中序遍历
     * 中序遍历即为二叉搜索树的从小到大排序
     *
     * @param root
     */
    private static void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先遍历右节点
        helper(root.right);
        // 赋值
        sum += root.val;
        root.val = sum;
        // 再遍历左节点
        helper(root.left);
    }
}
