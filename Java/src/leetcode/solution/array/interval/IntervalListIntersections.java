package leetcode.solution.array.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 986. Interval List Intersections
 */
public class IntervalListIntersections {


    public static void main(String[] args) {
        int[][] firstList = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] secondList = {{1, 2}, {4, 5}, {8, 10}, {15, 18}};

        IntervalListIntersections mergeIntervals = new IntervalListIntersections();
        int[][] ans = mergeIntervals.intervalIntersection(firstList, secondList);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < firstList.length && p2 < secondList.length) {
            int[] a = firstList[p1];
            int[] b = secondList[p2];
            // no intersect
            if (a[1] < b[0] || a[0] > b[1]) {
                if (a[1] < b[0]) {
                    p1++;
                } else {
                    p2++;
                }
            } else {
                int start = Math.max(a[0], b[0]);
                int end = Math.min(a[1], b[1]);
                list.add(new int[]{start, end});
                if (a[1] < b[1]) {
                    p1++;
                } else {
                    p2++;
                }

            }

        }

        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
