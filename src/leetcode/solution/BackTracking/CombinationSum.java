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
        if (sum == targetValue) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > targetValue) {
            return;
        }

        for (int i = start; i < candidateValue.length; i++) {
            int currentValue = candidateValue[i];
            path.add(currentValue);
            sum += currentValue;
            backtrack(path, sum, i);
            path.remove(path.size() - 1);
            sum -= currentValue;
        }
    }

 
}