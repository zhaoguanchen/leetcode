package leetcode.solution.BFS;

import javafx.util.Pair;

import java.util.*;

/**
 * 743. Network Delay Time
 */
public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        // n is the number of node.
        // k is the node that send message.
        int n = 4, k = 2;
        BFSNetworkDelayTime networkDelayTime = new BFSNetworkDelayTime();
        int ans = networkDelayTime.networkDelayTime(times, n, k);
        System.out.println(ans);
        // 2
        DFSNetworkDelayTime dfsNetworkDelayTime = new DFSNetworkDelayTime();
        int ans1 = dfsNetworkDelayTime.networkDelayTime(times, n, k);
        System.out.println(ans1);
        // 2
    }


}

/**
 * BFS
 */
class BFSNetworkDelayTime {

    private int[] result;
    private int n;
    private List<Pair<Integer, Integer>>[] table;

    public int networkDelayTime(int[][] times, int n, int k) {
        this.n = n;
        this.table = generateTable(times);
        this.result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[k] = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(k, 0));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cur = queue.poll();
            Integer node = cur.getKey();
            Integer curTime = cur.getValue();
            List<Pair<Integer, Integer>> neighbor = table[node];
            for (Pair<Integer, Integer> pair : neighbor) {
                int i = pair.getKey();
                int time = pair.getValue();
                int total = time + curTime;
                if (result[i] > total) {
                    result[i] = total;
                    queue.add(new Pair<>(i, total));
                }
            }

        }

        int ans = 0;
        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, result[i]);
        }
        return ans;

    }


    private List<Pair<Integer, Integer>>[] generateTable(int[][] times) {
        List<Pair<Integer, Integer>>[] table = new ArrayList[n + 1];
        for (int i = 1; i < table.length; i++) {
            table[i] = new ArrayList<>();
        }
        for (int[] item : times) {
            int sourceNode = item[0];
            int targetNode = item[1];
            int delay = item[2];
            Pair<Integer, Integer> pair = new Pair<>(targetNode, delay);
            table[sourceNode].add(pair);
        }

        return table;
    }


}

class DFSNetworkDelayTime {
    private int[] result;
    private int n;
    private List<Pair<Integer, Integer>>[] table;

    public int networkDelayTime(int[][] times, int n, int k) {
        this.n = n;
        this.table = generateTable(times);
        this.result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);

        result[k] = 0;
        DFS(new Pair<>(k, 0));


        int ans = 0;
        for (int i = 1; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, result[i]);
        }
        return ans;

    }


    private void DFS(Pair<Integer, Integer> pair) {
        Integer node = pair.getKey();
        Integer curTime = pair.getValue();
        List<Pair<Integer, Integer>> neighbor = table[node];
        for (Pair<Integer, Integer> n : neighbor) {
            int i = n.getKey();
            int time = n.getValue();
            int total = time + curTime;
            if (result[i] > total) {
                result[i] = total;
                DFS(new Pair<>(i, total));
            }
        }
    }


    private List<Pair<Integer, Integer>>[] generateTable(int[][] times) {
        List<Pair<Integer, Integer>>[] table = new ArrayList[n + 1];
        for (int i = 1; i < table.length; i++) {
            table[i] = new ArrayList<>();
        }
        for (int[] item : times) {
            int sourceNode = item[0];
            int targetNode = item[1];
            int delay = item[2];
            Pair<Integer, Integer> pair = new Pair<>(targetNode, delay);
            table[sourceNode].add(pair);
        }

        return table;
    }

}