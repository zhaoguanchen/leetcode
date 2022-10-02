package leetcode.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 229. Majority Element II
 */
public class MajorityElementII {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        MajorityElementIISortSolution solution = new MajorityElementIISortSolution();
        List<Integer> ans = solution.majorityElement(nums);
        System.out.println(ans);

        MajorityElementIIBoyerMooreVotingAlgorithmSolution solution1 = new MajorityElementIIBoyerMooreVotingAlgorithmSolution();
        ans = solution1.majorityElement(nums);
        System.out.println(ans);
    }


}

/**
 * @Description: Sort
 * @Author: Guanchen Zhao
 * @Date: 2022/7/4
 */
class MajorityElementIISortSolution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);

        int targetLength = nums.length / 3;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (i + targetLength > nums.length - 1) {
                break;
            }

            if (nums[i + targetLength] == nums[i]) {
                ans.add(nums[i]);
                i = i + targetLength;
            }
        }

        return ans;
    }
}

/**
 * @Description: Boyer-Moore Voting Algorithm
 * @Author: Guanchen Zhao
 * @Date: 2022/7/4
 */
class MajorityElementIIBoyerMooreVotingAlgorithmSolution {


    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null;
        Integer candidate2 = null;
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            }

            if (candidate2 != null && num == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }

        return ans;


    }
}