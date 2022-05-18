package leetcode.solution.Graph;

import java.util.*;

/**
 * 1192. Critical Connections in a Network
 */
public class CriticalConnectionsInANetwork {

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> connections = Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(1, 3));
        CriticalConnectionsInANetworkSolution solution = new CriticalConnectionsInANetworkSolution();
        List<List<Integer>> ans = solution.criticalConnections(n, connections);
        System.out.println(ans);
        // [[1,3]]
    }


}

class CriticalConnectionsInANetworkSolution {

    private int[] memo;

    private List<List<Integer>> adjacencyList;

    private Set<List<Integer>> connectionSet;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.memo = new int[n];
        Arrays.fill(memo, -2);
        this.adjacencyList = buildAdjacencyList(n, connections);
        this.connectionSet = new HashSet<>();
        connectionSet.addAll(connections);
        dfs(0, 0);
        return new ArrayList<>(connectionSet);
    }


    private int dfs(int node, int rank) {
        // visited
        if (memo[node] >= 0) {
            return memo[node];
        }
        memo[node] = rank;

        List<Integer> neighbors = adjacencyList.get(node);
        int min = Integer.MAX_VALUE;
        for (Integer neighbor : neighbors) {
            // ignore parent node
            if (memo[neighbor] == rank - 1) {
                continue;
            }
            int neighborRank = dfs(neighbor, rank + 1);

            // find cycle, thus current edge is not necessary. delete it.
            if (neighborRank <= rank) {
                // we do not know the relation of the two nodes, so delete all possible pairs.
                connectionSet.remove(Arrays.asList(neighbor, node));
                connectionSet.remove(Arrays.asList(node, neighbor));
            }

            min = Math.min(min, neighborRank);
        }

        // of the minimum rank is smaller than the rank of parent node,
        // there must have a cycle.
        return min;

    }


    private List<List<Integer>> buildAdjacencyList(int n, List<List<Integer>> connections) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            Integer from = edge.get(0);
            Integer to = edge.get(1);
            list.get(from).add(to);
            list.get(to).add(from);
        }

        return list;
    }
}