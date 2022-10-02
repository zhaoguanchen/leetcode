package leetcode.solution.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 */
public class HappyNumber {

    public static void main(String[] args) {
        int s = 19;
        HappyNumberSetSolution setSolution = new HappyNumberSetSolution();
        System.out.println(setSolution.isHappy(s));

    }


}

/**
 * @Description: HashSet
 * @Author: Guanchen Zhao
 * @Date: 2022/6/27
 */
class HappyNumberSetSolution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);
            n = get(n);
        }

        return true;
    }

    private int get(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }

        return sum;
    }
}

/**
 * @Description: fast and slow pointer
 * @Author: Guanchen Zhao
 * @Date: 2022/6/27
 */
class HappyNumberCycleSolution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num * num;
            n /= 10;
        }

        return sum;
    }
}