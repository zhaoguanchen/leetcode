package leetcode.solution.DataStruct;

import java.util.Arrays;
import java.util.Stack;

/**
 * 155. Min Stack
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.print();
        minStack.push(0);
        minStack.print();
        minStack.push(-1);
        minStack.print();
        int ans1 = minStack.getMin(); // return -3
        minStack.print();
        int ans2 = minStack.top();    // return 0
        minStack.print();
        minStack.pop();
//
        int ans3 = minStack.getMin(); // return -2

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);

    }

    Stack<int[]> minStack;
    Stack<Integer> mainStack;

    public MinStack() {
        minStack = new Stack<>();
        mainStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);

        if (minStack.isEmpty() || val < minStack.peek()[0]) {
            minStack.push(new int[]{val, 1});
        } else if (val >= minStack.peek()[0]) {
            minStack.peek()[1]++;
        }

    }

    public void pop() {
        mainStack.pop();

        if (minStack.peek()[1] > 0) {
            minStack.peek()[1]--;
        }

        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }

    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }


    public void print() {
        System.out.println(Arrays.toString(minStack.peek()));
        System.out.println(mainStack);

    }
}



