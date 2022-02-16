package leetcode.solution.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInteger {

    public static void main(String[] args) {
        String s = "CDXXXIII";


        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int base = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            char cur = s.charAt(i);
            char pro = s.charAt(i + 1);
            if (map.get(pro) > map.get(cur)) {
                base = base - map.get(cur);

            } else {
                base = base + map.get(cur);
            }
        }
        base = base + map.get(s.charAt(s.length() - 1));
        return base;
    }
}
