package leetcode.solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int ans = subarraySumEqualsK.subarraySum(nums, k);
        System.out.println(ans);
    }


    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        // 存储前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        // 考虑前缀数组为空数组的情况
        map.put(sum, 1);
        for (int num : nums) {
            sum += num;
            int occurTime = map.getOrDefault(sum, 0);
            // 要寻找的数组和
            int targetSum = sum - k;
            // 存在几个target，就有几个满足条件的子数组
            if (map.containsKey(targetSum)) {
                ans += map.get(targetSum);
            }

            // 更新放在最后，避免当k为0时，targetSum计算到其本身
            map.put(sum, ++occurTime);
        }

        return ans;

    }

}
