package leetcode.solution.other;

import java.util.HashMap;

/**
 * 位数相加相同的数字的和的最大值
 */
public class MaxSum {


    public static void main(String[] args) {
        MaxSum maxSum = new MaxSum();
        int[] arr = {51, 17, 71, 42};
        int ans = maxSum.solution(arr);
        System.out.println(ans);
    }


    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int j : A) {
            int current = digitSum(j);

            if (map.containsKey(current)) {
                int pre = map.get(current);
                if (j + pre > ans) {
                    ans = j + pre;
                }

                map.put(current, Math.max(j, pre));
            } else {
                map.put(current, j);
            }
        }
        return ans;

    }

    private int digitSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
}

