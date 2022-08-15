package leetcode.solution.stack.monotone;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II
 */
public class NextGreaterElementII {

    public static void main(String[] args) {
        NextGreaterElementII nextGreaterElementI = new NextGreaterElementII();
        int[] nums = {1, 2, 3, 4, 3};
        int[] res = nextGreaterElementI.nextGreaterElement(nums);
        System.out.println(Arrays.toString(res));
    }

    public int[] nextGreaterElement(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * length - 1; i++) {
            // 取模获取真实数组下标
            int current = i % length;
            while (!stack.isEmpty() && nums[current] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[current];
            }
            // 仅将第一次遍历的元素入栈，可以防止重复计算，以及停止遍历后，残留元素的取值模糊问题。
            if (i < length) {
                stack.push(current);
            }
        }
        // 遍历完毕后，栈中仍存在的元素即为“找不到更大元素”的值，置为-1.
        while (!stack.isEmpty()) {
            int index = stack.pop();
            ans[index] = -1;
        }

        return ans;
    }}
