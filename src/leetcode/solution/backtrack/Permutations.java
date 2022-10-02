package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> ans = permutations.permute(nums);
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

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(path);

        return ans;
    }


    private void backtrack(List<Integer> path) {
        // all element are involved. we get the answer.
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // iterate all the candidates
        for (int num : nums) {
            // this element is considered before
            if (path.contains(num)) {
                continue;
            }
            // do the choice
            path.add(num);
            // do the backtracking
            backtrack(path);
            // revoke the choice
            path.remove(path.size() - 1);
        }
    }


}