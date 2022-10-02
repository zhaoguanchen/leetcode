package leetcode.solution.SlideWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 */
public class FindAllAnagramsInString {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";

        FindAllAnagramsInString f = new FindAllAnagramsInString();
        List<Integer> ans = f.findAnagrams(s, p);
        System.out.println(ans);
        //[0,6]
    }


    public List<Integer> findAnagrams(String s, String p) {
        int[] sourceMap = new int[26];
        int[] targetMap = new int[26];

        for (int i = 0; i < p.length(); i++) {
            int index = getIndex(p.charAt(i));
            targetMap[index]++;
        }
        int targetMatchCount = 0;


        for (int i : targetMap) {
            if (i > 0) {
                targetMatchCount++;
            }
        }

        int right = 0;
        int left = 0;

        int matchCount = 0;

        List<Integer> ans = new ArrayList<>();

        while (right < s.length()) {
            char toAdd = s.charAt(right);
            right++;

            int targetCount = targetMap[getIndex(toAdd)];
            if (targetCount > 0) {
                sourceMap[getIndex(toAdd)]++;
                int sourceCount = sourceMap[getIndex(toAdd)];
                if (targetCount == sourceCount) {
                    matchCount++;
                }

            }

            if (right - left == p.length()) {
                if (matchCount == targetMatchCount) {
                    ans.add(left);
                }


                char toRemove = s.charAt(left);
                left++;
                int existCount = sourceMap[getIndex(toRemove)];
                if (existCount > 0) {
                    if (existCount == targetMap[getIndex(toRemove)]) {
                        matchCount--;
                    }
                    sourceMap[getIndex(toRemove)]--;
                }

            }
        }
        return ans;

    }

    private int getIndex(char c) {
        return c - 'a';
    }

}
