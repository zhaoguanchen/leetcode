package leetcode.solution.Tree.Construct;

import leetcode.structure.TreeNode;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println( TreeNode.print(treeNode));

    }

    private static int[] preorderArray;
    private static int[] inorderArray;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderArray = preorder;
        inorderArray = inorder;

        int preorderStart = 0;
        int preorderEnd = preorderArray.length - 1;
        int inorderStart = 0;
        int inorderEnd = inorderArray.length - 1;
        return helper(preorderStart, preorderEnd, inorderStart, inorderEnd);
    }

    private static TreeNode helper(int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }

        // root节点为前序遍历中第一个
        int rootVal = preorderArray[preorderStart];

        // 在中序遍历数组中找到root位置
        int rootIndexInOrder = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorderArray[i] == rootVal) {
                rootIndexInOrder = i;
                break;
            }
        }
        // 构建节点
        TreeNode root = new TreeNode(rootVal);

        int leftSize = rootIndexInOrder - inorderStart;


        // 递归构建左右子树
        root.left = helper(preorderStart + 1, preorderStart + leftSize, inorderStart, rootIndexInOrder - 1);
        root.right = helper(preorderStart + leftSize + 1, preorderEnd, rootIndexInOrder + 1, inorderEnd);

        return root;
    }
}
