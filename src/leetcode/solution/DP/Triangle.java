package leetcode.solution.DP;

import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle
 */
public class Triangle {


    public static void main(String[] args) {

    }
}

 /**
  * @Description: In place
  * @Author: Guanchen Zhao
  * @Date: 2022/6/13  
  */
class SolutionInPlace {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                int currentVal = triangle.get(i).get(j);
                int min = currentVal + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, min);
            }
        }
        
        return triangle.get(0).get(0);
    }
}

class SolutionMemo {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 定义：走到第 i 行第 j 个元素的最小路径和是 dp[i][j]
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            // 因为求最小值，所以全都初始化为极大值
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // base case
        dp[0][0] = triangle.get(0).get(0);
        // 进行状态转移
        for (int i = 1; i < dp.length; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                // 状态转移方程
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + row.get(j);
                } else {
                    dp[i][j] = dp[i - 1][j] + row.get(j);
                }
            }
        }
        // 找出落到最后一层的最小路径和
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < dp[n - 1].length; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }
}