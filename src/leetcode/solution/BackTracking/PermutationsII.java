package leetcode.solution.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 */
public class PermutationsII {

    public static void main(String[] args) {
        int[] candidates = new int[]{1, 1, 2};

        System.out.println(permuteUnique(candidates));
    }


    // 结果集合
    private static final List<List<Integer>> result = new ArrayList<>();

    private static int[] candidateValue;


    public static List<List<Integer>> permuteUnique(int[] nums) {
        candidateValue = nums;
        Arrays.sort(candidateValue);
        boolean[] used = new boolean[nums.length];
        backtrack(new ArrayList<>(), used);
        return result;
    }

    private static void backtrack(List<Integer> path, boolean[] used) {
        if (path.size() == candidateValue.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < candidateValue.length; i++) {
            if (used[i]) {
                continue;
            }
            // 从第二个元素开始，出现相同元素，且前一元素在本次递归过程中未被选中，则跳过。因为i=i-1时已完成选择。
            if (i > 0 && candidateValue[i - 1] == candidateValue[i] && !used[i - 1]) {
                continue;
            }
            int currentValue = candidateValue[i];

            //  选择
            used[i] = true;
            path.add(currentValue);
            backtrack(path, used);
            // 撤销选择
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


}