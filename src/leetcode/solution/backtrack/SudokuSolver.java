package leetcode.solution.backtrack;

import java.util.Arrays;

/**
 * 37. Sudoku Solver
 */
public class SudokuSolver {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    private char[][] data;
    private int length;

    public void solveSudoku(char[][] board) {
        data = board;
        length = board.length;
        backtrack(0, 0);

    }


    private boolean backtrack(int i, int j) {
        // 到达最后一行
        if (i == length) {
            return true;
        }
        // 到达最右边，继续找下一行
        if (j == length) {
            return backtrack(i + 1, 0);
        }
        // 已经有数字
        if (data[i][j] != '.') {
            return backtrack(i, j + 1);
        }


        for (char k = '1'; k <= '9'; k++) {
            // 做选择
            if (!isOk(i, j, k)) {
                continue;
            }
            data[i][j] = k;
            boolean ans = backtrack(i, j + 1);
            if (ans) {
                return true;
            }
            // 撤销选择
            data[i][j] = '.';
        }

        return false;
    }


    /**
     * 判断在(i,j)位置选择字符k是否正确
     *
     * @param i
     * @param j
     * @param k
     * @return
     */
    private boolean isOk(int i, int j, char k) {
        for (int l = 0; l < length; l++) {
            // 判断行
            if (data[i][l] == k) {
                return false;
            }

            // 判断列
            if (data[l][j] == k) {
                return false;
            }

            // 判断九宫格
            int row = (i / 3) * 3 + l / 3;
            int col = (j / 3) * 3 + l % 3;
            if (k == data[row][col]) {
                return false;
            }
        }

        return true;
    }
}