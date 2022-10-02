package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. Subsets II
 */
public class SubSetII {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        SubSetII subSetII = new SubSetII();
        List<List<Integer>> ans = subSetII.subsetsWithDup(nums);
        System.out.println(ans);
    }

    /**
     * global variable - candidates
     */
    private int[] nums;

    /**
     * global variable - result list
     */
    private List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(0, path);
        return ans;
    }

    private void backtrack(int index, LinkedList<Integer> path) {
        ans.add(new ArrayList<>(path));

        // no need to check index out of array, the for loop will do it

        for (int i = index; i < nums.length; i++) {
            // ignore the same value, because this condition was considered before
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtrack(i + 1, path);
            path.removeLast();
        }


    }

}
