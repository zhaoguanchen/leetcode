package leetcode.solution.DataStruct;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 895. Maximum Frequency Stack
 */
public class MaximumFrequencyStack {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.print();
        freqStack.push(7); // The stack is [5,7]
        freqStack.print();
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.print();
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.print();
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.print();
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        freqStack.print();
        int a1 = freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].

        freqStack.print();
        System.out.println(a1);
        int a2 = freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println(a2);
        int a3 = freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println(a3);
        int a4 = freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
        System.out.println(a4);

    }
}


class FreqStack {

    /**
     * 元素对应的频率
     */
    private Map<Integer, Integer> val2Freq;

    /**
     * 频率对应的元素栈，满足同一频率下pop最近的
     */
    private Map<Integer, Stack<Integer>> freq2Stack;

    /**
     * 当前最大频率
     */
    private Integer maxFreq;

    /**
     * 构造函数初始化
     */
    public FreqStack() {
        freq2Stack = new HashMap<>();
        maxFreq = 0;
        val2Freq = new HashMap<>();
    }

    /**
     * 添加元素
     *
     * @param val
     */
    public void push(int val) {
        int freq;
        // 元素已存在，则1.更新频率；2.在更新后频率对应的栈中添加该元素
        if (val2Freq.containsKey(val)) {
            freq = val2Freq.get(val);
            freq = freq + 1;
            val2Freq.put(val, freq);
            addToStack(freq, val);
        } else { // 新元素，添加元素，频率为1的栈中添加该元素
            freq = 1;
            val2Freq.put(val, freq);
            addToStack(1, val);
        }

        // 更新最大频率
        if (freq > maxFreq) {
            maxFreq = freq;
        }

    }


    /**
     * 添加到对应freq的栈
     *
     * @param freq
     * @param val
     */
    private void addToStack(int freq, int val) {
        // 没有则新建stack
        Stack<Integer> stack = freq2Stack.getOrDefault(freq, new Stack<>());
        stack.push(val);
        // put以更新
        freq2Stack.put(freq, stack);
    }

    public int pop() {
        int freq = maxFreq;

        Stack<Integer> stack = freq2Stack.get(freq);
        if (stack == null) {
            return -1;
        }
        // 找到对应栈中的最顶元素
        Integer ans = stack.pop();
        // 栈为空，则该频率失效，更新最大频率值，移除stack
        if (stack.isEmpty()) {
            maxFreq--;
            freq2Stack.remove(freq);
        }

        // 更新元素对应频率，如频率为0，直接移除
        int newFreq = freq - 1;
        if (newFreq > 0) {
            val2Freq.put(ans, newFreq);
        } else {
            val2Freq.remove(ans);
        }

        return ans;
    }

    /**
     * 打印栈情况，测试用
     */
    public void print() {
        System.out.println(maxFreq);
        System.out.println(freq2Stack);
        System.out.println(val2Freq);
    }
}
