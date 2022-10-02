package leetcode.solution.DFS;

/**
 * 547. Number of Provinces
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int ans = numberOfProvinces.findCircleNum(grid);
        System.out.println(ans);
        // 2
    }

    int[][] isConnected;

    int[] visited;

    int n;

    public int findCircleNum(int[][] isConnected) {
        this.n = isConnected.length;
        this.isConnected = isConnected;
        this.visited = new int[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            dfs(i);
            count++;
        }

        return count;

    }

    private void dfs(int city) {
        visited[city] = 1;

        for (int i = 0; i < n; i++) {
            if (city == i) {
                continue;
            }

            if (isConnected[city][i] == 0) {
                continue;
            }

            if (visited[i] == 1) {
                continue;
            }

            dfs(i);
        }

    }
}
