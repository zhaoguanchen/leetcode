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

        int ans = 1;
        for (int num : nums) {
            // is the start point
            if (!set.contains(num - 1)) {
                int currentLongest = 1;
                int currentNum = num;
                // check if the next number is exist.
                // if so, record the length of Consecutive Sequence
                while (set.contains(currentNum + 1)) {
                    currentLongest++;
                    currentNum++;
                }

                ans = Math.max(ans, currentLongest);
            }
        }

        return ans;
    }
}
