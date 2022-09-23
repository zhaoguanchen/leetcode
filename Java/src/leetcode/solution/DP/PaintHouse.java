package leetcode.solution.DP;

/**
 * 256. Paint House
 */
public class PaintHouse {

    public static void main(String[] args) {
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        PaintHouse paintHouse = new PaintHouse();
        int ans = paintHouse.minCost(costs);
        System.out.println(ans);
        // 10
    }

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] previous = costs[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = costs[i];

            curr[0] += Math.min(previous[1], previous[2]);
            curr[1] += Math.min(previous[0], previous[2]);
            curr[2] += Math.min(previous[0], previous[1]);

            previous = curr;
        }

        return Math.min(previous[0], Math.min(previous[1], previous[2]));
    }

}
