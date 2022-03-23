package leetcode.solution.SlideWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String ans = minimumWindowSubstring.minWindow(s, t);
        System.out.println(ans);
        // "BANC"
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> sourceMap = new HashMap<>();

        // target字符串存储到map
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer existCount = targetMap.getOrDefault(c, 0);
            targetMap.put(c, ++existCount);
        }

        // 最小字串的长度，初始设为最大值
        int ansLength = Integer.MAX_VALUE;
        // 最小字串的起始下标
        int startIndex = 0;
        // 双指针维护一个左闭右开的区间[ , ）
        int left = 0;
        int right = 0;


        int count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (targetMap.containsKey(c)) {
                Integer existCount = sourceMap.getOrDefault(c, 0);
                sourceMap.put(c, ++existCount);
                if (existCount.equals(targetMap.get(c))) {
                    count++;
                }
            }

            right++;

            int expectCount = targetMap.size();
            // 所有字符及个数都匹配
            while (count == expectCount) {
                int currentLength = right - left;

                // 存在更小字串，则更新结果
                if (currentLength < ansLength) {
                    ansLength = currentLength;
                    startIndex = left;
                }

                // 左边将要移除的字符
                char removeChar = s.charAt(left);
                left++;

                if (targetMap.containsKey(removeChar)) {
                    if (sourceMap.get(removeChar).equals(targetMap.get(removeChar))) {
                        count--;
                    }
                    sourceMap.put(removeChar, sourceMap.get(removeChar) - 1);
                }
            }

        }

        if (ansLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIndex, startIndex + ansLength);

    }


}
