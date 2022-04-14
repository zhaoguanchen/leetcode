package leetcode.solution.BackTracking;

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

    private char[][] board;

    private String word;

    private int[][] direct;

    private int[][] visited;


    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new int[board.length][board[0].length];
        this.direct = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        char firstLetter = word.charAt(0);
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != firstLetter) {
                    continue;
                }
                visited[i][j] = 1;
                ans = backtrack(1, i, j);
                if (ans) {
                    return true;
                }
                visited[i][j] = 0;
            }
        }
        return ans;


    }

    private boolean backtrack(int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        char firstLetter = word.charAt(index);
        boolean ans = false;
        for (int[] item : direct) {
            int nextI = item[0] + i;
            int nextJ = item[1] + j;

            if (outOfBoard(nextI, nextJ)) {
                continue;
            }

            if (visited[nextI][nextJ] == 1) {
                continue;
            }

            char nextLetter = board[nextI][nextJ];
            if (nextLetter != firstLetter) {
                continue;
            }

            visited[nextI][nextJ] = 1;
            ans = backtrack(index + 1, nextI, nextJ);
            if (ans) {
                return true;
            }
            visited[nextI][nextJ] = 0;
        }

        return false;
    }

    private boolean outOfBoard(int i, int j) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length;
    }

}
