package leetcode.solution.backtrack;

/**
 * 51. N-Queens
 */
public class NQueensII {

    public static void main(String[] args) {
        int n = 4;
        NQueensII nQueens = new NQueensII();
        int ans = nQueens.totalNQueens(n);
        System.out.println(ans);
        // 2
    }

    int ans;
    int[] col;
    int[] diagonal;
    int[] antiDiagonal;
    int size;
    int[][] data;

    public int totalNQueens(int n) {
        size = n;
        data = new int[n][n];
        col = new int[n];
        diagonal = new int[2 * n - 1];
        antiDiagonal = new int[2 * n - 1];
        ans = 0;
        backtrack(0);
        return ans;
    }

    private void backtrack(int row) {
        if (row == size) {
            ans++;
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


}