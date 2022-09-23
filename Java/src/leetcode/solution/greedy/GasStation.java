package leetcode.solution.greedy;

/**
 * 134. Gas Station
 */
public class GasStation {


    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        GasStation solution = new GasStation();
        int ans = solution.canCompleteCircuit(gas, cost);
        System.out.println(ans);
        // 3
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        // it is impossible to finish the cycle.
        if (sum < 0) {
            return -1;
        }

        sum = 0;
        int start = 0;

        // from the start station, can not arrive the i + 1 station.
        // make i + 1 as the new start station.
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }

        if (start == n) {
            return 0;
        }

        return start;
    }
}