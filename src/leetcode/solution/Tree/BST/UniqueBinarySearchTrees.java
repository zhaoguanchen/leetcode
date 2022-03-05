package leetcode.solution.Tree.BST;

/**
 * 450. Delete Node in a BST
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        int val = 3;
        System.out.println(numTrees(val));
    }


    private static int[][] memo;

    public static int numTrees(int n) {
        memo = new int[n + 1][n + 1];

        return helper(1, n);
    }

    private static int helper(int start, int end) {
        if (start > end) {
            return 1;
        }

        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int count = 0;
        for (int i = start; i <= end; i++) {
            int leftVal = helper(start, i - 1);
            int rightVal = helper(i + 1, end);

            count += leftVal * rightVal;
        }

        memo[start][end] = count;
        return count;

    }


}
