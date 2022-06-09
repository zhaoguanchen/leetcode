package leetcode.solution.array.nSum;

import java.util.*;

/**
 * 15. 3Sum
 */
public class ThreeSum {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum calculator = new ThreeSum();
        List<List<Integer>> ans = calculator.threeSum(nums);
        System.out.println(ans);
        // [-1,-1,2],[-1,0,1]
        List<List<Integer>> ans2 = calculator.threeSumNoSort(nums);
        System.out.println(ans2);

    }

    /**
     * 排序后双指针法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // 数字重复，直接跳过
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 在后面的序列中使用双指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else if (sum > 0) {
                    // 跳过重复元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else {
                    // 找到结果
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    // 跳过重复元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }

            }
        }

        return ans;

    }

    /**
     * Hash Table
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumNoSort(int[] nums) {
        // 结果set，方便去重
        Set<List<Integer>> res = new HashSet<>();
        // 记录在i循环下，某数是否出现过
        Map<Integer, Integer> memo = new HashMap<>();
        // 判断num[i]的值是否之前存在过，如果是，则处理结果必定重复
        Set<Integer> existed = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 当前值已处理过
            if (existed.contains(nums[i])) {
                continue;
            }
            existed.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                int temp = -nums[i] - nums[j];
                // 如果差值之前出现过，则可以组成结果对
                if (memo.containsKey(temp)) {
                    if (memo.get(temp) == i) {
                        List<Integer> tuple = Arrays.asList(nums[i], nums[j], temp);
                        // 排序以去重
                        tuple.sort(Comparator.comparingInt(value -> value));
                        res.add(tuple);
                    }
                }
                // 当前在i循环下，nums[j] 出现
                memo.put(nums[j], i);
            }
        }


        return new ArrayList<>(res);


    }
}
