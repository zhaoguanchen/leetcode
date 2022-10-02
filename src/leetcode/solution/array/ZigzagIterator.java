package leetcode.solution.array;

import java.util.Arrays;
import java.util.List;

/**
 * 281. Zigzag Iterator
 */
public class ZigzagIterator {


    public static void main(String[] args) {
        Integer[] a1 = {1, 2};
        Integer[] a2 = {3, 4, 5, 6};
        List<Integer> v1 = Arrays.asList(a1);
        List<Integer> v2 = Arrays.asList(a2);
        ZigzagIteratorSolution solution = new ZigzagIteratorSolution(v1, v2);
        Integer[] f = new Integer[v1.size() + v2.size()];

        int i = 0;
        while (solution.hasNext()) {
            f[i++] = solution.next();
        }
        System.out.println(Arrays.toString(f));
    }
}


/**
 * @Description: Using two Pointer.
 * <p>
 * Follow up: k list.
 * 1. use array to save several pointer.
 * 2. use queue.
 * @Author: Guanchen Zhao
 * @Date: 2022/5/7
 */
class ZigzagIteratorSolution {

    /**
     * the index of v1, a pointer.
     */
    private int index1;
    /**
     * the index of v2, a pointer.
     */
    private int index2;

    /**
     * the current pointer, v1 or v2
     */
    private int point;

    List<Integer> v1;
    List<Integer> v2;

    public ZigzagIteratorSolution(List<Integer> v1, List<Integer> v2) {
        index1 = 0;
        index2 = 0;
        this.v1 = v1;
        this.v2 = v2;

        // initially, point to v1
        if (v1.isEmpty()) {
            point = 2;
        } else {
            point = 1;
        }
    }

    /**
     * check the value of point. then move point to another list.
     * if next value of another list is null, do not move.
     *
     * @return
     */
    public int next() {
        int ans;
        if (point == 1) {
            ans = v1.get(index1);
            index1++;
            if (index2 < v2.size()) {
                point = 2;
            }
        } else {
            ans = v2.get(index2);
            index2++;
            if (index1 < v1.size()) {
                point = 1;
            }
        }

        return ans;
    }

    /**
     * check the index.
     *
     * @return
     */
    public boolean hasNext() {
        if (point == 1) {
            return index1 < v1.size();
        } else {
            return index2 < v2.size();
        }
    }
}
