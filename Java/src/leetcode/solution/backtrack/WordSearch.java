package leetcode.solution.backtrack;

/**
 * 79. Word Search
 */
public class WordSearch {

    public static void main(String[] args) {
        String word = "ABCB";
        char[][] data = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        WordSearch wordSearch = new WordSearch();
        boolean ans = wordSearch.exist(data, word);
        System.out.println(ans);
    }


    int m;

    int n;

    char[][] board;

    String word;

    /**
     * ans
     */
    boolean isExist;

    /**
     * move direction
     */
    int[][] direct;

    public boolean exist(char[][] board, String word) {
        isExist = false;
        this.word = word;
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.direct = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(i, j, 0);
                // is already exist, break the loop
                if (isExist) {
                    break;
                }
            }
        }

        return isExist;
    }


    private void backtrack(int i, int j, int index) {
        // already get the right path
        if (isExist) {
            return;
        }

        // out of bound
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        // visited before, return
        if ('#' == board[i][j]) {
            return;
        }

        // wrong choice
        if (board[i][j] != word.charAt(index)) {
            return;
        }

        // this is the last character
        if (index == word.length() - 1) {
            isExist = true;
            return;
        }

        // mark as visited
        board[i][j] = '#';
        // backtrack each direction
        for (int[] d : direct) {
            backtrack(i + d[0], j + d[1], index + 1);
        }

        // revoke the mark
        board[i][j] = word.charAt(index);
    }
}
