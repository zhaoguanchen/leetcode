package leetcode.solution.array;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
//        [1,3,12,0,0]
    }

    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        // 填充0
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }

    }

}
