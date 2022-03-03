package leetcode.solution.Tree;

import leetcode.Structure.TreeNode;

/**
 * 654. Maximum Binary Tree
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        System.out.println(constructMaximumBinaryTree(nums));

    }

    private static int[] numArray;

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        numArray = nums;
        return helper(0, numArray.length - 1);

    }

    private static TreeNode helper(int left, int right) {
        // 不存在子节点，返回null
        if (left > right) {
            return null;
        }

        int maxValue = Integer.MIN_VALUE;
        int indexOfMax = -1;

        // 去当前区间最大值
        for (int i = left; i <= right; i++) {
            if (numArray[i] > maxValue) {
                maxValue = numArray[i];
                indexOfMax = i;
            }
        }
        // 构建节点
        TreeNode root = new TreeNode(maxValue);
        // 递归构建左右子树
        root.left = helper(left, indexOfMax - 1);
        root.right = helper(indexOfMax + 1, right);

        return root;
    }
}
