package leetcode.solution.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3, 3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }


    private static int[][] graphArr;

    private static List<List<Integer>> resList;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        graphArr = graph;
        resList = new ArrayList<>();
        System.out.println(graphArr.length);
        helper(0, new LinkedList<>());
        return resList;
    }

    public static void helper(int cur, LinkedList<Integer> path) {
        // 加入当前节点
        path.add(cur);
        // 到达n - 1
        if (cur == graphArr.length - 1) {
            resList.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }

        for (int i : graphArr[cur]) {
            // 处理可达子节点
            helper(i, path);
        }


        // 撤销选择
        path.removeLast();

    }


}
