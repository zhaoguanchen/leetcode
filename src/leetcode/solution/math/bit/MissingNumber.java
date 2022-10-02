package leetcode.solution.math.bit;

/**
 * 268. Missing Number
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] s = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        MissingNumber number = new MissingNumber();
        System.out.println(number.missingNumber(s));
        // 8
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        ans = ans ^ n;
        for (int i = 0; i < n; i++) {
            ans = ans ^ i ^ nums[i];
        }

        return ans;
    }
}
