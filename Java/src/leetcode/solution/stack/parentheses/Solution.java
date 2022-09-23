package leetcode.solution.stack.parentheses;

import leetcode.solution.stack.DecodeString;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] tokens = {4, 2, 1, 3};
        int power = 2;
        System.out.println(Arrays.toString(solution.getGreatestElements(tokens, power)));
        tokens = new int[]{3, 2, 4, 5, 1};
        power = 4;
        System.out.println(Arrays.toString(solution.getGreatestElements(tokens, power)));
        tokens = new int[]{3, 1, 4, 5, 2};
        power = 2;
        System.out.println(Arrays.toString(solution.getGreatestElements(tokens, power)));
    }

    public int[] getGreatestElements(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        int target = 0;

        for (int i = 0; i < k - 1; i++) {
            minQ.add(arr[i]);
        }


        int[] ans = new int[n - k + 1];
        int index = 0;
        for (int i = k - 1; i < n; i++) {
            minQ.add(arr[i]);
            target = Math.max(target, minQ.poll());
            ans[index] = target;
            index++;
        }

        return ans;
    }


    public int getScore(int[] tokens, int power) {
        int score = 0;
        int n = tokens.length;

        int right = n - 1;
        for (int i = 0; i <= right; ) {
            int token = tokens[i];
            if (token <= power) {
                score++;
                power -= token;
                i++;
            } else {
                if (score > 0 && tokens[right] > token) {
                    score--;
                    power += tokens[right];
                    right--;
                } else {
                    break;
                }
            }
        }


        return score;
    }

}
