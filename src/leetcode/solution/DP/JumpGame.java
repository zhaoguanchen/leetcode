package leetcode.solution.DP;

import java.util.Arrays;

/**
 * 55. Jump Game
 * <p>
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 */

enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpGame {

//    rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
        System.out.println(canJump1(nums));
    }

    static Index[] memo;

    public static boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public static boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    public static boolean canJump1(int[] nums) {
        int last = nums.length - 1;
        for (int i = last - 1; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }

        }
        return last == 0;
    }

}