package leetcode.solution.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 207. Course Schedule
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;
        CourseScheduleDFS cycleDetect = new CourseScheduleDFS();
        System.out.println(cycleDetect.canFinish(numCourses, prerequisites));
        CourseScheduleBFS bfs = new CourseScheduleBFS();
        System.out.println(bfs.canFinish(numCourses, prerequisites));
    }


}

/**
 * 环检测算法 DFS版本
 * 利用临接表
 * 类比回溯算法
 */
class CourseScheduleDFS {

    /**
     * 默认会初始化为false，因此无需赋值
     */
    private boolean[] visited;

    private boolean[] path;

    private boolean hasCycle;

    private List<Integer>[] graph;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        graph = buildGraph(numCourses, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            traverse(i);
        }

        return !hasCycle;
    }


    private void traverse(int courseNumber) {
        // 历史路径中包含当前课程，出现环
        if (path[courseNumber]) {
            hasCycle = true;
            return;
        }

        // 已经遍历过且还未出现环，顺序一定要在判断环后面
        if (visited[courseNumber]) {
            return;
        }

        // 已经出现环
        if (hasCycle) {
            return;
        }

        visited[courseNumber] = true;
        path[courseNumber] = true;
        // 当前课已完成，继续遍历依赖它的课程（条件已满足）
        for (Integer nextCourseNum : graph[courseNumber]) {
            traverse(nextCourseNum);
        }
        path[courseNumber] = false;
    }

    /**
     * 构建临接表
     * graph[i]中是依赖i的所有课程
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[i]中是依赖i的所有课程
        for (int[] current : prerequisites) {
            // from为被依赖的点
            int from = current[1];
            int to = current[0];
            graph[from].add(to);
        }
        return graph;
    }

}


/**
 * 环检测算法 BFS版本
 * 利用图论中度的性质
 */
class CourseScheduleBFS {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 入度表示依赖  记录该节点依赖的节点数量
        for (int[] edge : prerequisites) {
            int to = edge[0];
            inDegree[to]++;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 加入所有入度为0的点（没有前置依赖）
        for (int i = 0; i < inDegree.length; i++) {
            if (0 == inDegree[i]) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            count++;
            // 将它指向的节点的入度减一
            for (Integer item : graph[num]) {
                inDegree[item]--;
                // 已经无依赖，添加到队列
                if (0 == inDegree[item]) {
                    queue.add(item);
                }
            }
        }

        // 所有节点都被遍历到了，说明没有环
        return count == numCourses;
    }


    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[i]中是依赖i的所有课程
        for (int[] current : prerequisites) {
            // from为被依赖的点
            int from = current[1];
            int to = current[0];
            graph[from].add(to);
        }
        return graph;
    }

}
