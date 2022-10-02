package leetcode.solution.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 */
public class LexicographicalNumbers {

    public static void main(String[] args) {
        int n = 13;
        LexicographicalNumbersSolution solution = new LexicographicalNumbersSolution();
        List<Integer> ans = solution.lexicalOrder(n);
        System.out.println(ans);
    }

}

class LexicographicalNumbersSolution {

    List<Integer> ans;

    int n;

    public List<Integer> lexicalOrder(int n) {
        ans = new ArrayList<>();
        this.n = n;
        create(0);
        return ans;
    }

    private void create(int base) {
        for (int i = 0; i < 10; i++) {
            int next = base + i;
            if (next > n) {
                break;
            }

            if (next == 0) {
                continue;
            }

            ans.add(next);
            create(next * 10);
        }

    }
}