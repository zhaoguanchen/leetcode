package leetcode.solution.tree;

import leetcode.structure.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        ConvertSortedArrayToBinarySearchTree searchTree = new ConvertSortedArrayToBinarySearchTree();
        TreeNode node = searchTree.sortedArrayToBST(nums);
        System.out.println(TreeNode.print(node));
    }

    private int[] nums;

    public TreeNode helper(int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int p = (left + right) / 2;

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

}
