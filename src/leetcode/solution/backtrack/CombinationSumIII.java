package leetcode.solution.backtrack;

import java.util.ArrayList;
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


    private List<List<Integer>> ans;

    private int k;


    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        this.k = k;
        List<Integer> path = new ArrayList<>();
        backtrack(1, n, path);
        return ans;
    }

    private void backtrack(int startNum, int sum, List<Integer> path) {
        if (path.size() == k) {
            if (sum == 0) {
                ans.add(new ArrayList<>(path));
            }

            return;
        }

        if (startNum > sum) {
            return;
        }

        if (sum < 0) {
            return;
        }
        for (int i = startNum; i < 10; i++) {
            path.add(i);
            sum -= i;
            backtrack(i + 1, sum, path);
            path.remove(path.size() - 1);
            sum += i;
        }
    }

}