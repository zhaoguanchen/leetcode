package leetcode.solution.array.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class InsertInterval {


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        InsertInterval mergeIntervals = new InsertInterval();
        int[][] ans = mergeIntervals.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(ans));
        // [1,5], [6,9]
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // init data
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        List<int[]> res = new ArrayList<>();

        // add all intervals before newInterval
        while (idx < n && intervals[idx][1] < newStart) {
            res.add(intervals[idx++]);
        }
        // merge newInterval
        while (idx < n && intervals[idx][0] <= newEnd) {
            newStart = Math.min(newStart, intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            ++idx;
        }
        res.add(new int[]{newStart, newEnd});

        // add all intervals after newInterval
        while (idx < n) {
            res.add(intervals[idx++]);
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
