package solution.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 997. Find the Town Judge
 * <p>
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
 * <p>
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */
public class FindTheTownJudge {

    public static void main(String[] args) {
        int n = 2;
        int[][] mat = {{1, 2}, {2, 1}};

        System.out.println(findJudge2(n, mat));
    }

    public static int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        if (n == 1 && trust.length == 0) {
            return n;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int[] item : trust) {
            int label = item[0];
            int trustedLabel = item[1];

            if (map.containsKey(label)) {
                int currentNum = map.get(label);
                map.put(label, currentNum - 1);
            } else {
                map.put(label, -1);
            }

            if (map.containsKey(trustedLabel)) {
                int currentNum = map.get(trustedLabel);
                map.put(trustedLabel, currentNum + 1);
            } else {
                map.put(trustedLabel, 1);
            }
        }


        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (n == value + 1) {
                return key;
            }

        }

        return -1;

    }


    public static int findJudge2(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }

        int[] flag = new int[n + 1];

        for (int[] item : trust) {
            int label = item[0];
            int trustedLabel = item[1];
            flag[label] = flag[label] - 1;
            flag[trustedLabel] = flag[trustedLabel] + 1;

        }


        for (int i = 1; i < flag.length; i++) {
            int value = flag[i];
            if (n == value + 1) {
                return i;
            }

        }

        return -1;

    }

}
