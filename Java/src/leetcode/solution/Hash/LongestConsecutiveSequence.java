package leetcode.solution.Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 */
public class LongestConsecutiveSequence {


    public static void main(String[] args) {
        int[] s = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int ans = longestConsecutiveSequence.longestConsecutive(s);
        System.out.println(ans);
        // 4
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {
            if (!set.contains(num)) {
                continue;
            }

            int currentLength = 1;
            // search smaller element
            int pre = num - 1;
            while (set.contains(pre)) {
                set.remove(pre);
                currentLength++;
                pre--;
            }

            // search greater element
            int next = num + 1;
            while (set.contains(next)) {
                set.remove(next);
                currentLength++;
                next++;
            }

            max = Math.max(max, currentLength);
        }


        return max;
    }
}
