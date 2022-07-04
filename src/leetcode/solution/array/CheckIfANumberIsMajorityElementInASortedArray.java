package leetcode.solution.array;

import java.util.List;

/**
 * 1150. Check If a Number Is Majority Element in a Sorted Array
 */
public class CheckIfANumberIsMajorityElementInASortedArray {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        MajorityElementIISortSolution solution = new MajorityElementIISortSolution();
        List<Integer> ans = solution.majorityElement(nums);
        System.out.println(ans);

        MajorityElementIIBoyerMooreVotingAlgorithmSolution solution1 = new MajorityElementIIBoyerMooreVotingAlgorithmSolution();
        ans = solution1.majorityElement(nums);
        System.out.println(ans);
    }

    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;

        for (int num : nums) {
            if (num == target) {
                count++;
            } else {
                count--;
            }
        }

        return count > 0;
    }

}
