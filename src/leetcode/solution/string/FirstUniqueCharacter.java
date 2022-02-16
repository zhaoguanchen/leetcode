package leetcode.solution.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar1(s));
    }

    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }

        }
        return -1;
    }


    public static int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer value = map.getOrDefault(c, 0);
            map.put(c, value + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }

        }
        return -1;

    }
}
