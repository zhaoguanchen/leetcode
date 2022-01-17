package solution.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290. Word Pattern
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 */
public class WordPattern {

    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String pattern = "abba";
        System.out.println(wordPattern(pattern, s));

    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        String[] str = s.split(" ");
        if (str.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < str.length; i++) {
            char c = pattern.charAt(i);
            String target = str[i];
            if (map.containsKey(c)) {
                String saved = map.get(c);
                if (!target.equals(saved)) {
                    return false;
                }
            } else {
                if (set.contains(target)) {
                    return false;
                }
                set.add(target);
                map.put(c, target);
            }
        }
        return true;
    }
}