package leetcode.solution.array.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        List<int[]> list = new ArrayList<>();

        Comparator<int[]> comparator = (a, b) -> {
            return a[0] - b[0];
        };

        Arrays.sort(intervals, comparator);

        int[] base = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            // can not merge
            if (base[1] < interval[0]) {
                list.add(base);
                base = interval;
            } else {
                base[1] = Math.max(base[1], interval[1]);
            }
        }

        // remember to add the last base interval.
        list.add(base);

        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }
}
