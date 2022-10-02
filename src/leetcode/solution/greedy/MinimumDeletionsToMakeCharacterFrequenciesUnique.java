package leetcode.solution.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {


    public static void main(String[] args) {
        String s = "aaabbbcc";
        MinimumDeletionsToMakeCharacterFrequenciesUnique solution = new MinimumDeletionsToMakeCharacterFrequenciesUnique();
        int ans = solution.minDeletions(s);
        System.out.println(ans);
        // 2
    }


    public int minDeletions(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }

        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0 && seen.contains(count[i])) {
                count[i]--;
                ans++;
            }

            seen.add(count[i]);
        }

        return ans;

    }
}