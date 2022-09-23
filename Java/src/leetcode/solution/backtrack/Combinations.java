package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations
 */
public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations combinations = new Combinations();
        List<List<Integer>> ans = combinations.combine(n, k);
        System.out.println(ans);
        // [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
    }


    /**
     * global variable - result list
     */
    List<List<Integer>> ans;

    /**
     * global variable - parameter n
     */
    private int n;

    /**
     * global variable - parameter k
     */
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        this.ans = new ArrayList<>();
        // using LinkedList for the convenience of adding or removing value
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(1, path);
        return ans;
    }


    private void backtrack(int index, LinkedList<Integer> path) {
        // get the answer
        if (k == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // start iteration from start index, every value can be selected
        for (int i = index; i <= n; i++) {
            // do the choice
            path.add(i);
            // backtracking. 'i+1' because we can not select the previous value.
            backtrack(i + 1, path);
            // revoke the choice
            path.removeLast();
        }
    }


}