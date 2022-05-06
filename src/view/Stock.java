package view;

import java.util.HashSet;
import java.util.Set;

public class Stock {


    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 7, 4, 3, 6};
        int k = 3;
        Stock s = new Stock();
        int ans = s.getMaxSum(arr, k);
        System.out.println(ans);
//        14
    }


    /**
     * @Description: stastic
     * @Author: Guanchen Zhao
     * @Date: 2022/5/5
     */
    public int getMaxSum(int[] arr, int k) {
        int max = 0;

        Set<Integer> memo = new HashSet<>();

        int left = 0;
        int right = 0;
        memo.add(arr[right]);

        while (true) {
            if (right - left + 1 < k) {
                right++;
                if (right == arr.length) {
                    break;
                }

                if (memo.contains(arr[right])) {
                    while (arr[left] != arr[right]) {
                        memo.remove(arr[left]);
                        left++;
                    }
                    memo.remove(arr[left]);
                    left++;
                }
                memo.add(arr[right]);

            } else {
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += arr[i];
                }

                max = Math.max(max, sum);
                memo.remove(arr[left]);
                left++;
            }

            System.out.println(memo);
            System.out.println(max);
        }
        return max;

    }


}
