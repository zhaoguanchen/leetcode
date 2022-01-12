package solution.stack;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }

    public MyQueue() {

    }

    Stack<Integer> s = new Stack<>();
    Stack<Integer> temp = new Stack<>();


    public void push(int x) {
        if (!s.isEmpty()) {
            while (!s.isEmpty()) {
                temp.push(s.pop());
            }

        }
        s.push(x);
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }

    }

    public int pop() {
        return s.pop();
    }

    public int peek() {
        return s.peek();
    }

    public boolean empty() {
        return s.isEmpty();
    }


}
