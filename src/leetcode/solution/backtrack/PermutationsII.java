package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. Permutations II
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
public class PermutationsII {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        PermutationsII permutationsII = new PermutationsII();
        List<List<Integer>> ans = permutationsII.permuteUnique(nums);
        System.out.println(ans);
    }

    /**
     * global variable - candidates
     */
    private int[] nums;

    /**
     * global variable - result list
     */
    List<List<Integer>> ans;

    /**
     * global variable - memo
     */
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new boolean[nums.length];
        this.ans = new ArrayList<>();
        // LinkedList is used because frequent add and delete operations are required
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(path);

        return ans;
    }


    private void backtrack(LinkedList<Integer> path) {
        // all element are involved. we get the answer.
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // iterate all the candidates
        for (int i = 0; i < nums.length; i++) {
            // this element is considered before
            if (used[i]) {
                continue;
            }

            // if the current value is as same as the previous value,
            // only the next one of the selected value at last level can be considered
            // this method could guarantee the relative order of same value
            if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // do the choice
            path.add(nums[i]);
            used[i] = true;
            // do the backtracking
            backtrack(path);
            // revoke the choice
            path.removeLast();
            used[i] = false;
        }
    }


}