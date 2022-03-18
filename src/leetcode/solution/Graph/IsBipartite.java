package leetcode.solution.Graph;

/**
 * 785. Is Graph Bipartite?
 */
public class IsBipartite {

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        IsBipartite isBipartite = new IsBipartite();
        System.out.println(isBipartite.isBipartite(graph));
    }

    /**
     * 结果标记  是否是二分图
     */
    private boolean ans;

    private int[][] graphVar;

    /**
     * 访问标记
     */
    private boolean[] visited;

    /**
     * true为红色，false为黑色
     */
    private boolean[] color;

    public boolean isBipartite(int[][] graph) {
        graphVar = graph;
        visited = new boolean[graph.length];
        color = new boolean[graph.length];
        ans = true;

        // 因为可能出现非联通图，所以每个顶点都遍历一遍
        for (int i = 0; i < graph.length; i++) {
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
        for (int t : graphVar[s]) {
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

}
