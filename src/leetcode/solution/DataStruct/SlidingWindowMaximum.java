package leetcode.solution.DataStruct;

import java.util.*;

/**
 * 239. Sliding Window Maximum
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum maximum = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maximum.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        SlidingWindow slidingWindow = new SlidingWindow();

        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 窗口未达到，仅添加
            if (i < k - 1) {
                slidingWindow.push(nums[i]);
            } else {
                // 开始滑动：添加右边元素，移除左边元素
                int left = nums[i - k + 1];
                slidingWindow.push(nums[i]);
                int ans = slidingWindow.getMax();
                slidingWindow.pop(left);
                ansList.add(ans);
            }
        }

        // 转换数据结构，返回结果
        int[] ansArray = new int[ansList.size()];
        for (int i = 0; i < ansArray.length; i++) {
            ansArray[i] = ansList.get(i);
        }

        return ansArray;
    }

}


class SlidingWindow {

    Deque<Integer> deque = new LinkedList<>();

    /**
     * 添加元素，踢掉左边比自己小的元素，加入自己。使栈由大到小单调递减
     *
     * @param x
     */
    public void push(int x) {
        // 移除所有比当前值小的元素
        while (!deque.isEmpty() && deque.getLast() < x) {
            deque.pollLast();
        }

        deque.addLast(x);
    }

    /**
     * 如果max为最开头的元素，移除
     *
     * @param x
     */
    public void pop(int x) {
        if (x == deque.getFirst()) {
            deque.pollFirst();
        }

    }

    /**
     * 最大元素为队列最左侧元素
     *
     * @return
     */
    public int getMax() {
        return deque.getFirst();
    }

}
