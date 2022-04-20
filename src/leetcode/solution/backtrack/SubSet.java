package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. Subsets
 */
public class SubSet {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        SubSet subSet = new SubSet();
        List<List<Integer>> ans = subSet.subsets(nums);
        System.out.println(ans);
        ans = subSet.subsetsForLoop(nums);
        System.out.println(ans);
    }


    /**
     * for loop
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsForLoop(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 空集合
        result.add(new ArrayList<>());

        for (int i : nums) {
            // avoid ConcurrentModificationException
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> existList : result) {
                // 在原集合基础上 new 新集合
                List<Integer> newList = new ArrayList<>(existList);
                newList.add(i);
                temp.add(newList);
            }

            result.addAll(temp);
        }
        return result;
    }


    /**
     * global variable - candidates
     */
    private int[] nums;

    /**
     * global variable - result list
     */
    List<List<Integer>> ans;


    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.ans = new ArrayList<>();
        // LinkedList is used because frequent add and delete operations are required
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(0, path);

        return ans;
    }

    private void backtrack(int index, LinkedList<Integer> path) {
        // answers are generated every time, including the black List
        ans.add(new ArrayList<>(path));

        // no need to check index out of array, the for loop will do it

        // start iteration from start index, every value after the value at 'index' can be selected
        for (int i = index; i < nums.length; i++) {
            // do the choice
            path.add(nums[i]);
            // backtracking. we cannot select the same value, so do 'i + 1'
            backtrack(i + 1, path);
            // revoke the choice
            path.removeLast();
        }
    }

}
