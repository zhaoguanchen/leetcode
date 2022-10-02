package leetcode.solution.array.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1272. Remove Interval
 */
public class RemoveInterval {


    public static void main(String[] args) {
        int[][] intervals = {{0, 2}, {3, 4}, {5, 7}};
        int[] toBeRemoved = {1, 6};
        RemoveInterval mergeIntervals = new RemoveInterval();
        List<List<Integer>> ans = mergeIntervals.removeInterval(intervals, toBeRemoved);
        System.out.println(ans);
        // [0,1],[6,7]
    }

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ans = new ArrayList<>();

        int start = toBeRemoved[0];
        int end = toBeRemoved[1];

        for (int[] interval : intervals) {
            if (interval[1] >= start && interval[0] <= end) {
                if (interval[0] < start) {
                    ans.add(Arrays.asList(interval[0], start));
                }
                if (interval[1] > end) {
                    ans.add(Arrays.asList(end, interval[1]));
                }
            } else {
                ans.add(Arrays.asList(interval[0], interval[1]));
            }

        }

        return ans;
    }
}
