package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. Combination Sum III
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        List<List<Integer>> ans = combinationSumIII.combinationSum3(k, n);
        System.out.println(ans);
        // [[1,2,6],[1,3,5],[2,3,4]]
    }


    List<List<Integer>> ans;
    int k;
    int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.ans = new ArrayList<>();
        this.k = k;
        this.n = n;

        // Use LinkedList as the path.
        // Provides convenience for deleting elements at the end of the list,
        // while avoiding the expansion and contraction of the list.
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(1, 0, path);

        return ans;
    }


    private void backtrack(int start, int sum, LinkedList<Integer> path) {
        // base case
        if (path.size() == k) {
            if (sum == n) {
                // remember to copy the list.
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        // corner case
        if (sum > n) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            path.add(i);
            sum += i;
            backtrack(i + 1, sum, path);
            sum -= i;
            path.removeLast();
        }
    }
}