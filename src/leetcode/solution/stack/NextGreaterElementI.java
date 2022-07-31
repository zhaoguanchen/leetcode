package leetcode.solution.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. Next Greater Element I
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        NextGreaterElementI nextGreaterElementI = new NextGreaterElementI();
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 2, 4};
        int[] res = nextGreaterElementI.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        // 对nums2进行遍历
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            // 将当前元素加入栈
            stack.push(num);
        }

        // 结果赋值
        for (int i = 0; i < nums1.length; i++) {
            // 如map中不存在，表明后面不存在比该元素大的值，应设为-1.
            int target = map.getOrDefault(nums1[i], -1);
            ans[i] = target;
        }

        return ans;
    }


}
