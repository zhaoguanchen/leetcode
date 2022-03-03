package leetcode.solution.Tree.Construct;

import leetcode.Structure.TreeNode;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode treeNode = constructFromPrePost(preorder, postorder);
        System.out.println(TreeNode.print(treeNode));

    }

    private static int[] preorderArray;
    private static int[] postorderArray;

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        preorderArray = preorder;
        postorderArray = postorder;

        // preorder起止
        int preStart = 0;
        int preEnd = preorder.length - 1;
        // postorder起止
        int postStart = 0;
        int postEnd = postorderArray.length - 1;
        return helper(preStart, preEnd, postStart, postEnd);
    }

    private static TreeNode helper(int preStart, int preEnd, int postStart, int postEnd) {
        // 结束条件
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }

        // root节点为前序遍历的第一个；同时也是后序遍历最后一个。
        int rootVal = preorderArray[preStart];
        // 构建节点
        TreeNode root = new TreeNode(rootVal);

        if (preStart == preEnd) {
            return root;
        }

        // 左子root为前序遍历中下一节点
        int leftVal = preorderArray[preStart + 1];

        // 在后序遍历数组中找到leftVal位置
        int leftIndexPostorder = -1;
        for (int i = postStart; i <= postEnd; i++) {
            if (postorderArray[i] == leftVal) {
                leftIndexPostorder = i;
                break;
            }
        }

        // 左子树节点数量为后序遍历中左子根节点左侧的元素数量
        int leftSize = leftIndexPostorder - postStart + 1;

        // 递归构建左右子树
        root.left = helper(preStart + 1, preStart + leftSize, postStart, postStart + leftSize - 1);
        root.right = helper(preStart + leftSize + 1, preEnd, postStart + leftSize, postEnd - 1);

        return root;
    }
}
