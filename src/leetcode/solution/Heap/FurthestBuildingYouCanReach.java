package leetcode.solution.Heap;

import java.util.PriorityQueue;

/**
 * 1642. Furthest Building You Can Reach
 */
public class FurthestBuildingYouCanReach {


    public static void main(String[] args) {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        int bricks = 5;
        int ladders = 1;
        FurthestBuildingYouCanReach solution = new FurthestBuildingYouCanReach();
        int ans = solution.furthestBuilding(heights, bricks, ladders);
        System.out.println(ans);
        // 4
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < heights.length; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0) {
                continue;
            }

            priorityQueue.add(diff);

            // need bricks
            if (priorityQueue.size() > ladders) {
                int min = priorityQueue.poll();
                bricks -= min;
            }

            // materials are not enough
            if (bricks < 0) {
                return i;
            }

        }

        // reach the last point
        return heights.length - 1;

    }
}
