package leetcode.solution.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 8, 1};
        LastStoneWeight test = new LastStoneWeight();
        int ans = test.lastStoneWeight(nums);
        System.out.println(ans);
        // 1
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(stones.length, Comparator.reverseOrder());

        for (int stone : stones) {
            priorityQueue.add(stone);
        }

        while (priorityQueue.size() > 1) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            if (first != second) {
                priorityQueue.add(first - second);
            }
        }

        return priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
    }
}