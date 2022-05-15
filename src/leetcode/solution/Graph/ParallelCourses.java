package leetcode.solution.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1136. Parallel Courses
 */
public class ParallelCourses {

    public static void main(String[] args) {
        int n = 3;
        int[][] relations = {{1, 3}, {2, 3}};

        ParallelCourses parallelCourses = new ParallelCourses();
        int ans = parallelCourses.minimumSemesters(n, relations);
        System.out.println(ans);
        // 2
    }

    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> table = build(n, relations);


        Queue<Integer> queue = new LinkedList<>();


        return 1;
    }


    private List<List<Integer>> build(int n, int[][] relations) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            ans.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            ans.get(relation[0]).add(relation[1]);
        }

        return ans;
    }
}
