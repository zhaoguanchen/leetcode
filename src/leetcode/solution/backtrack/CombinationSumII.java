package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum 2
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * <p>
 * Each number in candidates may only be used once in the combination.
 * <p>
 * Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = new int[]{4, 1, 1, 4, 4, 4, 4, 2, 3, 5};
        int nums = 10;
        System.out.println(combinationSum(candidates, nums));
    }

    private static int targetValue;

    // 结果集合
    private static final List<List<Integer>> result = new ArrayList<>();

    private static int[] candidateValue;


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        targetValue = target;
        candidateValue = candidates;
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
            if (i > start && currentValue == candidateValue[i - 1]) {
                continue;
            }

            // 选择
            path.add(currentValue);
            sum += currentValue;
            // 回溯，仅需要考虑当前位及以后位，若考虑之前位会造成重复。
            backtrack(path, sum, i + 1);
            // 撤销选择
            path.remove(path.size() - 1);
            sum -= currentValue;
        }
    }


}