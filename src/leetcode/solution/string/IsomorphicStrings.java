package leetcode.solution.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 205. Isomorphic Strings
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg";
        String s1 = "add";
        IsomorphicStrings solution = new IsomorphicStrings();
        System.out.println(solution.isIsomorphic(s, s1));
    }


    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length();
        Map<Character, Character> memo = new HashMap<>();

        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char charA = s.charAt(i);
            char charB = t.charAt(i);

            if (memo.containsKey(charA)) {
                if (memo.get(charA) != charB) {
                    return false;
                }
            } else {
                if (visited.contains(charB)) {
                    return false;
                }

                memo.put(charA, charB);
                visited.add(charB);
            }
        }

        return true;
    }

}
