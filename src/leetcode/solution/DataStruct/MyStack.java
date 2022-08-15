package leetcode.solution.DataStruct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */
public class MyStack {

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 2, 3, 14};
        String s = "ListNode.constructList(array1)";
        MyStack myQueue = new MyStack();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(s);
//        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }

    public MyStack() {

    }

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int last = q1.poll();

        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }

        return last;
    }

    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int last = q1.poll();

        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }

        q1.add(last);
        return last;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

}
