package leetcode.solution.other;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 */
public class KthLargestElementInAStream {


    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);
        int a1 = kthLargest.add(3);   // return 4
        int a2 = kthLargest.add(5);   // return 5
        int a3 = kthLargest.add(10);  // return 5
        int a4 = kthLargest.add(9);   // return 8
        int a5 = kthLargest.add(4);   // return 8
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);

        // -1
    }

}

class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        this.k = k;

        for (int val : nums) {
            priorityQueue.add(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
    }

    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
