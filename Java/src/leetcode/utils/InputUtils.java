package leetcode.utils;

public class InputUtils {

    /**
     * @Description: convert String like "[[0,1],[0,2]]" to grid.
     * @Author: Guanchen Zhao
     * @Date: 2022/5/9
     */
    public static int[][] generateGrid(int m, int n, String s) {
        int[][] grid = new int[m][n];
        String rowSplit = ";";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if ('[' == c) {
                continue;
            }
            if (']' == c) {
                stringBuilder.append(rowSplit);
                i++;
                continue;
            }

            stringBuilder.append(c);


        }
        s = stringBuilder.toString();
        String[] row = s.split(rowSplit);

        for (int i = 0; i < row.length; i++) {
            String rowStr = row[i];
            String[] col = rowStr.split(",");
            for (int j = 0; j < col.length; j++) {
                if (col[j].isEmpty()) {
                    continue;
                }
                grid[i][j] = Integer.parseInt(col[j]);
            }
        }

        return grid;

    }
}
