package solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 */
public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generate(2));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> fund = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            if (i != 1) {
                for (int j = 1; j < i - 1; j++) {
                    int value = fund.get(j - 1) + fund.get(j);
                    cur.add(value);
                }

                cur.add(1);
            }
            res.add(cur);
            fund = cur;
        }

        return res;
    }


}
