package leetcode.solution.nSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 */
public class FourSum {


    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        FourSum calculator = new FourSum();
        List<List<Integer>> ans = calculator.fourSum(nums, target);
        System.out.println(ans);
        // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        int[] nums1 = {2, 2, 2, 2, 2};
        int target1 = 8;
        List<List<Integer>> ans1 = calculator.fourSum(nums1, target1);
        System.out.println(ans1);
        // [[2,2,2,2]]
    }

    private int[] data;

    private List<List<Integer>> twoSum(int start, int end, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = start;
        int right = end;
        while (left < right) {
            int sum = data[left] + data[right];
            if (sum < target) {
                left++;
                while (left < right && data[left] == data[left - 1]) {
                    left++;
                }
            } else if (sum > target) {
                right--;
                while (left < right && data[right] == data[right + 1]) {
                    right--;
                }
            } else {
                List<Integer> subRes = Arrays.asList(data[left], data[right]);
                ans.add(subRes);
                left++;
                while (left < right && data[left] == data[left - 1]) {
                    left++;
                }
                right--;
                while (left < right && data[right] == data[right + 1]) {
                    right--;
                }
            }
        }

        return ans;
    }

    private List<List<Integer>> threeSum(int start, int end, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i != start && data[i] == data[i - 1]) {
                continue;
            }
            int cur = data[i];
            int subTarget = target - cur;

            List<List<Integer>> twoSum = twoSum(i + 1, end, subTarget);

            for (List<Integer> item : twoSum) {
                List<Integer> subRes = new ArrayList<>(item);
                subRes.add(cur);
                ans.add(subRes);
            }
        }

        return ans;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        data = nums;

        for (int i = 0; i < data.length; i++) {
            if (i != 0 && data[i] == data[i - 1]) {
                continue;
            }
            int cur = data[i];
            int subTarget = target - cur;

            List<List<Integer>> threeSum = threeSum(i + 1, data.length - 1, subTarget);

            for (List<Integer> item : threeSum) {
                List<Integer> subRes = new ArrayList<>(item);
                subRes.add(cur);
                ans.add(subRes);
            }
        }

        return ans;
    }
}
