package leetcode.solution.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 */
public class GroupAnagrams {


    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> ans = groupAnagrams.groupAnagrams(s);
        System.out.println(ans);
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> memo = new HashMap<>();

        for (String str : strs) {
            char[] ca = new char[26];
            for (char c : str.toCharArray()) {
                ca[c - 'a']++;

                System.out.println(ca[c - 'a']);
            }

            System.out.println(ca);
            String key = String.valueOf(ca);
            System.out.println(key);
            if (memo.containsKey(key)) {
                List<String> values = memo.get(key);
                values.add(str);
            } else {
                List<String> valueList = new ArrayList<>();
                valueList.add(str);
                memo.put(key, valueList);
            }

        }

        return new ArrayList<>(memo.values());
    }
}
