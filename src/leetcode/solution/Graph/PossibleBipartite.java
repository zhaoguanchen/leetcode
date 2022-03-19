package leetcode.solution.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 886. Possible Bipartite
 */
public class PossibleBipartite {

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        int n = 5;
        PossibleBipartite isBipartite = new PossibleBipartite();
        System.out.println(isBipartite.possibleBipartite(n, graph));
    }

    /**
     * 结果标记  是否是二分图
     */
    private boolean ans;

    private List<Integer>[] table;

    /**
     * 访问标记
     */
    private boolean[] visited;

    /**
     * true为红色，false为黑色
     */
    private boolean[] color;

    public boolean possibleBipartite(int n, int[][] dislikes) {
        table = build(n, dislikes);
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        ans = true;

        // 因为可能出现非联通图，所以每个顶点都遍历一遍
        for (int i = 1; i < table.length; i++) {
            traverse(i);
        }

        return ans;
    }

    private void traverse(int s) {
        // 已判断出结果，直接返回
        if (!ans) {
            return;
        }

        visited[s] = true;
        for (int t : table[s]) {
            // 未遍历过，涂不一样的颜色，DFS遍历
            if (!visited[t]) {
                color[t] = !color[s];
                traverse(t);
            } else {
                // 遍历过，判断颜色是否一致，一致则冲突
                if (color[s] == color[t]) {
                    ans = false;
                }
            }
        }

    }

    /**
     * 构建邻接表
     *
     * @param n
     * @param dislikes
     * @return
     */
    private List<Integer>[] build(int n, int[][] dislikes) {
        // 人从1开始，开辟数组大小为n+1;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] item : dislikes) {
            int from = item[0];
            int to = item[1];
            // a 不喜欢 b，则ab不能相邻  作为无向图处理
            graph[from].add(to);
            graph[to].add(from);
        }

        return graph;
    }

}
