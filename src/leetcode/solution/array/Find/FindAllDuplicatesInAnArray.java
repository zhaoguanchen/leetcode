package leetcode.solution.array.Find;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 */
public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindAllDuplicatesInAnArray find = new FindAllDuplicatesInAnArray();
        System.out.println(find.findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            int index = value == n ? 0 : value;
            if (nums[index] < 0) {
                if (index == 0) {
                    ans.add(n);
                } else {
                    ans.add(value);
                }
            } else {
                nums[index] = -nums[index];
            }

        }

        return ans;
    }

}
