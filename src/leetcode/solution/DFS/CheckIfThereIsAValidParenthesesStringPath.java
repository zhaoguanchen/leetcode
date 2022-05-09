package leetcode.solution.DFS;

import java.util.HashMap;
import java.util.Map;

/**
 * 2267. Check if There Is a Valid Parentheses String Path
 */
public class CheckIfThereIsAValidParenthesesStringPath {

    public static void main(String[] args) {
        char[][] grid = {{'(', '(', ')'}, {')', ')', ')'}, {')', ')', ')'}, {'(', '(', ')'}};

        CheckIfThereIsAValidParenthesesStringPath solution = new CheckIfThereIsAValidParenthesesStringPath();
        boolean ans = solution.hasValidPath(grid);
        System.out.println(ans);
    }


    private int m;
    private int n;
    private char[][] grid;
    private Map<String, Boolean> memo;


    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        memo = new HashMap<>();

        // basic case: the path should start with '(' and end with ')'
        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
            return false;
        }

        // basic case: the count of value in the path should be even.
        // so m+n should be odd
        if ((m + n) % 2 == 0) {
            return false;
        }

        // dfs
        return traverse(0, 0, 0);
    }


    private boolean traverse(int i, int j, int count) {
        if (i >= m || j >= n) {
            return false;
        }

        // calculate the number of '('
        char c = grid[i][j];
        if (c == '(') {
            count++;
        } else {
            // when encounter with ')', offset one '('
            count--;
        }

        // arrive the end position
        if (i == m - 1 && j == n - 1) {
            // perfect pair
            if (count == 0) {
                return true;
            }
        }

        // if count < 0, the path will start with ')', illegal.
        // if count > (m + n - 1) / 2, there would be no enough ')' left to offset the '('
        if (count < 0 || count > (m + n - 1) / 2) {
            return false;
        }

        // check the memo
        String key = generateKey(i, j, count);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // traverse next position. right or down.
        boolean ans = traverse(i, j + 1, count) || traverse(i + 1, j, count);
        // add to memo
        memo.put(key, ans);
        return ans;
    }

    /**
     * generate some kind of key. we use '-' to split elements here.
     *
     * @param i
     * @param j
     * @param currentCount
     * @return
     */
    private String generateKey(int i, int j, int currentCount) {
        return i + "-" + j + "-" + currentCount;
    }


}