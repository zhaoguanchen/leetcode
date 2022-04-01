package leetcode.solution.array;

import java.util.HashSet;

/**
 * 36. Valid Sudoku
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        ValidSudoku rotateImage = new ValidSudoku();
        boolean ans = rotateImage.isValidSudoku(board);
        System.out.println(ans);
        // true
    }

    public boolean isValidSudoku(char[][] board) {
        // hashset存储每行 列 及小单元的数值，以此判断是否重复
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];

        // 初始化
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (row[i].contains(c)) {
                    return false;
                }
                row[i].add(c);
                if (col[j].contains(c)) {
                    return false;
                }
                col[j].add(c);

                int boxId = i / 3 * 3 + j / 3;
                if (box[boxId].contains(c)) {
                    return false;
                }
                box[boxId].add(c);
            }
        }

        return true;
    }


}
