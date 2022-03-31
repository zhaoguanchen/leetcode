package leetcode.solution.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
 */
public class MergeIntervals {


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] ans = mergeIntervals.merge(intervals);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int[] base = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] <= base[1]) {
                base[1] = Math.max(cur[1], base[1]);
            } else {
                ans.add(base);
                base = cur;
            }
        }
        ans.add(base);

        int[][] res = new int[ans.size()][2];

        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;

    }
}
