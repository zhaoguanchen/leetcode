package leetcode.solution.nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 总结  n sum
 */
public class nSum {


    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        nSum calculator = new nSum();
        List<List<Integer>> ans = calculator.sum(nums, target);
        System.out.println(ans);
        // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        int[] nums1 = {2, 2, 2, 2, 2};
        int target1 = 8;
        List<List<Integer>> ans1 = calculator.sum(nums1, target1);
        System.out.println(ans1);
        // [[2,2,2,2]]
    }

    public List<List<Integer>> sum(int[] nums, int target) {
        // 排序放在递归调用外层，避免每次都排序
        Arrays.sort(nums);
        return nSum(nums, 0, target, 4);
    }


    private List<List<Integer>> nSum(int[] nums, int start, int target, int k) {
        List<List<Integer>> ans = new ArrayList<>();


        // If we have run out of numbers to add, return res.
        if (start == nums.length) {
            return ans;
        }

        // There are k remaining values to add to the sum. The
        // average of these values is at least target / k.
        int average_value = target / k;

        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        if (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return ans;
        }

        // base 两数之和 双指针法
        if (k == 2) {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                int leftVal = nums[left];
                int rightVal = nums[right];
                int sum = leftVal + rightVal;
                if (sum < target) {
                    while (left < right && nums[left] == leftVal) {
                        left++;
                    }
                } else if (sum > target) {
                    while (left < right && nums[right] == rightVal) {
                        right--;
                    }
                } else {
                    List<Integer> subRes = Arrays.asList(nums[left], nums[right]);
                    ans.add(subRes);
                    while (left < right && nums[left] == leftVal) {
                        left++;
                    }
                    while (left < right && nums[right] == rightVal) {
                        right--;
                    }
                }
            }
            return ans;
        }


        for (int i = start; i < nums.length; i++) {
            // 去重
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }

            int cur = nums[i];
            int subTarget = target - cur;
            // 递归调用获得子序列
            List<List<Integer>> subSum = nSum(nums, i + 1, subTarget, k - 1);

            // 加上nums[i]组合结果
            for (List<Integer> item : subSum) {
                List<Integer> subRes = new ArrayList<>(item);
                subRes.add(cur);
                ans.add(subRes);
            }
        }

        return ans;

    }



}
