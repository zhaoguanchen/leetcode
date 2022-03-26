package leetcode.solution.DP;

import java.util.Arrays;

/**
 * 64. Minimum Path Sum
 */
public class MinimumPathSum {


    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int ans = minimumPathSum.minPathSum(grid);
        System.out.println(ans);
//        Output: 7
    }

    int[][] memo;

    int[][] data;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        memo = new int[m][n];
        // 有效数据为>=0, 因此初始化为-1
        for (int[] row : memo)
            Arrays.fill(row, -1);

        data = grid;
        return helper(m - 1, n - 1);
    }

    private int helper(int i, int j) {
        // 初始位置
        if (i == 0 && j == 0) {
            return data[i][j];
        }
        // 超出边界，认定为不可达返回最大整数
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        // 备忘录存在
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 结果值为当前值加上其左边或上边的最小值
        int ans = data[i][j] + Math.min(helper(i - 1, j), helper(i, j - 1));
        // 存储备忘录
        memo[i][j] = ans;
        return ans;
    }
}