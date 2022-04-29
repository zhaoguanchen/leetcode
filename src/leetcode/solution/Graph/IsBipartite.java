package leetcode.solution.Graph;

/**
 * 785. Is Graph Bipartite?
 */
public class IsBipartite {

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        IsBipartiteSolutionWithVisitedMemo isBipartite = new IsBipartiteSolutionWithVisitedMemo();
        boolean ans = isBipartite.isBipartite(graph);
        System.out.println(ans);

        IsBipartiteSolution isBipartite1 = new IsBipartiteSolution();
        ans = isBipartite1.isBipartite(graph);
        System.out.println(ans);
    }


}

/**
 * Using Array as visit Memo
 */
class IsBipartiteSolutionWithVisitedMemo {

    /**
     * the result, default true
     */
    private boolean ans;

    private int[][] graph;

    /**
     * visited
     */
    private boolean[] visited;

    /**
     * true for red，false for black
     */
    private boolean[] color;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        visited = new boolean[graph.length];
        color = new boolean[graph.length];
        // default result is true. We will try to break the result later.
        ans = true;

        // check every node since there may have independent graph.
        // just choose those nodes that not be visited.
        for (int i = 0; i < graph.length; i++) {
            if (visited[i]) {
                continue;
            }
            traverse(i);
        }

        return ans;
    }


    private void traverse(int s) {
        // result is confirmed
        // not a Bipartite Graph
        if (!ans) {
            return;
        }

        // sign as visited
        visited[s] = true;

        // traverse its neighbors
        for (int t : graph[s]) {
            // new node, paint different color and traverse
            if (!visited[t]) {
                color[t] = !color[s];
                traverse(t);
            } else {
                // visited, assert if the color is conflict.
                if (color[s] == color[t]) {
                    ans = false;
                    return;
                }
            }
        }

    }
}


/**
 * Using specific color as visit signal
 */
class IsBipartiteSolution {

    /**
     * the result, default true
     */
    private boolean ans;

    private int[][] graph;

    /**
     * default 0 which means not visited, -1 for red，1 for black
     */
    private int[] color;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        color = new int[graph.length];
        // default result is true. We will try to break the result later.
        ans = true;
        // check every node since there may have independent graph.
        // just choose those nodes that not be visited.
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) {
                continue;
            }
            // paint red(black is also ok)
            color[i] = 1;
            traverse(i);
        }

        return ans;
    }


    private void traverse(int s) {
        // result is confirmed
        // not a Bipartite Graph
        if (!ans) {
            return;
        }
        // traverse its neighbors
        for (int i : graph[s]) {
            // visited, assert if the color is conflict.
            if (color[i] != 0) {
                if (color[i] == color[s]) {
                    ans = false;
                    return;
                }
            } else { // new node, paint different color and traverse
                color[i] = -color[s];
                traverse(i);
            }
        }
    }
}