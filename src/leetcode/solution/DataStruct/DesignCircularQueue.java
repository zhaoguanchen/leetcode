package leetcode.solution.DataStruct;

/**
 * 622. Design Circular Queue
 */
public class DesignCircularQueue {

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        int ans = myCircularQueue.Rear();     // return 4
        System.out.println(ans);
    }
}

class MyCircularQueue {

    private int[] a;
    private int head;

    private int count;

    private int cap;

    public MyCircularQueue(int k) {
        this.a = new int[k];
        this.head = 0;
        this.count = 0;
        this.cap = k;
    }

    public boolean enQueue(int value) {
        if (count == cap) {
            return false;
        }

        int index = (head + count) % cap;
        a[index] = value;
        count++;

        return true;

    }

    public boolean deQueue() {
        if (count == 0) {
            return false;
        }
        head = (head + 1) % cap;
        count--;
        return true;

    }

    public int Front() {
        if (count == 0) {
            return -1;
        }
        return a[head];
    }

    public int Rear() {
        if (count == 0) {
            return -1;
        }
        int index = (head + count - 1) % cap;

        return a[index];

    }

    public boolean isEmpty() {
        return count == 0;

    }

    public boolean isFull() {
        return count == cap;

    }
}

