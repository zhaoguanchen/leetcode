package leetcode.solution.DP;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 */
public class CheapestFlightsWithinKStops {


    public static void main(String[] args) {
        int n = 4;
        int src = 0;
        int dst = 3;
        int k = 1;
        int[][] grid = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        int ans = cheapestFlightsWithinKStops.findCheapestPrice(n, grid, src, dst, k);
        System.out.println(ans);
//        Output: 700


//        DjSolution djSolution = new DjSolution();
//        int ans1 = djSolution.findCheapestPrice(n, grid, src, dst, k);
//        System.out.println(ans1);

    }

    int[][] memo;

    int s;

    Map<Integer, List<int[]>> map;

    /**
     * 动态规划倒推法
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        map = new HashMap<>();
        s = src;
        // 点转换为边  表示飞的次数
        k++;
        // k步数下，走到i节点的cost；k从1开始，因此长度+1
        memo = new int[n][k + 1];

        for (int[] item : memo) {
            Arrays.fill(item, -1111);
        }

        // 构建邻接表
        for (int[] row : flights) {
            int from = row[0];
            int to = row[1];
            int price = row[2];

            map.putIfAbsent(to, new ArrayList<>());
            List<int[]> list = map.get(to);
            // 存储指向当前节点的节点列表
            list.add(new int[]{from, price});
        }

        return helper(dst, k);
    }

    private int helper(int target, int k) {
        int ans = Integer.MAX_VALUE;
        // 当前节点为起点
        if (target == s) {
            return 0;
        }

        System.out.println("k" + k);
        if (k <= 0) {
            return -1;
        }


        if (memo[target][k] != -1111) {
            return memo[target][k];
        }

        List<int[]> list = map.get(target);
        // 该节点不可达
        if (list == null) {
            return -1;
        }

        System.out.println(list);

        // 递归前序节点
        for (int[] item : list) {
            int fromId = item[0];
            int price = item[1];

            System.out.println(fromId);
            int fromAns = helper(fromId, k - 1);
            if (fromAns == -1) {
                continue;
            }

            ans = Math.min(ans, price + fromAns);
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        memo[target][k] = ans;
        return ans;


//        return 1;
    }


}

/**
 * Dijkstra算法  BFS
 */
class DjSolution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map;
        map = new HashMap<>();

        for (int[] row : flights) {
            int from = row[0];
            int to = row[1];
            int price = row[2];

            map.putIfAbsent(from, new ArrayList<>());
            List<int[]> list = map.get(from);
            list.add(new int[]{to, price});
        }

        // 存储到达某节点的最小cost
        int[] costMemo = new int[n];
        // 存储到达某节点的最小转机次数
        int[] kMemo = new int[n];
        Arrays.fill(costMemo, Integer.MAX_VALUE);
        Arrays.fill(kMemo, Integer.MAX_VALUE);

        PriorityQueue<State> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.costFromSrc));

        priorityQueue.add(new State(src, 0, 0));

        while (!priorityQueue.isEmpty()) {
            State state = priorityQueue.poll();
            // 到达终点
            if (state.id == dst) {
                return state.costFromSrc;
            }
            // 没有中转机会 跳过
            if (state.nodeNumFromSrc > k) {
                continue;
            }
            int id = state.id;

            List<int[]> nextList = map.get(id);
            if (null == nextList) {
                continue;
            }

            // 下一个可达的点
            for (int[] item : nextList) {
                int to = item[0];
                int price = item[1];

                int cost = price + state.costFromSrc;
                int num = 1 + state.nodeNumFromSrc;

                if (cost < costMemo[to]) {
                    costMemo[to] = cost;
                    kMemo[to] = num;
                } else if (cost > costMemo[to] && num > kMemo[to]) {
                    continue;
                }

                State next = new State(to, cost, num);
                priorityQueue.add(next);
            }


        }
        return -1;
    }


}

class State {
    // 图节点的 id
    int id;
    // 从 src 节点到当前节点的花费
    int costFromSrc;
    // 从 src 节点到当前节点经过的节点个数
    int nodeNumFromSrc;

    State(int id, int costFromSrc, int nodeNumFromSrc) {
        this.id = id;
        this.costFromSrc = costFromSrc;
        this.nodeNumFromSrc = nodeNumFromSrc;
    }
}