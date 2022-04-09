package leetcode.solution.array.Find;

/**
 * 41. First Missing Positive
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        FirstMissingPositive find = new FirstMissingPositive();
        System.out.println(find.firstMissingPositive(nums));
        // 2
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int num : nums) {
            if (1 == num) {
                count++;
                break;
            }
        }

        if (count == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int targetIndex = Math.abs(nums[i]);
            if (targetIndex == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[targetIndex] = -Math.abs(nums[targetIndex]);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return n;
        }


        return 1 + n;
    }
}
