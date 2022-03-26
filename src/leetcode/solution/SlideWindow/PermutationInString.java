package leetcode.solution.SlideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. Permutation in String
 */
public class PermutationInString {

    public static void main(String[] args) {
        String s = "ab", t = "eidboaoo";
        PermutationInString permutationInString = new PermutationInString();
        Boolean ans = permutationInString.checkInclusion(s, t);
        System.out.println(ans);
        // "BANC"
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // 存储s1元素及频率
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            Integer count = tMap.getOrDefault(c, 0);
            tMap.put(c, count + 1);
        }

        int targetLength = s1.length();

        int left = 0;
        int right = 0;

        int count = 0;

        while (right < s2.length()) {
            char char2Add = s2.charAt(right);
            right++;

            // 为目标字符
            if (tMap.containsKey(char2Add)) {
                int newCount = sMap.getOrDefault(char2Add, 0) + 1;

                sMap.put(char2Add, newCount);

                int targetCount = tMap.get(char2Add);

                if (newCount == targetCount) {
                    count++;
                }

            }

            // 字符长度已经匹配
            if (right - left == targetLength) {
                if (count == tMap.size()) {
                    return true;
                }

                char removeChar = s2.charAt(left);
                left++;

                if (tMap.containsKey(removeChar)) {
                    int existCount = sMap.get(removeChar);
                    sMap.put(removeChar, existCount - 1);
                    int targetCount = tMap.get(removeChar);
                    if (existCount == targetCount) {
                        count--;
                    }
                }
            }


        }

        return false;

    }

}
