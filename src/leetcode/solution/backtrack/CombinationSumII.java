package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = new int[]{4, 1, 1, 4, 4, 4, 4, 2, 3, 5};
        int target = 10;
        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> ans = combinationSumII.combinationSum2(candidates, target);
        System.out.println(ans);
    }

    /**
     * global variable - candidates
     */
    private int[] nums;

    /**
     * global variable - target
     */
    private int target;

    /**
     * global variable - result list
     */
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // sort from smallest to largest
        Arrays.sort(candidates);
        this.nums = candidates;
        this.target = target;
        this.ans = new ArrayList<>();
        // the path of choice
        List<Integer> path = new ArrayList<>();
        // do the backtracking
        backtrack(0, 0, path);

        return ans;
    }

    /**
     * backtracking method
     *
     * @param start
     * @param sum
     * @param path
     */
    private void backtrack(int start, int sum, List<Integer> path) {
        // get the answer
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // sum exceed, no need to continue backtracking
        if (sum > target) {
            return;
        }

        // start iteration from start index
        for (int i = start; i < nums.length; i++) {
            // ignore the same value, because the nums contains duplicate values.
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }

            // do the choice
            path.add(nums[i]);
            sum += nums[i];
            // backtracking
            backtrack(i + 1, sum, path);
            // revoke the choice
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }


}