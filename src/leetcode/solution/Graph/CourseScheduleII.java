package leetcode.solution.Graph;

import java.util.*;

/**
 * 210. Course Schedule II
 */
public class CourseScheduleII {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}};
        int numCourses = 2;
        CourseScheduleIIDFS cycleDetect = new CourseScheduleIIDFS();
        System.out.println(Arrays.toString(cycleDetect.findOrder(numCourses, prerequisites)));
        CourseScheduleIIBFS bfs = new CourseScheduleIIBFS();
        System.out.println(Arrays.toString(bfs.findOrder(numCourses, prerequisites)));
    }


}

/**
 * 环检测算法 DFS版本
 * 利用临接表
 * 类比回溯算法
 */
class CourseScheduleIIDFS {

    /**
     * 默认会初始化为false，因此无需赋值
     */
    private boolean[] visited;

    private boolean[] path;

    private boolean hasCycle;

    private List<Integer>[] graph;

    private List<Integer> postOrder;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        postOrder = new ArrayList<>();
        graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(i);
        }

        if (hasCycle) {
            return new int[]{};
        }
        // 翻转为拓扑顺序
        Collections.reverse(postOrder);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = postOrder.get(i);
        }
        return ans;


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
        // 若当前节点满足，遍历依赖当前节点的课程
        for (Integer nextCourseNum : graph[courseNumber]) {
            traverse(nextCourseNum);
        }
        // 后序遍历存储节点，最先add的为无依赖的课程，最后add的为被依赖最多的课程
        // 因此结果需要翻转
        postOrder.add(courseNumber);
        path[courseNumber] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        // from节点依赖的节点
        for (int[] current : prerequisites) {
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
class CourseScheduleIIBFS {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 入度表示被依赖  记录当前节点依赖的节点数量
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
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            int num = queue.poll();
            ans[count] = num;
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
        if (count == numCourses) {
            return ans;
        } else {
            return new int[]{};
        }
    }


    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] current : prerequisites) {
            int from = current[1];
            int to = current[0];
            graph[from].add(to);
        }
        return graph;
    }

}
