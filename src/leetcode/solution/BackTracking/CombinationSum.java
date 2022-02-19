package leetcode.solution.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int nums = 7;
        System.out.println(combinationSum(candidates, nums));
    }

    private static int targetValue;

    // 结果集合
    private static final List<List<Integer>> result = new ArrayList<>();

    private static int[] candidateValue;


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        targetValue = target;
        candidateValue = candidates;
        // 给定数组不一定有序
        Arrays.sort(candidateValue);
        backtrack(new ArrayList<>(), 0, 0);

        return result;

    }

    private static void backtrack(List<Integer> path, int sum, int start) {
        // 结束条件：找到和等于目标值的组合
        if (sum == targetValue) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 超出目标值
        if (sum > targetValue) {
            return;
        }

        for (int i = start; i < candidateValue.length; i++) {
            int currentValue = candidateValue[i];
            // 选择
            path.add(currentValue);
            sum += currentValue;
            // 回溯，仅需要考虑当前位及以后位，若考虑之前位会造成重复。
            backtrack(path, sum, i);
            // 撤销选择
            path.remove(path.size() - 1);
            sum -= currentValue;
        }
    }


}