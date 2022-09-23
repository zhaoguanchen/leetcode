package leetcode.solution.stack.monotone;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures nextGreaterElementI = new DailyTemperatures();
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = nextGreaterElementI.dailyTemperatures(nums);
        System.out.println(Arrays.toString(res));
//        Input: temperatures = [73,74,75,71,69,72,76,73]
//        Output: [1,1,4,2,1,1,0,0]
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        // 结果数组
        int[] ans = new int[length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            // 栈不为空时，说明存在待求解的元素。当栈顶元素小于当前元素，则当前元素为第一个比栈顶元素大的值
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                // 弹出已求解元素，并赋值到结果数组
                int index = stack.pop();
                ans[index] = i - index;
            }
            // 当前元素入栈
            stack.push(i);
        }

        return ans;
    }
}
