package leetcode.solution.array;

import java.util.Arrays;

/**
 * 169. Majority Element
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        MajorityElementSortSolution solution = new MajorityElementSortSolution();
        int ans = solution.majorityElement(nums);
        System.out.println(ans);

        MajorityElementBoyerMooreVotingAlgorithmSolution solution1 = new MajorityElementBoyerMooreVotingAlgorithmSolution();
        ans = solution1.majorityElement(nums);
        System.out.println(ans);
    }


}

/**
 * @Description: sort
 * @Author: Guanchen Zhao
 * @Date: 2022/7/4
 */
class MajorityElementSortSolution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}


/**
 * @Description: Boyer-Moore Voting Algorithm
 * @Author: Guanchen Zhao
 * @Date: 2022/7/4
 */
class MajorityElementBoyerMooreVotingAlgorithmSolution {


    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;

    }
}