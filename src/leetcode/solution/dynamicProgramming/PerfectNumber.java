package leetcode.solution.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 746. Min Cost Climbing Stairs
 * <p>
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 */
public class PerfectNumber {


    public static void main(String[] args) {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(perfectNumbers(10));

    }

    private static final Map<Integer, Integer> map = new HashMap<>();

    /**
     * recursive
     *
     * @param cost
     * @return
     */
    public static int perfectNumbers(int x) {

        int maxMn = 100;
        int maxAb = (int) Math.sqrt(x);

        System.out.println(maxAb);
        int count = 0;
        for (int m = 2; m <= maxMn; m++) {
            for (int n = 2; n <= maxMn; n++) {
                for (int a = 1; a <= maxAb; a++) {
                    for (int b = 1; b <= maxAb; b++) {
                        if (Math.pow(a , m) + Math.pow(b , n) <= n) {
                            count++;
                        }

                    }
                }
            }
        }



        return count;

    }


}