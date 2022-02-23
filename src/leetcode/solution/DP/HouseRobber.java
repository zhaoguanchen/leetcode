package leetcode.solution.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 198. House Robber
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

//    rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob0(nums));
        System.out.println(rob1(nums));
        System.out.println(rob2(nums));
        System.out.println(rob3(nums));
        System.out.println(rob4(nums));
        System.out.println(rob(nums));
    }

    /**
     * recursive
     *
     * @param nums
     * @return
     */
    public static int rob0(int[] nums) {
        int n = nums.length - 1;
        return helper(nums, n);
    }

    public static int helper(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(nums[i] + helper(nums, i - 2), helper(nums, i - 1));
    }

    /**
     * add memorize - using array
     */
    static int[] arr;

    public static int rob1(int[] nums) {
        int n = nums.length - 1;
        arr = new int[n + 1];
        // because test case contains zero
        Arrays.fill(arr, -1);
        return helper1(nums, n);
    }

    public static int helper1(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (arr[i] >= 0) {
            return arr[i];
        }
        arr[i] = Math.max(nums[i] + helper1(nums, i - 2), helper1(nums, i - 1));

        return arr[i];
    }

    private static final Map<Integer, Integer> map = new HashMap<>();


    /**
     * add memorize - using map
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        int n = nums.length - 1;
        return helper2(nums, n);
    }

    public static int helper2(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (map.containsKey(i)) {
            return map.get(i);
        }
        map.put(i, Math.max(nums[i] + helper2(nums, i - 2), helper2(nums, i - 1)));

        return map.get(i);
    }


    /**
     * from bottom to top
     *
     * @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        int n = nums.length - 1;
        int[] array = new int[n + 1];

        if (n == 0) {
            return nums[0];
        }

        array[0] = nums[0];
        array[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i <= n; i++) {
            array[i] = Math.max(nums[i] + array[i - 2], array[i - 1]);
        }

        return array[n];
    }

    /**
     * using var
     *
     * @param nums
     * @return
     */
    public static int rob4(int[] nums) {
        int n = nums.length - 1;
        if (n == 0) {
            return nums[0];
        }

        int pre = nums[0];
        int pro = Math.max(nums[0], nums[1]);
        int cur = pro;

        for (int i = 2; i <= n; i++) {
            cur = Math.max(nums[i] + pre, pro);
            pre = pro;
            pro = cur;
        }

        return cur;
    }


    public static int rob(int[] nums) {
        int n = nums.length;
        int even = 0;
        int odd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even += nums[i];
                even = Math.max(even, odd);
            } else {
                odd += nums[i];
                odd = Math.max(even, odd);
            }
        }
        return Math.max(even, odd);

    }

}