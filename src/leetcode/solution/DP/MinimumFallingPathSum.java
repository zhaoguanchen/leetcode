package leetcode.solution.DP;

import java.util.Arrays;

/**
 * 931. Minimum Falling Path Sum
 */
public class MinimumFallingPathSum {


    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix));
    }

    // 数据
    private static int[][] data;
    // 备忘录 存储各节点的最小路径
    private static int[][] memo;
    // 备忘录初始化默认值  不能初始化为0 因为数据可能为零
    private static final int specificDefault = 99999;

    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        data = matrix;
        // 初始化memo
        memo = new int[m][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], specificDefault);
        }
        // 对最下行求最值
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp(m - 1, i));
        }
        return res;

    }

    private static int dp(int i, int j) {
        // 边界检查，防止数组越界。可直接设置为最大值
        if (i < 0 || j < 0 || i > data.length - 1 || j > data[0].length - 1) {
            return Integer.MAX_VALUE;
        }
        // 第一层的最小路径为数据值，同时赋值到memo
        if (i == 0) {
            memo[i][j] = data[i][j];
            return memo[i][j];
        }

        // 检查备忘录
        if (memo[i][j] != specificDefault) {
            return memo[i][j];
        }

        // 递归求解  子问题为当前节点的左上，上，右上节点
        memo[i][j] = data[i][j] + Math.min(dp(i - 1, j - 1), Math.min(dp(i - 1, j), dp(i - 1, j + 1)));

        return memo[i][j];
    }
}