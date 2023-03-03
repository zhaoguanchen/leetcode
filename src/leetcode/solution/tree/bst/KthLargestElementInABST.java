package leetcode.solution.tree.bst;

import leetcode.structure.TreeNode;

import java.util.Stack;

/**
 * Kth Largest Element in a BST
 */
public class KthLargestElementInABST {

    public static void main(String[] args) {
        Integer[] inorder = {3, 1, 10, null, 2, 7, null};
        TreeNode treeNode = TreeNode.constructTree(inorder);
        int k = 4;
        KthLargestElementRecursion recursion = new KthLargestElementRecursion();
        int ans = recursion.kthLargest(treeNode, k);
        System.out.println(ans);


        KthLargestElementIteration iteration = new KthLargestElementIteration();
        ans = iteration.kthLargest(treeNode, k);
        System.out.println(ans);


        inorder = new Integer[]{5, 3, 10, null, null, 7, 15, null, null, 14, 16};
        treeNode = TreeNode.constructTree(inorder);
        k = 6;
        ans = recursion.kthLargest(treeNode, k);
        System.out.println(ans);


        ans = iteration.kthLargest(treeNode, k);
        System.out.println(ans);
    }


}

class KthLargestElementRecursion {
    /**
     * global variable, same as k
     * 全局变量，记录要找的排名
     */
    private int kth;

    /**
     * the order of current node
     * 当前节点的排名
     */
    private int current;

    /**
     * the value of final result
     * 结果值
     */
    private int value;


    public int kthLargest(TreeNode root, int k) {
        kth = k;
        current = 0;
        helper(root);
        return value;
    }

    /**
     * Inorder Traversal
     * 中序遍历
     * <p>
     * means sort from smallest to largest in the Binary Search Tree
     * 中序遍历即为二叉搜索树的从小到大排序
     *
     * @param root
     */
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.right);

        current++;

        if (current == kth) {
            value = root.val;
            return;
        }

        helper(root.left);
    }


}


class KthLargestElementIteration {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);  // Just like recursion
                p = p.right;

            } else {
                TreeNode node = stack.pop();
                if (++count == k) {
                    return node.val;
                }
                p = node.left;
            }
        }

        return Integer.MIN_VALUE;
    }
}