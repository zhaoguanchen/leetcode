package leetcode.solution.tree.completeBinaryTree;

import leetcode.structure.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, null, 5, null, 4};
        TreeNode r = TreeNode.constructTree(array);
        CountCompleteTreeNodes solution = new CountCompleteTreeNodes();
        int ans = solution.countNodes(r);
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

        if (hLeft == hRight) {
            return (int) Math.pow(2, hLeft) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

}
