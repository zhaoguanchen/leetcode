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
        // 目标串字符对应的哈希表
        Map<Character, Integer> targetMap = new HashMap<>();
        // 遍历串字符对应的哈希表
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


        // 右指针向右移动，出现满足条件时，记录结果。
        // 然后左指针移动，直到不满足条件。右指针移动，进行下一循环。
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

            // 需要匹配的字符数
            int expectCount = targetMap.size();
            // 当所有字符及个数都匹配，更新结果，左指针移动
            while (count == expectCount) {
                // 当前符合条件的子串的长度
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
                    // 遇到包含字符时，匹配数减一；跳出循环
                    if (sourceMap.get(removeChar).equals(targetMap.get(removeChar))) {
                        count--;
                    }
                    sourceMap.put(removeChar, sourceMap.get(removeChar) - 1);
                }
            }

        }

        // 没有结果，返回空
        if (ansLength == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(startIndex, startIndex + ansLength);

    }


}
