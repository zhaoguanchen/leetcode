package leetcode.solution.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 310. Minimum Height Trees
 */
public class MinimumHeightTrees {

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};

        MinimumHeightTreesSolution solution = new MinimumHeightTreesSolution();
        List<Integer> ans = solution.findMinHeightTrees(n, edges);
        System.out.println(ans);
        // [1]
    }


}

class MinimumHeightTreesSolution {


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        // only have 2 nodes. return.
        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            return ans;
        }

        List<List<Integer>> table = buildAdjacencyList(n, edges);

        Queue<Integer> queue = new LinkedList<>();

        // add all the leaves
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).size() == 1) {
                queue.add(i);
            }
        }

        int remainNum = n;
        while (remainNum > 2) {
            int size = queue.size();
            // the number of node if we remove all the leaves
            remainNum -= size;
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                List<Integer> neighbors = table.get(node);
                for (int neighbor : neighbors) {
                    // remove current node from the neighbor's neighbors list.
                    table.get(neighbor).remove(node);
                    // if the neighbor is a leave, add to queue
                    if (table.get(neighbor).size() == 1) {
                        queue.add(neighbor);
                    }
                }
            }


        }
        ans.addAll(queue);

        return ans;
    }


    private List<List<Integer>> buildAdjacencyList(int n, int[][] edges) {
        List<List<Integer>> table = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            table.add(new ArrayList<>());
        }


        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            table.get(from).add(to);
            table.get(to).add(from);
        }

        return table;
    }

}