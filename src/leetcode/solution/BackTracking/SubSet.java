package leetcode.solution.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * <p>
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class SubSet {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
        System.out.println(subsetsBackTracking(nums));
    }


    /**
     * for loop
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
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
     * backtrack
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsBackTracking(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        backtrack(result, path, nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, int startOfSelect) {
        result.add(new ArrayList<>(path));
        // 选择范围
        for (int i = startOfSelect; i < nums.length; i++) {
            // 做选择，将当前节点添加至path
            path.add(nums[i]);
            // 递归，对子节点做选择
            backtrack(result, path, nums, i + 1);
            // 删除之前的选择，进行下一次
            path.remove(path.size() - 1);
        }
    }

}
