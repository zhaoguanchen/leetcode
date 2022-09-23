package leetcode.solution.tree.Construct;

import leetcode.structure.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println(TreeNode.print(treeNode));

    }

    private static int[] postorderArray;
    private static int[] inorderArray;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderArray = inorder;
        postorderArray = postorder;

        // inorder起止
        int iStart = 0;
        int iEnd = inorderArray.length - 1;
        // postorder起止
        int pStart = 0;
        int pEnd = postorderArray.length - 1;
        return helper(iStart, iEnd, pStart, pEnd);
    }

    private static TreeNode helper(int iStart, int iEnd, int pStart, int pEnd) {
        // 结束条件
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }

        // root节点为后序遍历中最后一个
        int rootVal = postorderArray[pEnd];

        // 在中序遍历数组中找到root位置
        int rootIndexInOrder = -1;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorderArray[i] == rootVal) {
                rootIndexInOrder = i;
                break;
            }
        }
        // 构建节点
        TreeNode root = new TreeNode(rootVal);

        // 左子树节点数量为中序遍历中根节点左侧的元素数量
        int leftSize = rootIndexInOrder - iStart;


        // 递归构建左右子树
        root.left = helper(iStart, rootIndexInOrder - 1, pStart, pStart + leftSize - 1);
        root.right = helper(rootIndexInOrder + 1, iEnd, pStart + leftSize, pEnd - 1);

        return root;
    }
}
