package leetcode.solution.DP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2369. Check if There is a Valid Partition For The Array
 */
public class CheckIfThereIsAValidPartitionForTheArray {


    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 4, 5, 6};
        CheckIfThereIsAValidPartitionForTheArray decodeWays = new CheckIfThereIsAValidPartitionForTheArray();
        boolean ans = decodeWays.validPartition(nums);
        System.out.println(ans);
    }

    boolean ans;

    Set<Integer> set;

    int[] nums;

    public boolean validPartition(int[] nums) {
        this.ans = false;
        this.set = new HashSet<>();
        this.nums = nums;

        dfs(0);

        return ans;
    }


    private void dfs(int index) {
        if (index == nums.length) {
            ans = true;
            return;
        }

        if (ans) {
            return;
        }

        if (set.contains(index)) {
            return;
        }

        set.add(index);

        if (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            dfs(index + 2);
        }

        if (index < nums.length - 2 && nums[index] == nums[index + 1] && nums[index] == nums[index + 2]) {
            dfs(index + 3);
        }

        if (index < nums.length - 2 && nums[index] + 1 == nums[index + 1] && nums[index] + 2 == nums[index + 2]) {
            dfs(index + 3);
        }
    }


}