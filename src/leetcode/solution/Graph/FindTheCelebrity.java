package leetcode.solution.Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 277. Find the Celebrity
 */
public class FindTheCelebrity {

    public static void main(String[] args) {
        int n = 3;
        FindTheCelebritySolution solution = new FindTheCelebritySolution();
        int ans = solution.findCelebrity(n);
        System.out.println(ans);
    }


}


class FindTheCelebritySolution extends Relation {

    private Map<String, Boolean> memo;

    private int numberOfPeople;

    public int findCelebrity(int n) {
        memo = new HashMap<>();
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (checkKnows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }


    private boolean checkKnows(int i, int j) {
        String key = i + "-" + j;
        boolean ans;
        if (memo.containsKey(key)) {
            ans = memo.get(key);
        } else {
            ans = knows(i, j);
            memo.put(key, ans);
        }
        return ans;

    }

    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) {
                continue; // Don't ask if they know themselves.
            }

            // i know other or i was not knew by some people
            if (checkKnows(i, j) || !checkKnows(j, i)) {
                return false;
            }
        }
        return true;
    }
}

class Relation {


    int[][] array = new int[][]{{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};

    boolean knows(int a, int b) {
        for (int[] ints : array) {
            if (ints[0] == a && ints[1] == b) {
                return ints[2] == 1;
            }
        }

        return false;
    }
}