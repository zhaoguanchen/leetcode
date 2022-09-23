package leetcode.solution.array;

/**
 * 303. Range Sum Query - Immutable
 */
public class RangeSumQuery {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int a = numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
        int b = numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
        int c = numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
        System.out.println(a + "  " + b + "  " + c);

    }


}


class NumArray {

    private int[] sumArray;

    public NumArray(int[] nums) {
        sumArray = new int[nums.length];
        // 计算前缀和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArray[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        // 处理当left = 0时，左边界越界的情况
        if (left == 0) {
            return sumArray[right];
        }
        return sumArray[right] - sumArray[left - 1];
    }
}
