package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
public class Permutations {

    public static void main(String[] args) {
        int[] candidates = new int[]{1, 2, 3};

        System.out.println(permute(candidates));
    }


    // 结果集合
    private static final List<List<Integer>> result = new ArrayList<>();

    private static int[] candidateValue;

    public static List<List<Integer>> permute(int[] nums) {
        candidateValue = nums;
        backtrack(new ArrayList<>());

        return result;


    }

    private static void backtrack(List<Integer> path) {
        // 结束条件：长度相等
        if (path.size() == candidateValue.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < candidateValue.length; i++) {
            int currentValue = candidateValue[i];
            // 排除已存在的元素
            if (path.contains(currentValue)) {
                continue;
            }

            // 选择
            path.add(currentValue);
            // 回溯，考虑所有候选项
            backtrack(path);
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }


}