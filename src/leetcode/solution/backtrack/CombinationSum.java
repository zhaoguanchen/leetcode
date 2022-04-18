package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> ans = combinationSum.combinationSum(candidates, target);
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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.nums = candidates;
        this.target = target;
        this.ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(0, 0, path);

        return ans;
    }


    private void backtrack(int index, int sum, List<Integer> path) {
        // get the answer
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // sum exceed, no need to continue backtracking
        if (sum > target) {
            return;
        }

        // start iteration from start index, every value can be selected
        for (int i = index; i < nums.length; i++) {
            // do the choice
            path.add(nums[i]);
            sum += nums[i];
            // backtracking. no need to do i+1, because the same number may be chosen from candidates an unlimited number of times.
            backtrack(i, sum, path);
            // revoke the choice
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }


}