package leetcode.solution.SlideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";

        LongestSubstringWithoutRepeatingCharacters f = new LongestSubstringWithoutRepeatingCharacters();
        int ans = f.lengthOfLongestSubstring(s);
        System.out.println(ans);
        //3
    }


    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        int right = 0;
        int left = 0;

        while (right < s.length()) {
            char toAdd = s.charAt(right);
            right++;

            int currentCount = map.getOrDefault(toAdd, 0);
            currentCount++;
            map.put(toAdd, currentCount);

            while (currentCount > 1) {
                char toRemove = s.charAt(left);
                left++;
                int existCount = map.get(toRemove);
                map.put(toRemove, existCount - 1);

                if (toRemove == toAdd) {
                    currentCount--;
                }
            }

            if (right - left > maxLength) {
                maxLength = right - left;
            }

        }
        return maxLength;


    }
}
