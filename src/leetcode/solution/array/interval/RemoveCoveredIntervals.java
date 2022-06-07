package leetcode.solution.array.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1288. Remove Covered Intervals
 */
public class RemoveCoveredIntervals {


    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        RemoveCoveredIntervals mergeIntervals = new RemoveCoveredIntervals();
        int ans = mergeIntervals.removeCoveredIntervals(intervals);
        System.out.println(ans);
        // 2
    }

    public int removeCoveredIntervals(int[][] intervals) {

        Comparator<int[]> comparator = (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        };

        Arrays.sort(intervals, comparator);

        int[] base = new int[]{0, 0};
        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] > base[1]) {
                count++;
                base = interval;
            }

        }

        return count;
    }
}
