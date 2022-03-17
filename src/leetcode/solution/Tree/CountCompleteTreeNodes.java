package leetcode.solution.Tree;

import leetcode.Structure.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        Integer[] pArray = {1, 2, 3, 4, 5, 6};
        TreeNode root = TreeNode.constructTree(pArray);
        CountCompleteTreeNodes l = new CountCompleteTreeNodes();
        int ans = l.countNodes(root);
        System.out.println(ans);
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hLeft = 1;
        int hRight = 1;
        TreeNode curLeft = root;
        while (null != curLeft.left) {
            curLeft = curLeft.left;
            hLeft++;
        }

        TreeNode curRight = root;
        while (null != curRight.right) {
            curRight = curRight.right;
            hRight++;
        }

        // 如果左右等高，则是一个满二叉树，可直接通过公式算出，无需递归
        if (hLeft == hRight) {
            return (int) Math.pow(2, hLeft) - 1;
        } else {
            // 递归计算左右子树
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }


}
