package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 */
public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        NQueens nQueens = new NQueens();
        List<List<String>> ans = nQueens.solveNQueens(n);
        System.out.println(ans);
        // [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    }

    List<List<String>> ans;

    int[] col;
    int[] diagonal;
    int[] antiDiagonal;
    int size;
    int[][] data;

    public List<List<String>> solveNQueens(int n) {
        size = n;
        data = new int[n][n];
        col = new int[n];
        diagonal = new int[2 * n - 1];
        antiDiagonal = new int[2 * n - 1];
        ans = new ArrayList<>();
        backtrack(0);
        return ans;
    }

    private void backtrack(int row) {
        if (row == size) {
            List<String> res = generate();
            ans.add(res);
            return;
        }

        for (int colIndex = 0; colIndex < size; colIndex++) {
            if (isNotAvailable(row, colIndex)) {
                continue;
            }

            // 做选择
            data[row][colIndex] = 1;
            // 添加备忘录
            setMemo(row, colIndex, 1);
            backtrack(row + 1);
            // 撤销选择
            data[row][colIndex] = 0;
            // 还原备忘录
            setMemo(row, colIndex, 0);
        }

    }


    private void setMemo(int i, int j, int val) {
        col[j] = val;
        int antiDiagonalIndex = i + j;
        antiDiagonal[antiDiagonalIndex] = val;
        int diagonalIndex = i - j + (size - 1);
        diagonal[diagonalIndex] = val;
    }

    private boolean isNotAvailable(int i, int j) {
        if (col[j] == 1) {
            return true;
        }
        int antiDiagonalIndex = i + j;
        if (antiDiagonal[antiDiagonalIndex] == 1) {
            return true;
        }

        int diagonalIndex = i - j + (size - 1);
        if (diagonal[diagonalIndex] == 1) {
            return true;
        }

        return false;
    }


    private List<String> generate() {
        List<String> res = new ArrayList<>();
        for (int[] datum : data) {
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < data[0].length; j++) {
                if (datum[j] == 0) {
                    cur.append(".");
                } else {
                    cur.append("Q");
                }
            }

            res.add(cur.toString());
        }

        return res;
    }

}