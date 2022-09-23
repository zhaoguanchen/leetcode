package leetcode.solution.tree;

import leetcode.structure.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 */
public class SumRootOoLeafNumbers {

    public static void main(String[] args) {
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.constructTree(array);
        SolutionDFS solutionDFS = new SolutionDFS();
        int ans = solutionDFS.sumNumbers(root);
        System.out.println(ans);
//        System.out.println(isBalancedIterator(root));
    }
}

class SolutionDFS {

    private int sum;

    public int sumNumbers(TreeNode root) {
        this.sum = 0;
        dfs(root, 0);
        return sum;
    }


    private void dfs(TreeNode root, int base) {

        int currentSum = base * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += currentSum;
            return;
        }

        if (root.left != null) {
            dfs(root.left, currentSum);
        }

        if (root.right != null) {
            dfs(root.right, currentSum);
        }

    }
}