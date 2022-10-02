package leetcode.solution.array.Find;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindAllNumbersDisappearedInAnArray find = new FindAllNumbersDisappearedInAnArray();
        System.out.println(find.findDisappearedNumbers(nums));
        // 5,6
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            // n对应0，防止越界
            if (value == n) {
                nums[0] = -Math.abs(nums[0]);
                continue;
            }
            // 第一次遇到，变为负数
            nums[value] = -Math.abs(nums[value]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 下标对应的值，为负数的则为出现过的，正数则未出现
            if (nums[i] > 0) {
                if (i == 0) {
                    ans.add(n);
                } else {
                    ans.add(i);
                }
            }
        }

        return ans;
    }

}
