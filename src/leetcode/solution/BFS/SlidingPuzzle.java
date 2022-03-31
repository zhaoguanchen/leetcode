package leetcode.solution.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 773. Sliding Puzzle
 */
public class SlidingPuzzle {

    public static void main(String[] args) {
        int[][] data = {{4, 1, 2}, {5, 0, 3}};
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        int ans = slidingPuzzle.slidingPuzzle(data);
        System.out.println(ans);
        // 5
    }

    public int slidingPuzzle(int[][] board) {
        // 下标i所对应的邻居（可移动的位置）
        int[][] neighbor = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                stringBuilder.append(board[i][j]);
            }
        }
        // 初始字符串
        String str = stringBuilder.toString();
        // 目标字符串
        String target = "123450";

        // 备忘录
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(str);
        // 记录交换次数
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (target.equals(current)) {
                    return count;
                }
                visited.add(current);
                // 0所在的索引
                int indexOfZero = current.indexOf('0');
                // 遍历其邻居，尝试所有交换可能
                for (int c : neighbor[indexOfZero]) {
                    String newStr = swap(current, c, indexOfZero);
                    if (visited.contains(newStr)) {
                        continue;
                    }
                    // 添加到队列，进行下一轮处理
                    queue.add(newStr);
                }
            }
            // 一轮处理算作一次移动
            count++;
        }
        // 无结果
        return -1;
    }

    /**
     * 交换元素
     *
     * @param str
     * @param i
     * @param j
     */
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
