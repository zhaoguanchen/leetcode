package leetcode.solution.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
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

    private int[] nums;

    private List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums.length == 0) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        backtrack(0, path);
        return ans;
    }

    private void backtrack(int index, List<Integer> path) {
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backtrack(i + 1, path);
            path.remove(path.size() - 1);
        }


    }

}
