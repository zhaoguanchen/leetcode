package leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 */
public class SummaryRanges {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        SummaryRanges summaryRanges = new SummaryRanges();
        List<String> ans = summaryRanges.summaryRanges(nums);
        System.out.println(ans);
        //["0->2","4->5","7"]
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n - 1 && nums[j] + 1 == nums[j + 1]) {
                j++;
            }

            if (i == j) {
                ans.add(String.valueOf(nums[i]));
            } else {
                ans.add(nums[i] + "->" + nums[j]);
            }

            i = j + 1;
        }

        return ans;
    }
}
